package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.todo_12";
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void Donut(View view) {
        msg = "you ordered a donut";
        displayToast(msg);
    }

    public void IceCream(View view) {
        msg = "you ordered a IceCream";
        displayToast(msg);
    }

    public void Foryo(View view) {
        msg = "you ordered a Foryo";
        displayToast(msg);
    }


    public void Shoppingcart(View view) {
        Intent intent = new Intent(MainActivity.this,OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE,msg);
        startActivity(intent);
    }
}
