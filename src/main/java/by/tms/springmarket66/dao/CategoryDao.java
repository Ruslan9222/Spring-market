package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CategoryDao {

    private final SessionFactory sessionFactory;

    public CategoryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(category);
    }

    public List<Category> viewAllCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public Category findCategoryById (long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Category.class, id);
    }

    public void delete(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(id);
    }

    public void updateCategory(long id, Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category categories = currentSession.get(Category.class, id);
        categories.setName(category.getName());
        currentSession.update(categories);
    }
}
