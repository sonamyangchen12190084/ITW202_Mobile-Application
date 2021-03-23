package edu.gcit.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.todo_4.Messsage";
    public static final int TEXT_REQUEST = 1;
    TextView mReplyEditTextHeader;
    TextView mReplyEditText;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReplyEditTextHeader = findViewById(R.id.textView3);
        mReplyEditText = findViewById(R.id.textView4);
    }

    public void send(View view) {
        Intent intent= new Intent(this,MainActivity2.class);
        mEditText = findViewById(R.id.sendEditText);
        String message = mEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
       super.onActivityResult(requestCode, resultCode, data);
       if(requestCode == TEXT_REQUEST){
           if(resultCode == RESULT_OK){
               String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
               mReplyEditTextHeader.setVisibility(View.VISIBLE);
               mReplyEditText.setText(reply);
               mReplyEditText.setVisibility(View.VISIBLE);
           }
       }
    }
}