package dao;

import vo.Event;
import vo.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketDao {
    private Map<Event, List<Ticket>> tickets = new HashMap<>();
}
