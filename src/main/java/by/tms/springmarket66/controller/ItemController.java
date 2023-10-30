package by.tms.springmarket66.controller;

import by.tms.springmarket66.dto.ItemDto;
import by.tms.springmarket66.entity.Category;
import by.tms.springmarket66.mapper.ItemMapper;
import by.tms.springmarket66.service.CategoryService;
import by.tms.springmarket66.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/item")
public class ItemController {

    final ItemService itemService;
    private final ItemMapper itemMapper;
    private final CategoryService categoryService;


    @GetMapping("/home")
    public String getHome(HttpSession session, Model model){
        ItemDto currentItem = (ItemDto) session.getAttribute("currentItem");

        model.addAttribute("item", currentItem);
        return "user/home";
    }

    @GetMapping("/newItem")
    public String newItem(Model model) {
        List<Category> allCategories = categoryService.viewAllCategories();
        ItemDto itemDto = new ItemDto();
        model.addAttribute("categories", allCategories);
        model.addAttribute("item", itemDto);
        return "item/newItem";
    }

    @GetMapping("/{id}")
    public String showItems(@PathVariable("id") long id, Model model) {
        model.addAttribute("item", itemService.findItemById(id));
        return "item/info";
    }

    @GetMapping("/{id}/edit")
    public String editItem(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", itemMapper.editDto(itemService.findItemById(id)));
        return "item/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteI(Model model, @PathVariable("id") long id){
        model.addAttribute("item", itemService.findItemById(id));
        return "item/delete";
    }

    @PostMapping()
    public String createItem(@Valid ItemDto itemDto, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()) {
            return "item/newItem";
        }
        session.setAttribute("currentItem", itemMapper.saveToEntity(itemDto));
        itemService.create(itemMapper.saveToEntity(itemDto));
        return "redirect:/home";
    }

    @PatchMapping("/{id}")
    public String updateItem(@ModelAttribute("item") ItemDto itemDto,
                         @PathVariable("id") long id){
        itemService.findItemById(id);
        return "user/home";
    }
    @PatchMapping("/{id}/delete")
    public String deleteItem(@PathVariable("id") long id){
        itemService.delete(id);
        return "user/home";
    }
}
