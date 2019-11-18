package com.example.myapplication9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
   EditText formulaText1;
   EditText resultText2;
   EditText resultText8;
    EditText resultText10;
   EditText resultText16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2 =(Button) findViewById(R.id.C2to10);
        Button button8=(Button) findViewById(R.id.C8to10);
        Button button10=(Button) findViewById(R.id.C10toOther);
        Button button16 =(Button) findViewById(R.id.C16to10);
        button2.setOnClickListener(this);
        button8.setOnClickListener(this);
        button10.setOnClickListener(this);
        button16.setOnClickListener(this);
       resultText2=(EditText)findViewById(R.id.R2text);
       resultText8=(EditText)findViewById(R.id.R8text);
       resultText10=(EditText)findViewById(R.id.R10text);
       resultText16=(EditText)findViewById(R.id.R16text);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case  R.id.C10toOther:{
               formulaText1= (EditText)findViewById(R.id.C10text);
               int a=Integer.parseInt(formulaText1.getText().toString());

               resultText2.setText("2进制："+String.valueOf(Integer.toBinaryString(a)));
               resultText8.setText("8进制："+String.valueOf(Integer.toOctalString(a)));
               resultText16.setText("16进制："+String.valueOf(Integer.toHexString(a)));

                break;}
            case  R.id.C8to10:
            {formulaText1= (EditText)findViewById(R.id.C8text);
                String a=formulaText1.getText().toString();
                resultText10.setText("10进制："+Integer.valueOf(a,8).toString() );
                int b=Integer.valueOf(a,8);
                resultText2.setText("2进制："+String.valueOf(Integer.toBinaryString(b)));
                resultText8.setText("");
                resultText16.setText("16进制："+String.valueOf(Integer.toHexString(b)));
                break;
            }
            case  R.id.C2to10:
            {formulaText1= (EditText)findViewById(R.id.C2text);
                String a=formulaText1.getText().toString();
                resultText10.setText("10进制："+Integer.valueOf(a,2).toString() );
                int b=Integer.valueOf(a,2);

                resultText2.setText("");
                resultText8.setText("8进制："+String.valueOf(Integer.toOctalString(b)));
                resultText16.setText("16进制："+String.valueOf(Integer.toHexString(b)));
                break;
            }
            case  R.id.C16to10:
            {formulaText1= (EditText)findViewById(R.id.C16text);
                String a=formulaText1.getText().toString();
                resultText10.setText("10进制："+Integer.valueOf(a,16).toString() );
                int b=Integer.valueOf(a,16);
                resultText2.setText("2进制："+String.valueOf(Integer.toBinaryString(b)));
                resultText8.setText("8进制："+String.valueOf(Integer.toOctalString(b)));
                resultText16.setText("");
                break;
            }

                default:
        }


}}
