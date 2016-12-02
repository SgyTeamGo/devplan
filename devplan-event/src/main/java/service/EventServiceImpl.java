package service;

import dao.EventDao;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by srapion.hunanyan on 12/1/2016.
 */
@Service("eventService")
@Repository
@Transactional
public class EventServiceImpl implements EventService {

    EventDao eventDao;

    @Autowired
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public List<Event> loadAllEvents() {
        return (List<Event>) eventDao.findAll();
    }

    public Event loadEventById(long id) {
        return eventDao.findOne(id);
    }

    public List<Event> loadByStartDate(Date startDate) {
        return eventDao.findEventByStartDate(startDate);
    }

    public List<Event> loadByTitle(String title) {
        return eventDao.findEventsByTitle(title);
    }

    public void deleteEvent(Event event) {
        eventDao.delete(event);
    }

    public Event saveEvent(Event event) {
        return eventDao.save(event);
    }
}
