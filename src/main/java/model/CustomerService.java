package model;

import lombok.Getter;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Getter
public class CustomerService {
    private ArrayDeque<Client> waitingClients;
    private List<Client> attendedClients;
    private Stack<Action> actionsHistory;
    private LocalTime beginTime;
    private LocalTime endTime;
    private List<Integer> attendTime;
    private Client tempClient;

    public CustomerService() {
        waitingClients = new ArrayDeque<>();
        attendedClients = new ArrayList<>();
        actionsHistory = new Stack<>();
        attendTime = new ArrayList<>();
    }

    public void addClient(Client client) {
        waitingClients.add(client);
    }

    public void removeClient(Client client) {
        waitingClients.remove(client);
    }

    public void attendClient() {
        tempClient = waitingClients.poll();
    }

    public void addAttendedClient() {
        attendedClients.add(tempClient);
    }

    public Client searchClientById(int id) {
        for (Client c : attendedClients) {
            if(c.id() == id)
                return c;
        }
        return null;
    }

    public List<Client> searchClientByCategory(RequestType requestType) {
        List<Client> clients = new ArrayList<>();
        for (Client c : attendedClients) {
            if(c.requestType() == requestType){
                clients.add(c);
            }
        }
        return clients;
    }

    public void registerAction(ActionType actionType, Client client) {
        actionsHistory.addFirst(new Action(actionType, client));
    }

    public void showInfoClient(Client client) {
        JOptionPane.showMessageDialog(null, client);
    }

    public Client getClientWithAction(int id) {
        return actionsHistory.get(id).getClient();
    }

    private int attentionSeconds(){
        return endTime.toSecondOfDay() - beginTime.toSecondOfDay();
    }

    public void addAttendTime() {
        attendTime.add(attentionSeconds());
    }

    public void setBeginTime(){
        beginTime = LocalTime.now();
    }

    public void setEndTime(){
        endTime = LocalTime.now();
    }

    public String averageTime(){
        if (attendTime == null || attendTime.isEmpty()) {
            return "0 m 0 s";
        }
        int totalSeconds = 0;
        for (Integer i : attendTime) {
            totalSeconds += i;
        }
        int secondsAverage = totalSeconds / attendTime.size();
        int minutes = secondsAverage / 60;
        int seconds = secondsAverage % 60;
        return minutes + " m " + seconds + " s";
    }
}
