package com.product.productservice.Controller;

import com.product.productservice.Model.Products;
import com.product.productservice.Service.Productservice;
import org.springframework.web.bind.annotation.*;

@RestController
public class Productcontroller {

    private Productservice obj;

    public Productcontroller(Productservice obj){
        this.obj = obj;
    }

    @PostMapping("/product")
    public void creatproduct(){

    }

    @GetMapping("/product/{id}")
    public void getproductbyid(@PathVariable("id") int id){
       Products pr =  obj.getproductbyid(id);

         //return null;
    }

    @GetMapping("/products")
    public void getallproducts(){

    }

    @DeleteMapping("/product/{id}")
    public void deleteproductbyid(@PathVariable("id") int id){

    }
}
