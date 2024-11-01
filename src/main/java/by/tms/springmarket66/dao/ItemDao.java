package by.tms.springmarket66.dao;


import by.tms.springmarket66.entity.Category;
import by.tms.springmarket66.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemDao {
    private final SessionFactory sessionFactory;

    public ItemDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Item item) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(item);
    }

    public List<Item> viewAllItems() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }

    public Item findItemById (long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Item.class, id);
    }

    public void delete(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(id);
    }

    public void updateItem(long id, Item item) {
        Session currentSession = sessionFactory.getCurrentSession();
        Item items = currentSession.get(Item.class, id);
        items.setPhotoItem(item.getPhotoItem());
        items.setName(item.getName());
     //   items.setCategory(getCategoryById(id));
        items.setDescription(item.getDescription());
        items.setQuantity(item.getQuantity());
        items.setPrice(item.getPrice());
        currentSession.update(items);
    }

    private Category getCategoryById(long categoryId){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Category.class, categoryId);
    }

}
