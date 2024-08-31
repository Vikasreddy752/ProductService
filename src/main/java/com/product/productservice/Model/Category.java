package com.product.productservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends Basemodel implements Serializable {
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    List<Products> products;

}
