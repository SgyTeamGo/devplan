package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.io.IOException;

/**
 * Created by zaven.chilingaryan on 12/2/2016.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String loadUsers() throws JsonProcessingException {
        return mapper.writeValueAsString(userService.loadAll());
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String loadUserById(@PathVariable Long id) throws JsonProcessingException {
        return mapper.writeValueAsString(userService.loadById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> deleteUser(@RequestBody String jsonInString) throws IOException {
        User user = mapper.readValue(jsonInString, User.class);
        userService.delete(user);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String saveUser(@RequestBody String jsonInString) throws IOException {
        User user = mapper.readValue(jsonInString, User.class);
        return mapper.writeValueAsString((userService.save(user)).getId());
    }

}
