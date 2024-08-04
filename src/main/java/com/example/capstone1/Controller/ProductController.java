package com.example.capstone1.Controller;


import com.example.capstone1.ApiResponse.ApiResponse;
import com.example.capstone1.Model.Product;
import com.example.capstone1.Model.User;
import com.example.capstone1.Service.ProductService;
import com.example.capstone1.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping("/get")
    public ResponseEntity getProducts(){
        if(productService.getProducts().isEmpty()){
            return ResponseEntity.status(404).body(new ApiResponse("There is no any products"));
        }

        return ResponseEntity.status(200).body(productService.getProducts());
    }



    @PostMapping("/add")
    public ResponseEntity addProducts(@Valid @RequestBody Product product, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        productService.addProduct(product);
        return ResponseEntity.status(201).body(new ApiResponse("The product has been added successfully"));

    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @Valid @RequestBody Product product, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(201).body(message);
        }

        boolean isUpdated = productService.updateProduct(id,product);
        if(isUpdated){

            return   ResponseEntity.status(201).body(new ApiResponse("The product has been updated succesfully"));
        }


        return ResponseEntity.status(404).body(new ApiResponse("The product is not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){

        boolean isDeleted = productService.deleteProduct(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("The product has been deleted successfully"));


        }

        return ResponseEntity.status(404).body(new ApiResponse("There is not product with this id"));

    }



}
