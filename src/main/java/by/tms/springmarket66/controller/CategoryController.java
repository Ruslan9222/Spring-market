package by.tms.springmarket66.controller;


import by.tms.springmarket66.dto.CategoryDto;
import by.tms.springmarket66.dto.ItemDto;
import by.tms.springmarket66.mapper.CategoryMapper;
import by.tms.springmarket66.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    private final CategoryMapper categoryMapper;


    @GetMapping("/home")
    public String getHomePages(Model model, HttpSession session) {
    //    CategoryDto currentCategory = (CategoryDto) session.getAttribute("currentCategory");
        model.addAttribute("item", new ItemDto());
        return "user/home";
    }

    @GetMapping("/newCategory")
    public String newCategory(Model model) {
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("category", categoryDto);
        return "category/newCategory";
    }


    @GetMapping("/{id}")
    public String showCategory(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "category/info";
    }

    @GetMapping("/{id}/edit")
    public String editCategory(Model model, @PathVariable("id") int id) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "category/edit";
    }

    @GetMapping("/{id}/delete")
    public String delete1(Model model, @PathVariable("id") long id) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "category/delete";
    }

    @PostMapping()
    public String createCategory(@Valid CategoryDto categoryDto, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()) {
            return "category/newCategory";
        }
        session.setAttribute("currentCategory", categoryMapper.saveToEntity(categoryDto));
        categoryService.create(categoryMapper.saveToEntity(categoryDto));
        return "redirect:/info";
    }

    @PatchMapping("/{id}")
    public String updateCategory(@ModelAttribute("category") CategoryDto categoryDto, @PathVariable("id") long id) {
        categoryService.findCategoryById(id);
        return "user/home";
    }

    @PatchMapping("/{id}/delete")
    public String deleteCategory(@PathVariable("id") long id){
        categoryService.delete(id);
        return "user/home";
    }
}
