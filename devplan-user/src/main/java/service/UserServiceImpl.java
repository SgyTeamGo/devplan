package service;

import dao.UserDao;
import filter.Filter;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meruzhan.gasparyan on 29-Nov-16.
 */

@Service("userService")
@Repository
@Transactional
@PropertySource("classpath:token.config.properties")
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private Filter<User> filterUser;
    @Autowired
    private Environment properties;

    public List<User> loadAll(Map<String, String> orders) {

        if (orders == null || orders.isEmpty()) {
            return (List<User>) userDao.findAll();
        }
        filterUser.setFilters(orders);
        return (List<User>) userDao.findAll(filterUser);
    }


    public User loadById(Long id) {
        return userDao.findOne(id);
    }

    public User loadByFirstName(String firstName) {
        return userDao.findByFirstName(firstName);
    }

    public Map<String, Object> signIn(String userName, String password) {
        User user = userDao.findByUserName(userName);
        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException();
        }
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("user", user);
        map.put("token", JwtUtil.generateToken(user, properties.getProperty("token.singining.key")));
        return map;
    }

    public User loadUserByUserName(String userName) {
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

    @Autowired
    public void setFilterUser(Filter<User> filterUser) {
        this.filterUser = filterUser;
    }
}
