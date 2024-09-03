package com.product.productservice.builder;

import com.product.productservice.DTO.Fakestoreproductdto;
import com.product.productservice.DTO.productresponsedto;
import com.product.productservice.Model.Product;
import org.springframework.stereotype.Component;

@Component
public  class productmapper {
    public productresponsedto convertoproductresponsedto(Product pr){
        productresponsedto dto = new productresponsedto();
        dto.setId(pr.getId());
        dto.setTitle((pr.getTitle()));
        dto.setDescription(pr.getDescription());
        dto.setImage(pr.getImage());
        dto.setPrice(pr.getPrice());
        dto.setCategory(pr.getCategory().getTitle());

        return dto;
    }
    public Product toproduct(Fakestoreproductdto dto) {
        Product pr = new Product();
        //Category cr = new Category();
       // cr.setTitle(dto.getCategory());//for category

       // pr.setCategory(dto.getCategory());
        pr.setId(dto.getId());
        pr.setTitle(dto.getTitle());
        pr.setDescription(dto.getDescription());
        pr.setImage(dto.getImage());
        pr.setPrice(Double.valueOf(dto.getPrice()));

        return pr;

    }
}
