package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.Contact;
import by.tms.springmarket66.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public User findUserByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("SELECT u FROM User u JOIN FETCH u.roles " +
                "WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        /*return query.uniqueResult();*/
        return query.getSingleResult();
    }

    public void updateUserProfileById(Long id, User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        User userProfile = currentSession.get(User.class, id);
        userProfile.setFirstName(user.getFirstName());
        userProfile.setLastName(user.getLastName());
        userProfile.setUsername(user.getUsername());
        userProfile.setPassword(user.getPassword());
        currentSession.update(userProfile);
    }

    public void updateUserContactById(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        User userById = currentSession.get(User.class, user.getId());
        userById.setContacts(user.getContacts());
        currentSession.update(userById);
    }

    public void removeById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        currentSession.delete(user);
    }

    public List<Contact> findContactByOwnerId(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        return user.getContacts();
    }

    public User findUserById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("FROM User", User.class);
        return currentSession.get(User.class,id);
    }

}
