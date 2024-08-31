package com.product.productservice.Exceptions;

public class InvalidProductIdexception extends Exception {
    public InvalidProductIdexception(){

    }
    public  InvalidProductIdexception(String messege){
        super(messege);
    }
}
