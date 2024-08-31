package com.product.productservice.Model;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter

@MappedSuperclass
@NoArgsConstructor
public class Basemodel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private Date createdAt;
    private Date updatedAt;
    private boolean deleted;

}
