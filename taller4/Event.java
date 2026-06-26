import java.time.LocalDate;

public class Event implements Comparable<Event> {
    private final int id;
    private final String title;
    private EventState estado;
    private final int importancia;
    private final LocalDate fecha;
    public Event(int id, String title, int importancia, LocalDate fecha) {
        this.id = id;
        this.title = title;
        this.estado = EventState.PENDING;
        this.importancia = importancia;
        this.fecha = fecha;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public EventState getEstado() {
        return estado;
    }
    public void setEstado(EventState estado) {
        this.estado = estado;
    }
    public int getImportancia() {
        return importancia;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.id, other.id);
    }
    @Override
    public String toString() {
        return "Event{id=" + id + ", title='" + title + '\'' + ", estado=" + estado + ", importancia=" + importancia + ", fecha=" + fecha + '}';
    }
}
