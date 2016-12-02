package service;

import model.Event;

import java.util.Date;
import java.util.List;

/**
 * Created by srapion.hunanyan on 12/1/2016.
 */
public interface EventService {

    List<Event> loadAllEvents();

    Event loadEventById(long id);

    List<Event> loadByStartDate(Date startDate);

    List<Event> loadByTitle(String title);

    void deleteEvent(Event event);

    Event saveEvent(Event event);

}
