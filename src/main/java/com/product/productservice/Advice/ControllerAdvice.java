package com.product.productservice.Advice;

import com.product.productservice.DTO.Errordto;
import com.product.productservice.Exceptions.InvalidProductIdexception;
import com.product.productservice.Exceptions.Productnotfoundexception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(InvalidProductIdexception.class)
    public ResponseEntity<Errordto> handleInvalidproductexception(InvalidProductIdexception e){
        Errordto dto = new Errordto();
        dto.setCode("some error code");
        dto.setMessege(e.getMessage());

        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Productnotfoundexception.class)
    public ResponseEntity<Errordto> handleInvalidproductnotfoundexception(Productnotfoundexception e){
       Errordto dto = new Errordto();
       dto.setCode("some error code");
       dto.setMessege("product not found");

        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
