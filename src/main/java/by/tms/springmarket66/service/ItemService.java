package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.ItemDao;
import by.tms.springmarket66.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void create(Item item) {
        itemDao.save(item);
    }

    public List<Item> viewAllItems() {
        return itemDao.viewAllItems();
    }

    public Item findItemById (long id) {
        return itemDao.findItemById(id);
    }

    public void updateItem(long id, Item item) {
        itemDao.updateItem(id, item);
    }

    public void delete(long id) {
        itemDao.delete(id);
    }

}
