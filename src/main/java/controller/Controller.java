package controller;

import model.Client;
import model.CustomerService;
import model.Priority;
import model.RequestType;
import view.AddClientView;
import view.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayDeque;

public class Controller {
    private CustomerService model;
    private View view;
    private AddClientView addClientView;
    private boolean attend;

    public Controller() {
        model = new CustomerService();
        view = new View();
        addClientView = new AddClientView();
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
        model.addClient(new Client(id, name, rt, priority));
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
            model.addAttendedClient();
            view.getTxtAttend().setText(model.getTempClient().name() + " fue atendido exitosamente.");
            attendTable();
            count();
            attend = true;
        }
    }

    private void removeClient() {
        if(view.getWaitingTable().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione el cliente que desea eliminar.");
        } else {
            model.removeClient(model.searchClientById(Integer.parseInt(view.getWaitingTable().getValueAt(view.getWaitingTable().getSelectedRow(), 0).toString())));
            waitingTable();
            count();
        }
    }

    private void searchClient() {

    }

    private void undo() {
        count();
    }

    private void history() {

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
    }
}
