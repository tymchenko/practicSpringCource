package db;

import vo.Auditorium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuditoriumDao {
    private final Map<Long, Auditorium> auditoriums = new HashMap();

    public void save(Auditorium auditorium){
        auditoriums.put(auditorium.getId(), auditorium);
    }

    public void remove(Auditorium Auditorium){
        auditoriums.remove(Auditorium.getId());
    }

    public Auditorium getById(Long id){
        return auditoriums.get(id);
    }

    public Auditorium getByName(String name){
        return getAll().stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    public List<Auditorium> getAll(){
        return auditoriums.values().stream().collect(Collectors.toList());
    }
}
