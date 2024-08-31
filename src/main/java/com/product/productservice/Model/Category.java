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
public class Category extends Basemodel implements Serializable {
  //  private int id;
    private String title;
}
