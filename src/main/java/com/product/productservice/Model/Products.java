package com.product.productservice.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {

    private int id;
    private String tittle;
    private String description;
    private double price;
    private String Image_url;

    private Category category;
}
