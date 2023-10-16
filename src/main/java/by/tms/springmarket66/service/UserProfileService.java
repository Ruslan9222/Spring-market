package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired
    private UserDao userDao;

    public void create(User user){
        userDao.save(user);
    }

    public User findUserById(long id){
        return userDao.findUserById(id);
    }
    public void updateUser(User user){
        userDao.updateUserProfileById(user);
    }



}
