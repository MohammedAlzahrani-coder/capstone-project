package com.example.capstone1.Service;

import com.example.capstone1.Model.Product;
import com.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ProductService {


    ArrayList<Product> products = new ArrayList<>();



    public ArrayList<Product> getProducts(){

        return products;

    }

    public void addProduct(Product product){

        products.add(product);

    }

    public boolean updateProduct(int id, Product product){

        for (int i = 0; i < products.size() ; i++) {
            if(products.get(i).getId() == id){
                products.set(i, product);
                return true;
            }
        }

        return false;
    }


    public boolean deleteProduct(int id){
        for (Product product: products){

            if(product.getId() == id){

                products.remove(product);

                return true;
            }
        }

        return false;
    }



}
