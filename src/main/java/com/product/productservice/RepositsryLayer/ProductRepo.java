package com.product.productservice.RepositsryLayer;

import com.product.productservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAll();

     Product findById(Integer id);
//
//     Products updateProductsBy(Integer id, Products product);
     //Products

    //Products findAllBy(String tittle);

    //Products save(Products pro);

}
