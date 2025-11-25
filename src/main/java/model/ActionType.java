package model;

public enum ActionType {
    ADD, REMOVE, ATTEND, UNDO;

    @Override
    public String toString() {
        return switch (this) {
            case ADD -> "Añadir";
            case REMOVE -> "Eliminar";
            case ATTEND ->  "Atender";
            case UNDO -> "Deshacer";
            default -> "";
        };
    }
}
