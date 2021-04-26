package edu.gcit.todo_8_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        Uri message = intent.getData();

        if(message != null){
            String text = message.toString();
            textView.setText(text);
        }
    }
}