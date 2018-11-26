package com.example.user.calculator_xml_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = (Button) findViewById(R.id.n0);
        Button button1 = (Button) findViewById(R.id.n1);
        Button button2 = (Button) findViewById(R.id.n2);
        Button button3 = (Button) findViewById(R.id.n3);
        Button button4 = (Button) findViewById(R.id.n4);
        Button button5 = (Button) findViewById(R.id.n5);
        Button button6 = (Button) findViewById(R.id.n6);
        Button button7 = (Button) findViewById(R.id.n7);
        Button button8 = (Button) findViewById(R.id.n8);
        Button button9 = (Button) findViewById(R.id.n9);
        Button buttonA = (Button) findViewById(R.id.Add);
        Button buttonM = (Button) findViewById(R.id.Mul);
        Button buttonS = (Button) findViewById(R.id.Sub);
        Button buttonD = (Button) findViewById(R.id.Div);
        Button buttonE = (Button) findViewById(R.id.Equal);
        Button buttonDel = (Button) findViewById(R.id.delete);

        final TextView textView = (TextView) findViewById(R.id.number);

        final Map<String, String> calc = new HashMap<String, String>();
        calc.put("delete", "N");

        View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {
                String text = "";

                if (!((Button) v).getText().equals("+")
                        && !((Button) v).getText().equals("-")
                        && !((Button) v).getText().equals("*")
                        && !((Button) v).getText().equals("/")
                        && !((Button) v).getText().equals("=")) {
                    if (calc.get("delete").equals("Y")) {
                        calc.put("delete", "N");
                        calc.put("number1", "");
                        calc.put("operation", "");

                        text = (String) ((Button) v).getText();
                        textView.setText(Integer.parseInt(text) + "");
                    } else {
                        text = (String) textView.getText();
                        text += ((Button) v).getText();

                        textView.setText(Integer.parseInt(text) + "");
                    }
                }

                if (((Button) v).getText().equals("+")
                        || ((Button) v).getText().equals("-")
                        || ((Button) v).getText().equals("*")
                        || ((Button) v).getText().equals("/")) {
                    calc.put("operation", (String) ((Button) v).getText());
                    calc.put("number1", (String) textView.getText());
                    textView.setText("0");
                }
                if (((Button) v).getText().equals("=")) {
                    int num1 = Integer.parseInt(calc.get("number1"));
                    int num2 = Integer.parseInt((String) textView.getText());

                    int result = 0;

                    if (calc.get("operation").equals("+")) {
                        result = num1 + num2;
                        calc.put("number1", Integer.toString(result)+"");
                    } else if (calc.get("operation").equals("-")) {
                        result = num1 - num2;
                        calc.put("number1", Integer.toString(result)+"");
                    } else if (calc.get("operation").equals("*")) {
                        result = num1 * num2;
                        calc.put("number1", Integer.toString(result)+"");
                    } else if (calc.get("operation").equals("/")) {
                        result = num1 / num2;
                        calc.put("number1", Integer.toString(result)+"");
                    }

                    //calc.put("delete", "Y");

                    textView.setText(result + "");
                }
            }


        };
        button0.setOnClickListener(clickListener);
        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);
        button4.setOnClickListener(clickListener);
        button5.setOnClickListener(clickListener);
        button6.setOnClickListener(clickListener);
        button7.setOnClickListener(clickListener);
        button8.setOnClickListener(clickListener);
        button9.setOnClickListener(clickListener);
        buttonA.setOnClickListener(clickListener);
        buttonS.setOnClickListener(clickListener);
        buttonM.setOnClickListener(clickListener);
        buttonD.setOnClickListener(clickListener);
        buttonE.setOnClickListener(clickListener);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc.put("delete", "Y");

                textView.setText("0");
            }
        });
    }
}