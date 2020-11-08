package com.example.mybill;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SheetModel extends BaseObservable {
    private String txtYouSave;
    private String txtTax;
    private String txtTotal;
    private InputModel inputModel;

    public SheetModel() {
        this.txtTax="0";
        this.txtYouSave="0";
        this.txtTotal="0";
    }

    @Bindable
    public String getTxtYouSave() {
        return txtYouSave;
    }

    public void setTxtYouSave(String txtYouSave) {
        this.txtYouSave = txtYouSave;
        notifyPropertyChanged(BR.txtYouSave);
    }

    @Bindable
    public String getTxtTax() {
        return txtTax;
    }

    public void setTxtTax(String txtTax) {
        Log.d("setTxtTax", txtTax);
        this.txtTax = txtTax;
        notifyPropertyChanged(BR.txtTax);
    }

    @Bindable
    public String getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(String txtTotal) {
        this.txtTotal = txtTotal;
        notifyPropertyChanged(BR.txtTotal);
    }

    public InputModel getInputModel() {
        return inputModel;
    }

    public void setInputModel(InputModel inputModel) {
        this.inputModel = inputModel;
    }

    public void calculate(){
        Log.d("calculate", "before");
        this.inputModel.calculate();
        if(this.txtTax.matches("\\d+") && this.inputModel.getTxtAmount().matches("\\d+")) {
            Log.d("calculate", "numeric enter");
            int tax = Integer.parseInt(this.txtTax);
            int amount = Integer.parseInt(this.inputModel.getTxtAmount());
            int total = amount + ((amount * tax )/ 100);
            setTxtTotal(String.valueOf(total));
            Log.d("calculate", "numeric exit");
        }
        Log.d("calculate", "after");
    }
}
