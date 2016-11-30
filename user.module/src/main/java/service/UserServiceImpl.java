package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by meruzhan.gasparyan on 29-Nov-16.
 */


@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    public List<User> loadAll() {
        return (List<User>) userDao.findAll();
    }

    public User loadById(Long id) {
        return userDao.findOne(id);
    }

    public User loadByFirstName(String firstName) {
        return userDao.findByFirstName(firstName);
    }


    public User loadByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public void delete(User user) {
        userDao.delete(user);
    }


    public User save(User user) {
        return userDao.save(user);
    }


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}
