package com.example.mybill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.mybill.databinding.SheetLayoutBinding;

public class MainActivity extends AppCompatActivity {
    SheetLayoutBinding sheetLayoutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InputModel inputModel = new InputModel("0");
        final SheetModel sheetModel = new SheetModel();

        sheetLayoutBinding = DataBindingUtil.setContentView(this, R.layout.sheet_layout);
        sheetModel.setInputModel(inputModel);
        sheetLayoutBinding.setSheetModel(sheetModel);

        EditText txtPrice = (EditText) findViewById(R.id.txtPrice);
        EditText txtDiscount = (EditText) findViewById(R.id.txtDiscount);
        EditText txtTax = (EditText) findViewById(R.id.txtTax);

        txtPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String newText = charSequence.toString();
                Log.d("onTextChanged , ", "txtPrice " + newText);
                if(newText.matches("\\d+")){
                    Log.d("onTextChanged , ", "txtPrice is numeric");
                    inputModel.setTxtPrice(newText);
                    sheetModel.calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtDiscount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String newText = charSequence.toString();
                Log.d("onTextChanged , ", "txtDiscount " + newText);
                if(newText.matches("\\d+")){
                    Log.d("onTextChanged , ", "txtDiscount is numeric");
                    inputModel.setTxtDiscount(newText);
                    sheetModel.calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtTax.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String newText = charSequence.toString();
                Log.d("onTextChanged , ", "txtTax " + newText);
                if(newText.matches("\\d+")){
                    Log.d("onTextChanged , ", "txtTax is numeric");
                    sheetModel.setTxtTax(newText);
                    sheetModel.calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}