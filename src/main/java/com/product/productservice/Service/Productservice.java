package com.product.productservice.Service;

import com.product.productservice.Model.Products;
import org.springframework.stereotype.Service;

@Service
public interface Productservice {

    public Products getproductbyid(int id);
    public  void createproduct();
}
