package services;

import db.EventDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Event;

import java.util.Date;
import java.util.List;

public class EventService {
    private EventDao dao;

    public EventService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        dao = (EventDao) context.getBean("eventTable");
    }

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
