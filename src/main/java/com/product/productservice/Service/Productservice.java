package com.product.productservice.Service;

import com.product.productservice.Model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Productservice {

    public Products getproductbyid(Integer id);
    public  Products createproduct(String tittle,String descreption,String image, String price,String category);
    public List<Products> getallproducts();
    public Products deleteproductbyid(int id);
    public Products updateproductbyid(int id,String tittle,String descreption,String image, String price,String category);
}
