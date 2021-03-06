package edu.birzeit.ecommerce.services;

import edu.birzeit.ecommerce.models.Category;
import edu.birzeit.ecommerce.models.Product;
import edu.birzeit.ecommerce.repositories.ProductRepository;
import edu.birzeit.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    /**
     *
     * @param productRepository
     * @param categoryService
     */
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    /**
     *
     * @return
     */
    public List<Product>getProducts(){
        return productRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Product getProductById(int id){
        return productRepository.findById(id).orElseThrow(null);
    }

    /**
     *
     * @param categoryId
     * @param product
     * @return
     */
    public Product addProduct(int categoryId,Product product){
        Category category = categoryService.getCategoryById(categoryId);
        product.setCategory(category);
        categoryService.updateCategory(categoryId,category);
        return productRepository.save(product);
    }

    /**
     *
     * @param productId
     * @param product
     * @return
     */
    public Product updateProduct(int productId,Product product){
        Product existingProduct=productRepository.getById(productId);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    /**
     *
     * @param id
     */
    public  void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
