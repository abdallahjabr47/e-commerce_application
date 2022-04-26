package edu.birzeit.ecommerce.services;

import edu.birzeit.ecommerce.models.Category;
import edu.birzeit.ecommerce.models.Product;
import edu.birzeit.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category>getCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(null);
    }
    public List<Product>getCategoryProducts(int categoryId){
        Category category=getCategoryById(categoryId);
        return category.getProducts();

    }
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category updateCategory(int categoryId,Category category){
        Category existingCategory = getCategoryById(categoryId);
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }

}
