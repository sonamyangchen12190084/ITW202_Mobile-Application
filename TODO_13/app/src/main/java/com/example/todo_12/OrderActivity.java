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

        textView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(msg);

        Spinner spinner = findViewById(R.id.spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);

        }
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.phone_label, R.layout.support_simple_spinner_dropdown_item);
        if(spinner!=null){
            spinner.setAdapter(adapter);
        }
    }

    public void DisplayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }


    public void radiobutton(View view) {
        boolean isChecked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.radioButton:
                DisplayToast(getString(R.string.same_day_messenger_services));
                break;

            case R.id.radioButton2:
                DisplayToast(getString(R.string.next_day_ground));
                break;

            case R.id.radioButton3:
                DisplayToast(getString(R.string.pick_up));
                break;

            default:
                break;
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerMessage = parent.getItemAtPosition(position).toString();
        DisplayToast(spinnerMessage);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //

    }
}