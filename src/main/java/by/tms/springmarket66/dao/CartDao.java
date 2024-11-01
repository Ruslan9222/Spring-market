package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.CartOfGoods;
import by.tms.springmarket66.entity.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CartDao {
    @Autowired
    private final SessionFactory sessionFactory;

    public CartDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Goods findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Goods goods = currentSession.get(Goods.class, id);
        return goods;
    }

    public List<Goods> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Goods> fromGoods = currentSession.createQuery("from Goods ", Goods.class);
        return fromGoods.getResultList();
    }


}
