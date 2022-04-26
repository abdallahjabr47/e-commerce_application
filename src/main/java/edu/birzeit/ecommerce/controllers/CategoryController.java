package edu.birzeit.ecommerce.controllers;

import edu.birzeit.ecommerce.models.Category;
import edu.birzeit.ecommerce.models.Product;
import edu.birzeit.ecommerce.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category>getCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @GetMapping("/products/{id}")
    public List<Product>getCategoryProducts(@PathVariable int id){
        return categoryService.getCategoryProducts(id);
    }
    @PostMapping()
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id ,@RequestBody Category category){
        return categoryService.updateCategory(id,category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

}
