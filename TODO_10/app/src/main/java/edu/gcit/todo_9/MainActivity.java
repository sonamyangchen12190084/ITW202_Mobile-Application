package edu.gcit.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText textValue1;
    private EditText textValue2;
    private TextView textResult;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValue1 = findViewById(R.id.num1);
        textValue2 = findViewById(R.id.num2);
        textResult = findViewById(R.id.textView);
        mCalculator = new Calculator();

    }

    public void Add(View view) {
        String val1 = textValue1.getText().toString();
        String val2 = textValue2.getText().toString();
        double resultAdd = mCalculator.add(Double.valueOf(val1),Double.valueOf(val2));
        textResult.setText(String.valueOf(resultAdd));

        Log.d("Debugging", "Hello Debugging");
    }

    public void Sub(View view) {
        String val1 = textValue1.getText().toString();
        String val2 = textValue2.getText().toString();
        double resultSub = mCalculator.sub(Double.valueOf(val1),Double.valueOf(val2));
        textResult.setText(String.valueOf(resultSub));
    }

    public void Mul(View view) {
        String val1 = textValue1.getText().toString();
        String val2 = textValue2.getText().toString();
        double resultMul = mCalculator.mul(Double.valueOf(val1),Double.valueOf(val2));
        textResult.setText(String.valueOf(resultMul));
    }

    public void Div(View view) {
        String val1 = textValue1.getText().toString();
        String val2 = textValue2.getText().toString();
        double resultDiv = mCalculator.div(Double.valueOf(val1),Double.valueOf(val2));
        textResult.setText(String.valueOf(resultDiv));

    }
}