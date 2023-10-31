package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.Contact;
import by.tms.springmarket66.entity.Type;
import by.tms.springmarket66.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContactService {
    private final UserDao userDao;


    public ContactService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Set<String> getAllTypeOfContacts() {
        Set<String> typesOfContacts = new HashSet<>();
        for (Type type : Type.values()) {
            typesOfContacts.add(type.name());
        }
        return typesOfContacts;
    }

    public void updateContactByIdUser(User user){
        userDao.updateUserContactById(user);
    }



}
