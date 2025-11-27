package controller;

import model.*;
import model.Action;
import view.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final CustomerService model;
    private final View view;
    private final AddClientView addClientView;
    private final TaskHistoryView taskHistoryView;
    private final SearchView searchView;
    private boolean attend;

    public Controller() {
        model = new CustomerService();
        view = new View();
        addClientView = new AddClientView();
        taskHistoryView = new TaskHistoryView();
        searchView = new SearchView();
        attend = true;
        events();
    }

    public void initialize() {
        view.setVisible(true);
    }

    public void waitingTable() {
        DefaultTableModel tModel = (DefaultTableModel) view.getWaitingTable().getModel();
        cleanTable(tModel);
        Object[] rows =  new Object[4];
        for(Client c : model.getWaitingClients()){
            rows[0] = c.id();
            rows[1] = c.name();
            rows[2] = c.requestType();
            rows[3] = c.priority();
            tModel.addRow(rows);
        }
    }

    private void attendTable() {
        DefaultTableModel tModel = (DefaultTableModel) view.getAttendTable().getModel();
        cleanTable(tModel);
        Object[] rows =  new Object[4];
        for(Client c : model.getAttendedClients()){
            rows[0] = c.id();
            rows[1] = c.name();
            rows[2] = c.requestType();
            rows[3] = c.priority();
            tModel.addRow(rows);
        }
    }

    public void historyTable(){
        DefaultTableModel tModel = (DefaultTableModel) taskHistoryView.getTaskTable().getModel();
        cleanTable(tModel);
        Object[] rows =  new Object[3];
        for(Action a : model.getActionsHistory()){
            rows[0] = a.getType();
            rows[1] = a.getClient().name();
            rows[2] = a.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss"));
            tModel.addRow(rows);
        }
    }

    public void cleanTable(DefaultTableModel model){
        model.setRowCount(0);
    }

    public void count(){
        view.getLblWaiting().setText("Clientes en espera: " +  model.getWaitingClients().size());
        view.getLblAttend().setText("Clientes atendidos: "  +  model.getAttendedClients().size());
    }

    private void seeAddClient() {
        addClientView.setVisible(true);
    }

    public void closeAddClient() {
        addClientView.setVisible(false);
    }

    private void addClient() {
        int id = Integer.parseInt(addClientView.getTflId().getText());
        String name = addClientView.getTflName().getText();
        RequestType rt = requestType();
        Priority priority = priority();
        Client client = new Client(id, name, rt, priority);
        model.addClient(client);
        waitingTable();
        closeAddClient();
        count();
        model.registerAction(ActionType.ADD, client, view.getTxtAttend().getText());
        view.getTxtAttend().setText(client.name() + " fue ingresado a la cola de espera.");
    }

    private RequestType requestType() {
        return switch (addClientView.getCbxRequestType().getSelectedIndex()) {
            case 0 -> RequestType.SUPPORT;
            case 1 -> RequestType.MAINTENANCE;
            case 2 -> RequestType.CLAIM;
            default -> null;
        };
    }

    private Priority priority() {
        return switch (addClientView.getCbxPriority().getSelectedIndex()){
            case 0 -> Priority.NORMAL;
            case 1 -> Priority.URGENT;
            default -> null;
        };
    }

    public void attendClient() {
        if(model.getWaitingClients().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes para atender.");
        } else if (!attend) {
            JOptionPane.showMessageDialog(null, "Aún no ha terminado de atender al cliente actual.");
        } else {
            model.setBeginTime();
            model.attendClient();
            model.getTempText().push(view.getTxtAttend().getText());
            view.getTxtAttend().setText(model.getTempClient().name() + " está siendo atendido.");
            waitingTable();
            count();
            attend = false;
        }
    }

    private void endAttendClient() {
        if(attend) {
            JOptionPane.showMessageDialog(null, "No está atendiendo a ningún cliente.");
        } else {
            model.setEndTime();
            model.addAttendTime();
            timeAverage();
            model.addAttendedClient();
            attendTable();
            count();
            attend = true;
            model.registerAction(ActionType.ATTEND, model.getTempClient(), view.getTxtAttend().getText());
            view.getTxtAttend().setText(model.getTempClient().name() + " fue atendido exitosamente.");
        }
    }

    private void timeAverage() {
        view.getLblAverageTime().setText("Tiempo promedio de atención: " + model.averageTime());
    }

    private void removeClient() {
        if(view.getWaitingTable().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el cliente que desea eliminar.");
        } else {
            Client client = model.getClientById(Integer.parseInt(view.getWaitingTable().getValueAt(view.getWaitingTable().getSelectedRow(), 0).toString()));
            model.getRemovePositions().addFirst(view.getWaitingTable().getSelectedRow());
            model.removeClient(client);
            waitingTable();
            count();
            model.registerAction(ActionType.REMOVE, client, view.getTxtAttend().getText());
            view.getTxtAttend().setText(client.name() + " fue eliminado de la cola de espera.");
        }
    }

    private void searchClient() {
        if(view.getJToggleButton().isSelected())
            searchById();
        else
            searchTable();
    }

    private void searchById() {
        int id = Integer.parseInt(view.getTflId().getText());
        if(model.searchClientById(id) == null)
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        else
            model.showInfoClient(model.searchClientById(id));
    }

    private List<Client> searchByCategory() {
        List<Client> clients = new ArrayList<>();
        return switch (view.getCbxRequestType().getSelectedIndex()) {
            case 0 -> model.searchClientByCategory(RequestType.SUPPORT);
            case 1 -> model.searchClientByCategory(RequestType.MAINTENANCE);
            case 2 -> model.searchClientByCategory(RequestType.CLAIM);
            default -> null;
        };
    }

    private void searchTable() {
        DefaultTableModel tModel = (DefaultTableModel) searchView.getJTable1().getModel();
        cleanTable(tModel);
        Object[] rows =  new Object[4];
        for(Client c : searchByCategory()){
            rows[0] = c.id();
            rows[1] = c.name();
            rows[2] = c.requestType();
            rows[3] = c.priority();
            tModel.addRow(rows);
        }
        searchView.setVisible(true);
    }

    private void undo() {
        if(model.getActions().isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay acciones para deshacer.");
        } else {
            ActionType action = model.getActions().getLast().getType();
            switch (action) {
                case ADD -> addUndo();
                case ATTEND -> attendUndo();
                case REMOVE -> removeUndo();
            }
            count();
            model.registerAction(ActionType.UNDO, new Client(0, action.toString(), RequestType.SUPPORT, Priority.NORMAL), "");
        }
    }

    private void addUndo() {
        Action action = model.getActions().pop();
        model.getWaitingClients().removeLast();
        view.getTxtAttend().setText(action.getText());
        waitingTable();
    }

    private void attendUndo() {
        Action action = model.getActions().pop();
        model.getAttendedClients().removeLast();
        model.getWaitingClients().addFirst(action.getClient());
        model.getAttendTime().removeLast();
        view.getTxtAttend().setText(model.getTempText().pop());
        timeAverage();
        waitingTable();
        attendTable();
    }

    private void removeUndo() {
        Action action = model.getActions().pop();
        model.setWaitingClients(insertInPosition(action.getClient(), model.getRemovePositions().pop()));
        view.getTxtAttend().setText(action.getText());
        waitingTable();
    }

    private ArrayDeque<Client> insertInPosition(Client newClient, int position){
        int i = 0;
        ArrayDeque<Client> temp = new ArrayDeque<>();
        for(Client c : model.getWaitingClients()){
            if(i == position)
                temp.add(newClient);
            temp.add(c);
            i++;
        }
        if(model.getWaitingClients().size() == position)
            temp.add(newClient);
        return temp;
    }

    private void history() {
        if(model.getActionsHistory().isEmpty()){
            JOptionPane.showMessageDialog(null, "Aún no ha realizado acciones.");
        } else {
            taskHistoryView.setVisible(true);
            historyTable();
        }
    }

    private void infoClient() {
        model.showInfoClient(model.getClientWithAction(taskHistoryView.getTaskTable().getSelectedRow()));
    }

    private void simulation() {
        simulator();
    }

    public void events(){
        view.getBtnAddClient().addActionListener(e -> seeAddClient());
        view.getBtnAttendClient().addActionListener(e -> attendClient());
        view.getBtnRemoveClient().addActionListener(e -> removeClient());
        view.getBtnEndAttend().addActionListener(e -> endAttendClient());
        view.getBtnSearchClient().addActionListener(e -> searchClient());
        view.getBtnUndo().addActionListener(e -> undo());
        view.getBtnHistory().addActionListener(e -> history());
        view.getBtnSimulation().addActionListener(e -> simulation());
        addClientView.getBtnAddClient().addActionListener(e -> addClient());
        taskHistoryView.getBtnInfoClient().addActionListener(e -> infoClient());
        taskHistoryView.getBtnUndo().addActionListener(e -> undo());
    }

    private void simulator(){
        model.setTimer(new Timer(2500, e -> {
            step(model.getCurrentStep());
        }));
        model.getTimer().start();
    }

    private void step(int step){
        switch (step){
            case 0 -> {
                addClientView.getTflId().setText("1007");
                addClientView.getTflName().setText("Tralalelo");
                addClientView.getCbxRequestType().setSelectedIndex(1);
                addClientView.getCbxPriority().setSelectedIndex(1);
                addClient();
            }
            case 1 -> {
                addClientView.getTflId().setText("56124");
                addClientView.getTflName().setText("Tralalá");
                addClientView.getCbxRequestType().setSelectedIndex(1);
                addClientView.getCbxPriority().setSelectedIndex(0);
                addClient();
                int index = view.getWaitingTable().getRowCount() - 2;
                view.getWaitingTable().setRowSelectionInterval(index, index);
            }
            case 2 -> {
                removeClient();
            }
            case 3 -> {
                undo();
            }
            case 4 -> {
                attendClient();
            }
            case 5 -> {
                endAttendClient();
            }
            case 6 -> {
                attendClient();
            }
            case 7 -> {
                endAttendClient();
            }
            case 8 -> {
                attendClient();
            }
            case 9 -> {
                endAttendClient();
            }
            case 10 -> {
                view.getCbxRequestType().setSelectedIndex(1);
                searchClient();
            }
            case 11 -> {
                searchView.setVisible(false);
            }
            case 12 -> {
                view.getJToggleButton().setSelected(true);
                view.getTflId().setText("1007");
                searchClient();
            }
            case 13 -> {
                history();
                model.getTimer().stop();
            }
        }
        step++;
        model.setCurrentStep(step);
    }
}
