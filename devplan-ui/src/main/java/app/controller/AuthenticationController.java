package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.Map;

/**
 * Created by zaven.chilingaryan on 1/30/2017.
 */

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> logIn(@RequestParam String userName, @RequestParam String password) {
        return userService.signIn(userName, password);
    }
}
