package edu.birzeit.ecommerce.repositories;

import edu.birzeit.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {




    //
}
