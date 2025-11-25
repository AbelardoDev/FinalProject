package controller;

import model.*;
import model.Action;
import view.AddClientView;
import view.SearchView;
import view.TaskHistoryView;
import view.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private CustomerService model;
    private View view;
    private AddClientView addClientView;
    private TaskHistoryView taskHistoryView;
    private SearchView searchView;
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
            rows[2] = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(a.getDate());
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
        model.registerAction(ActionType.ADD, client);
        waitingTable();
        closeAddClient();
        count();
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
            view.getTxtAttend().setText(model.getTempClient().name() + " fue atendido exitosamente.");
            attendTable();
            count();
            attend = true;
            model.registerAction(ActionType.ATTEND, model.getTempClient());
        }
    }

    private void timeAverage() {
        view.getLblAverageTime().setText("Tiempo promedio de atención: " + model.averageTime());
    }

    private void removeClient() {
        if(view.getWaitingTable().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el cliente que desea eliminar.");
        } else {
            Client client = model.searchClientById(Integer.parseInt(view.getWaitingTable().getValueAt(view.getWaitingTable().getSelectedRow(), 0).toString()));
            model.removeClient(client);
            waitingTable();
            count();
            model.registerAction(ActionType.REMOVE, client);
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
        count();
    }

    private void history() {
        taskHistoryView.setVisible(true);
        historyTable();
    }

    private void infoClient() {
        model.showInfoClient(model.getClientWithAction(taskHistoryView.getTaskTable().getSelectedRow()));
    }

    private void simulation() {

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
}
