import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        EventScheduler scheduler = new EventScheduler(OrderCriteria.BY_IMPORTANCE_DATE);

        scheduler.scheduleEvent(new Event(1, "Reunión de proyecto", 5, LocalDate.of(2026, 7, 1)));
        scheduler.scheduleEvent(new Event(2, "Lanzamiento de campaña", 10, LocalDate.of(2026, 6, 28)));
        scheduler.scheduleEvent(new Event(3, "Reporte mensual", 10, LocalDate.of(2026, 6, 27)));

        Event next = scheduler.getNextEvent();
        System.out.println("Siguiente evento: " + next);

        scheduler.markAsCompleted(next.getId());
        System.out.println("Evento completado: " + scheduler.getEventById(next.getId()));
    }
}
