package com.product.productservice.Service;

import com.product.productservice.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Productservice {

    public Product getproductbyid(Integer id);
    public Product createproduct(String tittle, String descreption, String image, String price, String category);
    public List<Product> getallproducts();
    public Product deleteproductbyid(int id);
    public Product updateproductbyid(int id, String tittle, String descreption, String image, String price, String category);
}
