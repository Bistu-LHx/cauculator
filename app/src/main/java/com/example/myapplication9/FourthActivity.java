package com.example.myapplication9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {

    EditText formulaText3;
    EditText resultTextcm3;
    EditText resultTextm3;
    EditText resultTextdm3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);
        Button buttonCM3 =(Button) findViewById(R.id.CM3toOther);
        Button buttonM3=(Button) findViewById(R.id.M3toOther);
        Button buttonDM3=(Button) findViewById(R.id.DM3toOther);
        buttonCM3.setOnClickListener(this);
        buttonM3.setOnClickListener(this);
        buttonDM3.setOnClickListener(this);
        resultTextcm3=(EditText)findViewById(R.id.resCM3);
        resultTextm3=(EditText)findViewById(R.id.resM3);
        resultTextdm3=(EditText)findViewById(R.id.resDM3);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.DM3toOther:{
                formulaText3=findViewById(R.id.dm3text);
                double a=Double.parseDouble(formulaText3.getText().toString());
                resultTextcm3.setText("转化为cm³："+String.valueOf(a*1000));
                resultTextm3.setText("转化为m³："+String.valueOf(a*0.001));
                resultTextdm3.setText("转化为dm³：");
                break;
            }
            case R.id.CM3toOther:{
                formulaText3=findViewById(R.id.cm3text);
                double a=Double.parseDouble(formulaText3.getText().toString());
                resultTextcm3.setText("转化为cm³：");
                resultTextm3.setText("转化为m³："+String.valueOf(a*0.000001));
                resultTextdm3.setText("转化为dm³："+String.valueOf(a*0.001));
                break;
            }
            case R.id.M3toOther:{
                formulaText3=findViewById(R.id.m3text);
                double a=Double.parseDouble(formulaText3.getText().toString());
                resultTextcm3.setText("转化为cm³："+String.valueOf(a*1000000));
                resultTextm3.setText("");
                resultTextdm3.setText("转化为dm³："+String.valueOf(a*1000));
                break;
            }


        }
    }
}
