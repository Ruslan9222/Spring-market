package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public List<User> findAllUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User findUserById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, id);
    }

    public void updateUserProfileById(long id, User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        User userProfile = currentSession.get(User.class, id);
        userProfile.setFirstName(user.getFirstName());
        userProfile.setLastName(user.getLastName());
        userProfile.setUsername(user.getUsername());
        userProfile.setEmail(user.getEmail());
        userProfile.setPassword(user.getPassword());
        currentSession.update(userProfile);
    }

    public void updateUserByIdGetSeller(Long id, User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        User userProfile = currentSession.get(User.class, id);
        /* userProfile.setRoles(user.setRoles(new Role().setName(RoleName.SELLER));*/

    }
}
