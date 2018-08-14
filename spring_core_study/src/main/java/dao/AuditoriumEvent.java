package dao;

import vo.Auditorium;
import vo.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuditoriumEvent {
    Map<Auditorium, List<Event>> auditoriumEventRelation = new HashMap<>();
}
