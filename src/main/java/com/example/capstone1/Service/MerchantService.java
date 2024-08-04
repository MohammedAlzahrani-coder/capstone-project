package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MerchantService {


    ArrayList<Merchant> merchants = new ArrayList<>();


    public ArrayList<Merchant> getMerchants(){

        return merchants;

    }

    public void addMerchants(Merchant merchant){

        merchants.add(merchant);

    }

    public boolean updateMerchant(int id, Merchant merchant){

        for (int i = 0; i < merchants.size() ; i++) {
            if(merchants.get(i).getId() == id){
                merchants.set(i, merchant);
                return true;
            }
        }

        return false;
    }


    public boolean deleteMerchant(int id){
        for (Merchant merchant: merchants){

            if(merchant.getId() == id){

                merchants.remove(merchant);

                return true;
            }
        }

        return false;
    }



}
