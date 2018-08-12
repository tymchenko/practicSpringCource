package services;

import db.AuditoriumDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Auditorium;

import java.util.List;

public class AuditoriumService {
    private AuditoriumDao dao;

    public AuditoriumService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        dao = (AuditoriumDao) context.getBean("auditoriumDao");
    }

    public Auditorium getByName(String name){
        return dao.getByName(name);
    }

    public List<Auditorium> getAll(){
        return dao.getAll();
    }

}
