package service;

import model.User;

import java.util.List;

/**
 * Created by meruzhan.gasparyan on 29-Nov-16.
 */


public interface UserService {

    List<User> loadAll();

    User loadById(Long id);

    User loadByFirstName(String firstName);

    User loadByUserName(String userName);

    void delete(User user);

    User save(User user);


}
