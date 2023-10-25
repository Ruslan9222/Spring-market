package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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
        Query<User> query = currentSession.createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    public void updateUserProfileByEmail(String email, User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        User userProfile = currentSession.get(User.class, email);
        userProfile.setFirstName(user.getFirstName());
        userProfile.setLastName(user.getLastName());
        userProfile.setUsername(user.getUsername());
        userProfile.setPassword(user.getPassword());
        currentSession.update(userProfile);
    }

    public void removeByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        User userDel = findUserByEmail(email);
        userDel.setEmail(email);
        currentSession.delete(userDel);
    }
}
