package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textView = findViewById(R.id.message);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(msg);

        spinner = findViewById(R.id.spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);

        }
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.phone_label, R.layout.support_simple_spinner_dropdown_item);
        if(spinner!=null){
            spinner.setAdapter(adapter);
        }
    }


    public void radiobutton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radioButton;
                DisplayToast("Same day messenger service");
                break;

                case R.id.radioButton2;
                DisplayToast("Next day ground delivery");
                break;

                case R.id.radioButton3;
                DisplayToast("Pick Up");
                break;

            default:
                break;
        }

    }
    public void DisplayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerMessage = parent.getItemAtPosition(position).toString();
        DisplayToast(spinnerMessage);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        ///

    }
}