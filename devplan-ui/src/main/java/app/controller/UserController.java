package app.controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by zaven.chilingaryan on 12/2/2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> loadUsers(@RequestParam Map<String, String> requestParameters) {
        return userService.loadAll(requestParameters);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody

    public User loadUserById(@PathVariable Long id) {
        return userService.loadById(id);

    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        userService.delete(user);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Long saveUser(@RequestBody User user) {
        return (userService.save(user)).getId();
    }

}
