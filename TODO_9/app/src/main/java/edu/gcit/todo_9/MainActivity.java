package edu.gcit.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mOperandOne;
    private EditText mOperandTwo;
    private TextView mResult;

    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();
        mOperandOne = findViewById(R.id.OperandOneEditText);
        mOperandTwo = findViewById(R.id.OperandTwoEditTExt);
        mResult = findViewById(R.id.ResultTextView);


    }

    public void add(View view) {
        String OperandOne = mOperandOne.getText().toString();
        String OperandTwo = mOperandTwo.getText().toString();
        double  value = mCalculator.add(Double.valueOf(OperandOne), Double.valueOf(OperandTwo));
        mResult.setText(String.valueOf(value));

    }

    public void sub(View view) {
        String OperandOne = mOperandOne.getText().toString();
        String OperandTwo = mOperandTwo.getText().toString();
        double value = mCalculator.sub(Double.valueOf(OperandOne),Double.valueOf(OperandTwo));
        mResult.setText(String.valueOf(value));
    }

    public void mul(View view) {
        String OperandOne = mOperandOne.getText().toString();
        String OperandTwo = mOperandTwo.getText().toString();
        double value = mCalculator.mul(Double.valueOf(OperandOne),Double.valueOf(OperandTwo));
        mResult.setText(String.valueOf(value));
    }

    public void div(View view) {
        String OperandOne = mOperandOne.getText().toString();
        String OperandTwo = mOperandTwo.getText().toString();
        double value = mCalculator.div(Double.valueOf(OperandOne),Double.valueOf(OperandTwo));
        mResult.setText(String.valueOf(value));
    }
}