package com.example.myapplication9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_1);
    }

    public void onClick(View view) {
        //控制逻辑代码
        //Toast.makeText(this, "=", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
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
            case R.id.button_dot:
            case R.id.button_CircleLeft:
            case R.id.button_CircleRight:

            case R.id.button_add:
            case R.id.button_sub:
            case R.id.button_mul:
            case R.id.button_div:
            case R.id.button_sin:
            case R.id.button_cos:
            case R.id.button_tan: {
                Button btn = (Button) view;
                String strAdded = btn.getText().toString();
                TextView formula = (TextView) findViewById(R.id.formula_area);
                String strContent = formula.getText().toString();
                String strNewContent = strContent + strAdded;
                formula.setText(strNewContent);
            }
            break;
            case R.id.button_c: {
                TextView formula = (TextView) findViewById(R.id.formula_area);
                formula.setText("");
                TextView result = (TextView) findViewById(R.id.result_area);
                result.setText("");
            }
            break;
            case R.id.button_DEC: {
                TextView formula = (TextView) findViewById(R.id.formula_area);
                String StrContent = formula.getText().toString();
                if (StrContent.length() > 0) {
                    StrContent = StrContent.substring(0, StrContent.length() - 1);
                    formula.setText(StrContent);
                }

            }
            break;
            case R.id.button_equ: {
                TextView formula = (TextView) findViewById(R.id.formula_area);
                String StrContent = formula.getText().toString();
                try {
                    Symbols s = new Symbols();
                    double res = s.eval(StrContent);

                    TextView result = (TextView) findViewById(R.id.result_area);
                    result.setText(String.valueOf(res));
                    formula.setText("");
                } catch (SyntaxException e) {
                    Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show();

                }

                break;

            }
            case R.id.button_trans2:
            case R.id.button_trans8:
            case R.id.button_trans16: {

            }
            break;
        }
    }
}
