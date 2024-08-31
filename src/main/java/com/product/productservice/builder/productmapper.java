package com.product.productservice.builder;

import com.product.productservice.DTO.Fakestoreproductdto;
import com.product.productservice.DTO.productresponsedto;
import com.product.productservice.Model.Category;
import com.product.productservice.Model.Products;
import org.springframework.stereotype.Component;

@Component
public  class productmapper {
    public productresponsedto convertoproductresponsedto(Products pr){
        productresponsedto dto = new productresponsedto();
      //  dto.setId(pr.getId());
        dto.setTitle((pr.getTitle()));
        dto.setDescription(pr.getDescription());
        dto.setImage(pr.getImage());
        dto.setPrice(pr.getPrice());
        dto.setCategory(pr.getCategory());

        return dto;
    }
    public  Products toproduct(Fakestoreproductdto dto) {
        Products pr = new Products();
        //Category cr = new Category();
       // cr.setTitle(dto.getCategory());//for category

        pr.setCategory(dto.getCategory());
        pr.setId(dto.getId());
        pr.setTitle(dto.getTitle());
        pr.setDescription(dto.getDescription());
        pr.setImage(dto.getImage());
        pr.setPrice(Double.valueOf(dto.getPrice()));

        return pr;

    }
}
