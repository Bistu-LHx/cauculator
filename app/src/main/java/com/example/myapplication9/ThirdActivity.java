package com.example.myapplication9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    EditText formulaText2;
    EditText resultTextcm;
    EditText resultTextm;
    EditText resultTextkm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Button buttonCM =(Button) findViewById(R.id.CMtoOther);
        Button buttonM=(Button) findViewById(R.id.MtoOther);
        Button buttonKM=(Button) findViewById(R.id.KMtoOther);
        buttonCM.setOnClickListener(this);
        buttonM.setOnClickListener(this);
        buttonKM.setOnClickListener(this);
        resultTextcm=(EditText)findViewById(R.id.resCM);
        resultTextm=(EditText)findViewById(R.id.resM);
        resultTextkm=(EditText)findViewById(R.id.resKM);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.CMtoOther:{
                formulaText2=findViewById(R.id.cmtext);
                double a=Double.parseDouble(formulaText2.getText().toString());
                resultTextcm.setText("");
                resultTextm.setText("转化为m："+String.valueOf(a*0.01));
                resultTextkm.setText("转化为km："+String.valueOf(a*0.00001));
                break;
            }
            case R.id.MtoOther:{
                formulaText2=findViewById(R.id.mtext);
                double a=Double.parseDouble(formulaText2.getText().toString());
                resultTextcm.setText("转化为cm："+String.valueOf(a*100));
                resultTextm.setText("");
                resultTextkm.setText("转化为km："+String.valueOf(a*0.001));
                break;
            }
            case R.id.KMtoOther:{
                formulaText2=findViewById(R.id.kmtext);
                double a=Double.parseDouble(formulaText2.getText().toString());
                resultTextcm.setText("转化为cm："+String.valueOf(a*100000));
                resultTextm.setText("转化为m："+String.valueOf(a*1000));
                resultTextkm.setText("");
                break;
            }

        }
    }
}
