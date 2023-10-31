package by.tms.springmarket66.mapper;


import by.tms.springmarket66.dto.ItemDto;
import by.tms.springmarket66.entity.Category;
import by.tms.springmarket66.entity.Item;
import by.tms.springmarket66.service.ItemService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public class ItemMapper {
    public Item saveToEntity(ItemDto itemDto) {
        return new Item(itemDto.getPhotoItem(),
                itemDto.getName(),
                itemDto.getCategory(),
                itemDto.getDescription(),
                itemDto.getQuantity(),
                itemDto.getPrice());
    }

    public ItemDto editDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setPhotoItem(item.getPhotoItem());
        itemDto.setName(item.getName());
        itemDto.setCategory(item.getCategory());
        itemDto.setDescription(item.getDescription());
        itemDto.setQuantity(item.getQuantity());
        itemDto.setPrice(item.getPrice());
        return itemDto;
    }

}
