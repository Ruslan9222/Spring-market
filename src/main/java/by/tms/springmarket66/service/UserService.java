package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(User user) {
        userDao.save(user);
    }

    public List<User> viewAllUsers() {
        return userDao.findAllUsers();
    }

    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    public void updateUser(long id,User user) {
        userDao.updateUserProfileById(id,user);
    }
    public void setSeller(long id,User user){
        userDao.updateUserByIdGetSeller(id,user);
    }
}
