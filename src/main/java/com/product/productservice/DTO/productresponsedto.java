package com.product.productservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class productresponsedto {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String Category ;

}
