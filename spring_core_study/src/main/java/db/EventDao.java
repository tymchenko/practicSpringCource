package db;

import utils.RandomUtils;
import vo.Event;

import java.util.*;
import java.util.stream.Collectors;

public class EventDao {
    private Map<Long, Event> events = new HashMap();

    public void save(Event event) {
        event.setId(new RandomUtils().getRandomLong());
        events.put(event.getId(), event);
    }

    public void remove(Event event) {
        events.remove(event.getId());
    }

    public Event getById(Long id) {
        return events.get(id);
    }

    public Event getByName(String name) {
        return getAll().stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    public List<Event> getAll() {
        return events.values().stream().collect(Collectors.toList());
    }

    public List<Event> getNextEvents(Date to) {
        return getForDateRange(new Date(), to);
    }

    public List<Event> getForDateRange(Date from, Date to) {
        if (events.size() == 0) {
            return null;
        }

        List<Event> neededEvents = new LinkedList<>();
        for (Long key : events.keySet()) {
            boolean is = events.get(key).getDates().get(0).before(to);
            if (events.get(key).getDates().get(0).before(to)
                    && events.get(key).getDates().get((events.get(key).getDates().size() - 1)).after(from)) {
                neededEvents.add(events.get(key));
            }
        }
        return neededEvents;
    }
}
