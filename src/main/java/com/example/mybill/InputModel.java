package com.example.mybill;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class InputModel extends BaseObservable {

    private String txtPrice;
    private String txtDiscount;
    private String txtAmount;

    public InputModel(){
        this.txtPrice = "0";
        this.txtAmount = "Amount";
        this.txtDiscount = "0";
    }

    public InputModel(String txtPrice) {
        this.txtPrice = txtPrice;
        this.txtAmount = "Amount";
        this.txtDiscount = "0";
    }

    @Bindable
    public String getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(String txtPrice) {
        Log.d(InputModel.class.toString(), "setTxtInput , " + txtPrice);
        this.txtPrice = txtPrice;
        notifyPropertyChanged(BR.txtPrice);
        Log.d(InputModel.class.toString(), "setTxtInput , notified ");
    }

    @Bindable
    public String getTxtAmount() {
        return txtAmount;
    }

    public void setTxtAmount(String txtAmount) {
        Log.d(InputModel.class.toString(), "setTxtOutput , " + txtAmount);
        this.txtAmount = txtAmount;
        notifyPropertyChanged(BR.txtAmount);
        Log.d(InputModel.class.toString(), "setTxtOutput , notified ");
    }

    public String getTxtDiscount() {
        return txtDiscount;
    }

    public void setTxtDiscount(String txtDiscount) {
        this.txtDiscount = txtDiscount;
    }

    public void calculate(){
        Log.d("calculate", "inputmodel before");
        int price = Integer.parseInt(txtPrice);
        int discount = Integer.parseInt(txtDiscount);
        int amount = price - ((price * discount) / 100);
        setTxtAmount(String.valueOf(amount));
        Log.d("calculate", "inputmodel after");
    }
}
