package edu.gcit.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mtextview;
    private String[] mcolorArray = {"Red","pink","deep_purple","indigo","yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextview = findViewById(R.id.textView);



    }

    public void Change_color(View view) {
        Random random = new Random();
        String colorname = mcolorArray[random.nextInt(5)];

        int colorResourcesName = getResources().getIdentifier(colorname,"color",getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourcesName);
        mtextview.setTextColor(colorRes);


    }
}