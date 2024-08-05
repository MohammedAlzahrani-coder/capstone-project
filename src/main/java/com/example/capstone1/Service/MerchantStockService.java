package com.example.capstone1.Service;

import com.example.capstone1.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    private final ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return new ArrayList<>(merchantStocks);
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);
    }

    public boolean updateMerchantStock(int id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id) {
        return merchantStocks.removeIf(merchantStock -> merchantStock.getId() == id);
    }

    public boolean addMoreStocks(int merchantId, int productId, int additionalStock) {
        for (MerchantStock stocks : merchantStocks) {
            if (stocks.getMerchantId() == merchantId && stocks.getProductId() == productId) {
                stocks.setStock(stocks.getStock() + additionalStock);
                return true;
            }
        }
        return false;
    }

    public boolean reduceStock(int merchantId, int productId, int quantity) {
        for (MerchantStock stocks : merchantStocks) {
            if (stocks.getMerchantId() == merchantId && stocks.getProductId() == productId) {
                if (stocks.getStock() >= quantity) {
                    stocks.setStock(stocks.getStock() - quantity);
                    return true;
                }
            }
        }
        return false;
    }

    // Method to check if a product is in stock for a given merchant
    public boolean checkStock(int merchantId, int productId) {
        for (MerchantStock stock : merchantStocks) {
            if (stock.getMerchantId() == merchantId && stock.getProductId() == productId) {
                return stock.getStock() > 0;
            }
        }
        return false;
    }

    // Method to update the stock for a given merchant and product
    public void updateStock(int merchantId, int productId, int quantity) {
        for (MerchantStock stock : merchantStocks) {
            if (stock.getMerchantId() == merchantId && stock.getProductId() == productId) {
                stock.setStock(stock.getStock() + quantity);
                return;
            }
        }
        // If stock entry does not exist, create a new one
        merchantStocks.add(new MerchantStock(0, productId, merchantId, quantity));
    }
}