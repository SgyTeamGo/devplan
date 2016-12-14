package service;

import model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by meruzhan.gasparyan on 29-Nov-16.
 */


public interface UserService {

    List<User> loadAll(Map<String, String> orders);

    User loadById(Long id);

    User loadByFirstName(String firstName);

    Map<String, Object> signIn(String userName, String password);

    User loadUserByUserName(String userName);

    void delete(User user);

    User save(User user);


}
