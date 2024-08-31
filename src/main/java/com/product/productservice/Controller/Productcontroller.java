package com.product.productservice.Controller;

import com.product.productservice.DTO.Errordto;
import com.product.productservice.DTO.createproductdto;
import com.product.productservice.DTO.productresponsedto;
import com.product.productservice.Exceptions.InvalidProductIdexception;
import com.product.productservice.Exceptions.Productnotfoundexception;
import com.product.productservice.Model.Products;
import com.product.productservice.Service.Productservice;
import com.product.productservice.builder.productmapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Productcontroller {

    //private final com.product.productservice.builder.productmapper productmapper;
    private Productservice svc;
    private productmapper mapper;

    public Productcontroller(Productservice svc, productmapper mapper) {
        this.svc = svc;
        this.mapper = mapper;
    }

    @PostMapping("/product")
    public productresponsedto creatproduct(@RequestBody createproductdto dto) {

        //1.calling service layer by passing parameters
        Products pr = svc.createproduct(dto.getTitle(),
                dto.getDescription(),
                dto.getCategory(),
                dto.getImage(),
                dto.getPrice());
        return mapper.convertoproductresponsedto(pr);
    }

    @GetMapping("/product/{id}")
    public productresponsedto getproductbyid(@PathVariable("id") Integer id)
            throws InvalidProductIdexception, Productnotfoundexception {

        if (id == null) {
            throw new InvalidProductIdexception("Product id is not corresct");
        }

        //1.call service layer
        Products pr = svc.getproductbyid(id);

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
        List<Products> productsList = svc.getallproducts();
        if (productsList == null || productsList.size() == 0) {
            System.out.print("something went wrong");
            return null;
        }
        List<productresponsedto> response = new ArrayList<>();
        for (Products pr : productsList) {
            response.add(mapper.convertoproductresponsedto(pr));
        }
        return response;
    }

    @DeleteMapping("/product/{id}")
    public productresponsedto deleteproductbyid(@PathVariable("id") int id) {

        Products pr = svc.deleteproductbyid(id);

        return mapper.convertoproductresponsedto(pr);
    }

    @PatchMapping("/update/{id}")
    public productresponsedto updateproductbyid(@RequestBody createproductdto dto, @PathVariable("id") int id) {
        Products pr = svc.updateproductbyid(id,
                dto.getTitle(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getImage(),
                dto.getCategory());

        return mapper.convertoproductresponsedto(pr);
    }
}