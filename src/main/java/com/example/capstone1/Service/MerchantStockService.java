package com.example.capstone1.Service;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MerchantStockService {


    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();



    public ArrayList<MerchantStock> getMerchantStocks(){

        return merchantStocks;

    }

    public void addMerchantStock(MerchantStock merchantStock){

        merchantStocks.add(merchantStock);

    }

    public boolean updateMerchantStock(int id, MerchantStock merchantStock){

        for (int i = 0; i < merchantStocks.size() ; i++) {
            if(merchantStocks.get(i).getId() == id){
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }

        return false;
    }


    public boolean deleteMerchantStock(int id){
        for (MerchantStock merchantStock: merchantStocks){

            if(merchantStock.getId() == id){

                merchantStocks.remove(merchantStock);

                return true;
            }
        }

        return false;
    }

    public boolean addMoreStocks(int merchantId, int productId, int additionalStock){

        for (MerchantStock stocks: merchantStocks){
            if(stocks.getMerchantId() == merchantId && stocks.getProductId() == productId){
                stocks.setStock(stocks.getStock() + additionalStock);
                return true;
            }
        }

        return false;

    }


}
