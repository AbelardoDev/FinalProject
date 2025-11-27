package model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Action {
    private final ActionType type;
    private final Client client;
    private final LocalDateTime date;
    private String text;
    public Action(ActionType type, Client client, String text) {
        this.type = type;
        this.client = client;
        this.date = LocalDateTime.now();
        this.text = text;
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
