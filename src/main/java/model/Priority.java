package model;

public enum Priority {
    NORMAL, URGENT;

    @Override
    public String toString() {
        return switch (this) {
            case NORMAL -> "Normal";
            case URGENT -> "Urgente";
            default -> "";
        };
    }
}
