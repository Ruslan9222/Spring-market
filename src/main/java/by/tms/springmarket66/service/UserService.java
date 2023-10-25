package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(User user) {
        userDao.save(user);
    }

    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    public void updateUserById(String email, User user) {
        userDao.updateUserProfileByEmail(email, user);
    }

    public void deleteUser(String email) {
        userDao.removeByEmail(email);
    }
}
