package com.product.productservice.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

@Getter
@Setter

@Entity
@NoArgsConstructor
public class Products extends Basemodel implements Serializable {

   // private int id;
    private String title;
    private String description;
    private double price;
    private String Image;
    private String category;

    //private Category category;
}
