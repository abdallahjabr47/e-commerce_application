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

    /**
     *
     * @return
     */
    public List<Category>getCategories(){
        return categoryRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(null);
    }

    /**
     *
     * @param categoryId
     * @return
     */
    public List<Product>getCategoryProducts(int categoryId){
        Category category=getCategoryById(categoryId);
        return category.getProducts();

    }

    /**
     *
     * @param category
     * @return
     */
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    /**
     *
     * @param categoryId
     * @param category
     * @return
     */
    public Category updateCategory(int categoryId,Category category){
        Category existingCategory = getCategoryById(categoryId);
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }

    /**
     *
     * @param id
     */
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }

}
