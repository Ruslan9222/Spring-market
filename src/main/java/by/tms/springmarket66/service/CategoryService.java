package by.tms.springmarket66.service;


import by.tms.springmarket66.dao.CategoryDao;

import by.tms.springmarket66.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void create (Category category) {
        categoryDao.save(category);
    }

    public List<Category> viewAllCategories() {
        return categoryDao.viewAllCategories();
    }
    public Category findCategoryById(long id) {
        return categoryDao.findCategoryById(id);
    }

    public void updateCategory(long id, Category category) {
        categoryDao.updateCategory(id, category);
    }

    public void delete(long id) {
        categoryDao.delete(id);
    }
}
