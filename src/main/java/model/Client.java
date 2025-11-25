package model;

public record Client(int id, String name, RequestType requestType, Priority priority) {
    @Override
    public String toString() {
        return "ID: " + id +
                "\nNombre: " + name +
                "\nTipo de solicitud: " + requestType +
                "\nPrioridad: " + priority;
    }
}
