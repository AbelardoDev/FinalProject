package model;

public enum RequestType {
    SUPPORT, MAINTENANCE, CLAIM;

    @Override
    public String toString() {
        return switch (this) {
            case SUPPORT -> "Soporte";
            case MAINTENANCE -> "Mantenimiento";
            case CLAIM -> "Reclamo";
            default -> "";
        };
    }
}
