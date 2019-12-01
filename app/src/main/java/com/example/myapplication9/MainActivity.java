package com.example.myapplication9;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView formulaText,resultText;
    private Button buttons[] = new Button[30];
    private CheckInput checkInput;
    private CounterByEquation counterByEquation;
    private String equation = "";

    double num2,num1,result;

    private int buttonIds[] = new int[]{
            R.id.button_0,R.id.button_1,R.id.button_2,R.id.button_3,R.id.button_4,R.id.button_5,R.id.button_6,
            R.id.button_7,R.id.button_8,R.id.button_9,R.id.button_dot,R.id.button_CircleLeft,R.id.button_CircleRight,
            R.id.button_add,R.id.button_sub,R.id.button_mul,R.id.button_div,R.id.button_sin,R.id.button_cos,
            R.id.button_tan,R.id.button_c,R.id.button_DEC,R.id.button_help,R.id.button_tiji,R.id.button_changdu,
            R.id.button_equ,R.id.button_trans,R.id.lifang,R.id.button_pingfang,R.id.button_kaifang
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        init();
    }


    @Override
    public void onClick(View v){
        int id = v.getId();
        Button button = (Button)findViewById(id);
        String text = button.getText().toString();
        switch (id){
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
                checkInput.setEquation(equation);
                if(checkInput.checkNumberInput()){
                    equation = checkInput.getEquation();
                    equation += text;
                }
                break;


            case R.id.button_add:
            case R.id.button_sub:
            case R.id.button_mul:
            case R.id.button_div:
                checkInput.setEquation(equation);
                if(checkInput.checkOperationsInput()){
                    equation = checkInput.getEquation();
                    equation += text;
                }
                break;
            case R.id.button_DEC: {
                checkInput.setEquation(equation);
                checkInput.backSpace();
                equation = checkInput.getEquation();

            }
            break;

            case R.id.button_CircleLeft:{
                checkInput.setEquation(equation);
                if(checkInput.checkLBracketInput())
                    equation+="(";
                break;

            }

            case R.id.button_CircleRight:{
                checkInput.setEquation(equation);
                if(checkInput.checkRBracketInput())
                    equation+=')';
                break;
                }


            case R.id.button_c: {
                equation = "";
                resultText.setText("");


            }
            break;


            case R.id.button_dot:
                checkInput.setEquation(equation);
                if(checkInput.checkPointInput()){
                    equation = checkInput.getEquation();
                    equation+=text;
                }
                break;
            case R.id.button_sin: {
                formulaText= (TextView)findViewById(R.id.formula_area);
                double a=Math.toRadians(Double.parseDouble(formulaText.getText().toString()));
                resultText.setText(String.valueOf(Math.sin(a)));
                break;

            }

            case R.id.button_cos: {
                formulaText= (TextView)findViewById(R.id.formula_area);
                double a=Math.toRadians(Double.parseDouble(formulaText.getText().toString()));
                resultText.setText(String.valueOf(Math.cos(a)));
                break;

            }

            case R.id.button_tan: {
                formulaText= (TextView)findViewById(R.id.formula_area);
                double a=Math.toRadians(Double.parseDouble(formulaText.getText().toString()));
                resultText.setText(String.valueOf(Math.tan(a)));
                break;

            }
            case R.id.button_pingfang:{
                formulaText= (TextView)findViewById(R.id.formula_area);
                double a=Double.parseDouble(formulaText.getText().toString());
                resultText.setText(String.valueOf(Math.pow(a,2)));
                break;
            }
            case R.id.button_kaifang:{
                formulaText= (TextView)findViewById(R.id.formula_area);
                double a=Double.parseDouble(formulaText.getText().toString());
                resultText.setText(String.valueOf(Math.sqrt(a)));
                break;
            }
            case R.id.lifang:{
                formulaText= (TextView)findViewById(R.id.formula_area);
                double a=Double.parseDouble(formulaText.getText().toString());
                resultText.setText(String.valueOf(Math.pow(a,3)));
                break;
            }

            case R.id.button_help: {
                Intent intent =new Intent(MainActivity.this,FifthActivity.class);
                startActivity(intent);
                break;

            }

            case R.id.button_tiji: {
                Intent intent =new Intent(MainActivity.this,FourthActivity.class);
                startActivity(intent);
                break;

            }

            case R.id.button_changdu: {
                Intent intent =new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
                break;

            }

            case R.id.button_equ:
                resultText.setText(new CounterByEquation(equation).solveEquation());
                break;
            case R.id.button_trans:{
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            }

        }
        formulaText.setText(equation);
    }
    void init(){

        int length = buttons.length;
        for(int i=0;i<length;i++){

            buttons[i] = (Button)findViewById(buttonIds[i]);

        }


        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);
        buttons[6].setOnClickListener(this);
        buttons[7].setOnClickListener(this);
        buttons[8].setOnClickListener(this);
        buttons[9].setOnClickListener(this);
        buttons[10].setOnClickListener(this);
        buttons[11].setOnClickListener(this);
        buttons[12].setOnClickListener(this);
        buttons[13].setOnClickListener(this);
        buttons[14].setOnClickListener(this);
        buttons[15].setOnClickListener(this);
        buttons[16].setOnClickListener(this);
        buttons[16].setOnClickListener(this);
        buttons[17].setOnClickListener(this);
        buttons[18].setOnClickListener(this);
        buttons[19].setOnClickListener(this);
        buttons[20].setOnClickListener(this);
        buttons[21].setOnClickListener(this);
        buttons[22].setOnClickListener(this);
        buttons[23].setOnClickListener(this);
        buttons[24].setOnClickListener(this);
        buttons[25].setOnClickListener(this);
        buttons[26].setOnClickListener(this);
        buttons[27].setOnClickListener(this);
        buttons[28].setOnClickListener(this);
        buttons[29].setOnClickListener(this);



        formulaText = (TextView)findViewById(R.id.formula_area);
        resultText = (TextView)findViewById(R.id.result_area);
        checkInput = new CheckInput();
        counterByEquation = new CounterByEquation(equation);
    }



}
