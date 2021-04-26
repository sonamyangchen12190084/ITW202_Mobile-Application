package edu.gcit.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText medittext_website;
    EditText medittext_Location;
    EditText medittext_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medittext_website = findViewById(R.id.editText_websites);
        medittext_Location = findViewById(R.id.editText_Location);
        medittext_share = findViewById(R.id.editText_share);
    }

    public void Websites(View view) {
        String text = medittext_website.getText().toString();
        Uri url = Uri.parse(text);

        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intent", "Error!");
        }
    }

    public void Location(View view) {
        String text = medittext_Location.getText().toString();
        Uri url = Uri.parse("geo:0,0?q=" + text);

        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intent", "Error!");
        }
    }


    public void Share(View view) {
        String text = medittext_share.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("share this text with: ")
                .setText(text)
                .startChooser();
    }
}