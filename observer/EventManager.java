package observer;

import java.util.*;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<String, List<EventListener>>();

    public EventManager(String... operations) {
        for (String op : operations) {
            listeners.put(op, new ArrayList<EventListener>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    public void notify(String eventType, String message) {
        for (EventListener listener : listeners.get(eventType)) {
            listener.update(eventType, message);
        }
    }
}
