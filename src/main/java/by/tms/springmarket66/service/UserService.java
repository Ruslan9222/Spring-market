package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.Contact;
import by.tms.springmarket66.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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
        User byUser = new User();
        Optional<User> currentUser = Optional.ofNullable(userDao.findUserByEmail(email));
        if(currentUser.isPresent()) {
            User user = currentUser.get();
            if (user.getEmail().equals(email)){
                byUser.setEmail(user.getEmail());
                byUser.setId(user.getId());
                byUser.setRoles(new HashSet<>(user.getRoles()));
            }
        }
        System.out.println(byUser+"userservice");
            return byUser;

    }

    public void updateUserById(Long id, User user) {
        userDao.updateUserProfileById(id, user);
    }

    public void deleteUser(String email) {
        userDao.removeByEmail(email);
    }

    public List<Contact> findContactsById(Long id) {
        return userDao.findContactByOwnerId(id);
    }
}
