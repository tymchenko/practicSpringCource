package services;

import dao.EventDao;
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
        dao.save(event);
    }

    public void remove(Event event){
        dao.remove(event);
    }

    public Event getById(Long id){
        return null;
    }

    public Event getByName(String name){
        return dao.getByName(name);
    }

    public List<Event> getAll(){
        return dao.getAll();
    }

    public List<Event> getForDateRange(Date from, Date to){
        return dao.getForDateRange(from, to);
    }

    public List<Event> getNextEvents(Date to){
        return dao.getNextEvents(to);
    }
}
