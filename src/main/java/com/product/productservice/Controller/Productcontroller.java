package com.product.productservice.Controller;

import com.product.productservice.DTO.createproductdto;
import com.product.productservice.DTO.productresponsedto;
import com.product.productservice.Exceptions.InvalidProductIdexception;
import com.product.productservice.Exceptions.Productnotfoundexception;
import com.product.productservice.Model.Product;
import com.product.productservice.Service.Productservice;
import com.product.productservice.builder.productmapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Productcontroller {

    private Productservice svc;
    private productmapper mapper;

    public Productcontroller(@Qualifier("selfproductservice") Productservice svc, productmapper mapper) {
        this.svc = svc;
        this.mapper = mapper;
    }

    @PostMapping("/product")
    public productresponsedto creatproduct(@RequestBody createproductdto dto) {

        //1.calling service layer by passing parameters
        Product pr = svc.createproduct(dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getPrice(),
                dto.getCategory());
        return mapper.convertoproductresponsedto(pr);
    }

    @GetMapping("/product/{id}")
    public productresponsedto getproductbyid(@PathVariable("id") Integer id)
            throws InvalidProductIdexception, Productnotfoundexception {

        if (id == null) {
            throw new InvalidProductIdexception("Product id is not corresct");
        }

        //1.call service layer
        Product pr = svc.getproductbyid(id);

        if (pr == null) {
            throw new Productnotfoundexception("product is not found");

        }

        //2.convert to client request
        productresponsedto response = mapper.convertoproductresponsedto(pr);

        //3.return
        return response;

    }

    @GetMapping("/products")
    public List<productresponsedto> getallproducts() {
        List<Product> productsList = svc.getallproducts();
        if (productsList == null || productsList.size() == 0) {
            System.out.print("something went wrong");
            return null;
        }
        List<productresponsedto> response = new ArrayList<>();
        for (Product pr : productsList) {
            response.add(mapper.convertoproductresponsedto(pr));
        }
        return response;
    }

    @DeleteMapping("/product/{id}")
    public productresponsedto deleteproductbyid(@PathVariable("id") int id) {

        Product pr = svc.deleteproductbyid(id);

        return mapper.convertoproductresponsedto(pr);
    }

    @PatchMapping("/update/{id}")
    public productresponsedto updateproductbyid(@RequestBody createproductdto dto, @PathVariable("id") int id) {
        Product pr = svc.updateproductbyid(id,
                dto.getTitle(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getImage(),
                dto.getCategory());

        return mapper.convertoproductresponsedto(pr);
    }
}