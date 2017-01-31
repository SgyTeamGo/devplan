package app.controller;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EventService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Event> loadAllEvents(/*HttpServletResponse response, */@RequestParam Map<String, String> params) {
//        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println(params);
        return eventService.loadAllEvents();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Event loadEventById(@PathVariable Long id) {
        return eventService.loadEventById(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> deleteEvent(@RequestBody Event event) {
        eventService.deleteEvent(event);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Long saveEvent(@RequestBody Event event) {
        return (eventService.saveEvent(event)).getId();
    }


}
