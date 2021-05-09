package com.example.todo_14iii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DateClicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDataPickerResult(int year, int month, int dayOfMonth) {
        String month_string = Integer.toString(month +1);
        String day_string = Integer.toString(dayOfMonth);
        String year_string = Integer.toString(year);

        String date_Message = (month_string + "/" + day_string + "/"+year_string);
        Toast.makeText(this, "Date: "+date_Message, Toast.LENGTH_SHORT).show();
    }
}