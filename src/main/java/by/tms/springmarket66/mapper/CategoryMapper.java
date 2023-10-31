package by.tms.springmarket66.mapper;

import by.tms.springmarket66.dto.CategoryDto;
import by.tms.springmarket66.entity.Category;
import by.tms.springmarket66.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category saveToEntity(CategoryDto categoryDto){
        return new Category(categoryDto.getName());
    }

    public CategoryDto editDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
