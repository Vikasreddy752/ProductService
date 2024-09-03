package com.product.productservice.Service;

import com.product.productservice.Model.Category;
import com.product.productservice.Model.Product;
import com.product.productservice.RepositsryLayer.CategoryRepo;
import com.product.productservice.RepositsryLayer.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Qualifier("selfproductservice")
public class Selfproductservice implements Productservice {


    private ProductRepo prodrepo;
    private CategoryRepo catrepo;

    @Autowired
    public Selfproductservice(ProductRepo prodrepo, CategoryRepo catrepo) {
        this.prodrepo = prodrepo;
        this.catrepo = catrepo;
    }

    @Override
    public Product getproductbyid(Integer id) {

        Product product = prodrepo.findById(id);
        return product;
    }

    @Override

    public Product createproduct(String tittle, String description, String image, String price, String category) {
        Category existingcat = catrepo.findByTitle(category);
        if (existingcat == null) {
            existingcat = new Category();
            existingcat.setTitle(category);
            existingcat.setCreatedAt(new Date());
            existingcat.setUpdatedAt(new Date());
            existingcat.setDeleted(false);

            existingcat = catrepo.save(existingcat);
        }
        Product product = new Product();
        product.setTitle(tittle);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(Double.valueOf(price));
        product.setCategory(existingcat);
        product.setUpdatedAt(new Date());
        product.setDeleted(false);
        product.setCreatedAt(new Date());

        Product pro = prodrepo.save(product);
        return pro;
    }

    @Override
    public List<Product> getallproducts() {
        List<Product> pro = new ArrayList<>();
        pro = prodrepo.findAll();
        return pro;
    }

    @Override
    public Product deleteproductbyid(int id) {
        return null;
    }

    @Override
    public Product updateproductbyid(int id, String tittle, String descreption, String image,
                                     String price, String category) {
//        Products pro = prodrepo.findProductsBy(id);
//        if(pro == null) {
//
//        }
//        pro.setTitle(tittle);
//        pro.setDescription(descreption);
//        pro.setImage(image);
//        pro.setPrice(Double.valueOf(price));
//       // pro.setCategory();
//        pro.getCategory().setTitle(category);
//        prodrepo.save(pro);
        return null;
    }


}
