package com.product.productservice.Service;

import com.product.productservice.DTO.Fakestoreproductdto;
import com.product.productservice.Model.Product;
import com.product.productservice.builder.productmapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("fakestoreservice")
public class Fakestoreservice implements Productservice {

    private RestTemplate restTemplate;
    private productmapper mapper;

    public Fakestoreservice(RestTemplate restTemplate, productmapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public Product getproductbyid(Integer id) {
        //1.call to api
        ResponseEntity<Fakestoreproductdto> response =
                restTemplate.getForEntity("http://fakestoreapi.com/products/" + id, Fakestoreproductdto.class);

        //2.getbody
        Fakestoreproductdto dto = response.getBody();

        if (response == null || response.getBody() == null) {
            return null;
        }

        //3.return
        return mapper.toproduct(dto);
    }

    @Override
    public Product createproduct(String tittle, String descreption, String image, String price, String category) {
        //1.create new fakestoreproductdto to convert into jason
        Fakestoreproductdto requestbody = new Fakestoreproductdto();
        requestbody.setTitle(tittle);
        requestbody.setDescription(descreption);
        requestbody.setImage(image);
        requestbody.setPrice(price);
        requestbody.setCategory(category);

        //2.call to api
        Fakestoreproductdto response =
                restTemplate.postForObject("http://fakestoreapi.com/products/", requestbody, Fakestoreproductdto.class);

        //convert to product
        Product pr = mapper.toproduct(response);

        return pr;
    }

    @Override
    public List<Product> getallproducts() {

        List<Product> products = new ArrayList<>();

        ResponseEntity<Fakestoreproductdto[]> response =
                restTemplate.getForEntity("http://fakestoreapi.com/products/", Fakestoreproductdto[].class);

        Fakestoreproductdto[] dto = response.getBody();

        if (dto == null || dto.length == 0) {
            System.out.print("Something went wrong");
            return new ArrayList<>();
        }
        for (Fakestoreproductdto dtos : dto) {
            Product product = mapper.toproduct(dtos);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product deleteproductbyid(int id) {

        ResponseEntity<Fakestoreproductdto> response
                = restTemplate.getForEntity("http://fakestoreapi.com/products/" + id, Fakestoreproductdto.class);
        Fakestoreproductdto dto = response.getBody();

        return mapper.toproduct(dto);
    }

    @Override
    public Product updateproductbyid(int id, String tittle, String descreption, String image, String price, String category) {
        Fakestoreproductdto requestbody = new Fakestoreproductdto();
        requestbody.setTitle(tittle);
        requestbody.setDescription(descreption);
        requestbody.setCategory(category);
        requestbody.setPrice(price);

        Fakestoreproductdto response
                = restTemplate.patchForObject("http://fakestoreapi.com/products/" + id, requestbody, Fakestoreproductdto.class);

        Product products = mapper.toproduct(response);
        return products;
    }
}
