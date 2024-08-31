package com.product.productservice.DTO;

import com.product.productservice.Model.Category;
import com.product.productservice.Model.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fakestoreproductdto {
    private Integer id;
    private String title;
    private String description;
    private String  price;
    private String image;
    private String category ;


}
