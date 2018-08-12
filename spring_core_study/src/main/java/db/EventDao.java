package db;

import vo.Event;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventDao {
    private Map<Long, Event> events = new HashMap();

    public void save(Event event){
        events.put(event.getId(), event);
    }

    public void remove(Event event){
        events.remove(event.getId());
    }

    public Event getById(Long id){
        return events.get(id);
    }

    public Event getByName(String name){
        return getAll().stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    public List<Event> getAll(){
        return events.values().stream().collect(Collectors.toList());
    }

    public List<Event> getForDateRange(Date from, Date to){
        return null;
    }

    public List<Event> getNextEvents(Date to){
        return null;
    }
}
