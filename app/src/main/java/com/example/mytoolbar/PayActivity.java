package com.example.mytoolbar;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PayActivity extends AppCompatActivity {
    private EditText mInMoney;
    private EditText mInfoPayment;
    private CheckBox mCheckKarta;
    private CheckBox mCheckPhone;
    private CheckBox mCheckMoney;
    private Button mBtnClick;
    private String type;
    private CompoundButton.OnCheckedChangeListener checkedChangeLilstn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        checkBoxChange();
        initViews();
        clickBtnOk();



    }
    private void initViews(){
        mInMoney=findViewById(R.id.inMoney);
        mInfoPayment=findViewById(R.id.infoPayment);
        mCheckKarta=findViewById(R.id.checkKarta);
        mCheckPhone=findViewById(R.id.checkPfone);
        mCheckMoney=findViewById(R.id.checkMoney);
        mBtnClick = findViewById(R.id.btnOK);
        mCheckMoney.setOnCheckedChangeListener(checkedChangeLilstn);
        mCheckPhone.setOnCheckedChangeListener(checkedChangeLilstn);
        mCheckKarta.setOnCheckedChangeListener(checkedChangeLilstn);
        mCheckKarta.setChecked(true);
    }
    private void resetCheckBoxes(){
        mCheckKarta.setChecked(false);
        mCheckPhone.setChecked(false);
        mCheckMoney.setChecked(false);

    }
    private void clickBtnOk(){
        //Button mBtnClick = findViewById(R.id.btnOK);
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mInMoney.getText().length()==0 || mInfoPayment.getText().length()==0)
                    Toast.makeText(PayActivity.this, "Введите данные платежа", Toast.LENGTH_LONG).show();
                else {
                    String text = "Прошла оплата на сумму " + mInMoney.getText() + " руб." + type + mInfoPayment.getText();
                    Toast.makeText(PayActivity.this, text, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void checkBoxChange(){
        checkedChangeLilstn = new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switch (buttonView.getId()) {
                        case R.id.checkKarta:
                            resetCheckBoxes();
                            mCheckKarta.setChecked(true);
                            mInfoPayment.setInputType(InputType.TYPE_CLASS_NUMBER);
                            type=" банковской картой № ";
                            break;
                        case R.id.checkPfone:
                            resetCheckBoxes();
                            mCheckPhone.setChecked(true);
                            mInfoPayment.setInputType(InputType.TYPE_CLASS_PHONE);
                            type=" мобильным телефоном на номер: ";
                            break;
                        case R.id.checkMoney:
                            resetCheckBoxes();
                            mCheckMoney.setChecked(true);
                            mInfoPayment.setInputType(InputType.TYPE_CLASS_TEXT);
                            type=" наличными по адресу: ";
                            break;
                        default:
                    }
                }

            }
        };
    }
}