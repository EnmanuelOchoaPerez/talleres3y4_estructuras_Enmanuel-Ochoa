import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
public class EventScheduler {
    private final Queue<Event> eventQueue;
    private final Map<Integer, Event> eventMap;
    private final OrderCriteria criteria;

    public EventScheduler(OrderCriteria criteria) {
        this.criteria = criteria;
        this.eventMap = new HashMap<>();
        this.eventQueue = new PriorityQueue<>(this::compareEvents);
    }

    private int compareEvents(Event a, Event b) {
        if (this.criteria == OrderCriteria.BY_ID) {
            return a.compareTo(b);
        }
        int importanceCompare = Integer.compare(b.getImportancia(), a.getImportancia());
        if (importanceCompare != 0) {
            return importanceCompare;
        }
        return a.getFecha().compareTo(b.getFecha());
    }

    public void scheduleEvent(Event event) {
        if (event == null || eventMap.containsKey(event.getId())) {
            return;
        }
        event.setEstado(EventState.PENDING);
        eventMap.put(event.getId(), event);
        eventQueue.offer(event);
    }

    public Event getNextEvent() {
        while (!eventQueue.isEmpty()) {
            Event next = eventQueue.peek();
            if (next.getEstado() != EventState.PENDING) {
                eventQueue.poll();
                continue;
            }
            eventQueue.poll();
            next.setEstado(EventState.IN_PROGRESS);
            return next;
        }
        return null;
    }

    public void markAsCompleted(int eventId) {
        Event event = eventMap.get(eventId);
        if (event != null) {
            event.setEstado(EventState.COMPLETED);
        }
    }

    public Event getEventById(int eventId) {
        return eventMap.get(eventId);
    }
}

