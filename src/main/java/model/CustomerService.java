package model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Getter
public class CustomerService {
    private ArrayDeque<Client> waitingClients;
    private List<Client> attendedClients;
    private Stack<Action> actionsHistory;
    private LocalDateTime currentTime;

    public CustomerService() {
        waitingClients = new ArrayDeque<>();
        attendedClients = new ArrayList<>();
        actionsHistory = new Stack<>();
    }

    public void addClient(Client client) {
        waitingClients.add(client);
    }

    public void removeClient(Client client) {
        waitingClients.remove(client);
    }

    public void addAttendedClient(Client client) {
        attendedClients.add(client);
        waitingClients.remove(client);
    }

    public Client searchClientById(int id) {
        for (Client c : waitingClients) {
            if(c.id() == id)
                return c;
        }
        return null;
    }

    public List<Client> searchClientByCategory(RequestType requestType) {
        List<Client> clients = new ArrayList<>();
        for (Client c : waitingClients) {
            if(c.requestType() == requestType){
                clients.add(c);
            }
        }
        return clients;
    }

    public void registerAction(Client client, ActionType actionType) {
        if(ActionType.ADD == actionType){

        }
    }

    public void showActions() {
        for (Action a : actionsHistory) {
            System.out.println(a);
        }
    }
}
