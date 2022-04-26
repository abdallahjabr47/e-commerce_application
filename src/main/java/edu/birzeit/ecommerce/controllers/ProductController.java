package edu.birzeit.ecommerce.controllers;

import edu.birzeit.ecommerce.models.Product;
import edu.birzeit.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product>getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }
    @PostMapping("/category/{categoryId}")
    public Product addProduct(@PathVariable int categoryId,@RequestBody Product product){
        return productService.addProduct(categoryId,product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody  Product product){
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
