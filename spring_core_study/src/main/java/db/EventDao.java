package db;

import vo.Event;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDao {
    private Map<Long, Event> events = new HashMap();
    public void save(Event event){

    }

    public void remove(){

    }

    public Event getById(Long id){
        return null;
    }

    public Event getByName(String name){
        return null;
    }

    public List<Event> getAll(){
        return null;
    }

    public List<Event> getForDateRange(Date from, Date to){
        return null;
    }

    public List<Event> getNextEvents(Date to){
        return null;
    }
}
