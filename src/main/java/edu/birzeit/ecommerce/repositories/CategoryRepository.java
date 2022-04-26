package edu.birzeit.ecommerce.repositories;

import edu.birzeit.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Integer> {




}
