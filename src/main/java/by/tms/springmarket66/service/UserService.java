package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void create(User user){
        userDao.save(user);
    }
    public List<User> viewAllUsers(){
        return userDao.findAllUsersWithJpql();
    }

    public User findUserById(long id){
        return userDao.findUserById(id);
    }
    public void updateUser(User user){
        userDao.updateUserProfileById(user);
    }



}
