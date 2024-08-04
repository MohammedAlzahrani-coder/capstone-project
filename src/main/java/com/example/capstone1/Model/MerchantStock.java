package com.example.capstone1.Model;

import jakarta.validation.constraints.NotNull;

public class MerchantStock {


    @NotNull(message = "The id should not be null")
    private int id;


    @NotNull(message = "The product id should not be null")
    private int productId;


    @NotNull(message = "The merchant id should not be null")
    private int merchantId;

    @NotNull(message = "The message should not be null")
    private int stock = 10;
}
