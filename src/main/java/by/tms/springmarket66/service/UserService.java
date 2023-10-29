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

    public void save(User user) {
        userDao.save(user);
    }

    public User getUserByEmail(String email) {
        User byUser = new User();
        Optional<User> currentUser = Optional.ofNullable(userDao.findUserByEmail(email));
        if(currentUser.isPresent()) {
            User user = currentUser.get();
            if (user.getEmail().equals(email)){
                byUser.setEmail(user.getEmail());
                byUser.setId(user.getId());
                byUser.setRoles(new HashSet<>(user.getRoles()));
                byUser.setPassword(user.getPassword());
            }
        }
            return byUser;
    }

    public void updateUserById(Long id, User user) {
        userDao.updateUserProfileById(id, user);
    }

    public void deleteById(Long id) {
        userDao.removeById(id);
    }

    public List<Contact> getContactById(Long id) {
        return userDao.findContactByOwnerId(id);
    }
}
