package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.EventService;

import java.io.IOException;
import java.util.Map;

/**
 * Created by zaven.chilingaryan on 12/2/2016.
 */
@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String loadAllEvents(@RequestParam Map<String, String> params) throws JsonProcessingException {

        System.out.println(params);
        return mapper.writeValueAsString(eventService.loadAllEvents());
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String loadEventById(@PathVariable Long id) throws JsonProcessingException {
        return mapper.writeValueAsString(eventService.loadEventById(id));
    }


    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> deleteEvent(@RequestBody String jsonInString) throws IOException {
        Event event = mapper.readValue(jsonInString, Event.class);
        eventService.deleteEvent(event);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String saveEvent(@RequestBody String jsonInString) throws IOException {
        Event event = mapper.readValue(jsonInString, Event.class);
        return mapper.writeValueAsString((eventService.saveEvent(event)).getId());
    }


}
