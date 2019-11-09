package com.example.myapplication9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView equationText,resultText;
    private Button buttons[] = new Button[26];
    private CheckInput checkInput;
    private CounterByEquation counterByEquation;
    private String equation = "";

    private int buttonIds[] = new int[]{
            R.id.button_0,R.id.button_1,R.id.button_2,R.id.button_3,R.id.button_4,R.id.button_5,R.id.button_6,
            R.id.button_7,R.id.button_8,R.id.button_9,R.id.button_dot,R.id.button_CircleLeft,R.id.button_CircleRight,
            R.id.button_add,R.id.button_sub,R.id.button_mul,R.id.button_div,R.id.button_sin,R.id.button_cos,
            R.id.button_tan,R.id.button_c,R.id.button_DEC,R.id.button_trans2,R.id.button_trans8,R.id.button_trans16,
            R.id.button_equ
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_1);
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

            case R.id.button_equ:
                resultText.setText(new CounterByEquation(equation).solveEquation());
                break;

        }
        equationText.setText(equation);
    }
    void init(){

        int length = buttons.length;
        for(int i=0;i<length;i++){

            buttons[i] = (Button)findViewById(buttonIds[i]);
            buttons[i].setOnClickListener(this);
        }
        equationText = (TextView)findViewById(R.id.formula_area);
        resultText = (TextView)findViewById(R.id.result_area);
        checkInput = new CheckInput();
        counterByEquation = new CounterByEquation(equation);
    }



}
