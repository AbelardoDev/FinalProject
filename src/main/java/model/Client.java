package model;

public record Client(int id, String name, RequestType requestType, Priority priority) {
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requestType=" + requestType +
                ", priority=" + priority +
                '}';
    }
}
