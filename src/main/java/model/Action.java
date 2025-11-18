package model;

import java.time.LocalDateTime;

public class Action {
    private ActionType type;
    private Client client;
    private LocalDateTime date;
    public Action(ActionType type, Client client) {
        this.type = type;
        this.client = client;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Action type: ");
        switch (type) {
            case ADD -> info.append("ADD");
            case REMOVE -> info.append("REMOVE");
            case ATTEND -> info.append("ATTEND");
            case UNDO -> info.append("UNDO");
        }
        info.append("\n");
        info.append(client);
        info.append("\n Date: ");
        info.append(date);
        return info.toString();
    }
}
