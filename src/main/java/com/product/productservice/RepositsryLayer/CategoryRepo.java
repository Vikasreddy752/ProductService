package com.product.productservice.RepositsryLayer;

import com.product.productservice.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {

    Category findByTitle(String title);
}
