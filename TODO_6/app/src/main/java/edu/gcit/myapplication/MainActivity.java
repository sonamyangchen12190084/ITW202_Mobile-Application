package edu.gcit.todo_4;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG= MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "edu.gcit.todo_4.Messsage";
    public static final int TEXT_REQUEST = 1;
    TextView mReplyEditTextHeader;
    TextView mReplyEditText;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate");
        Log.d(LOG_TAG,"--------------");

        mReplyEditTextHeader = findViewById(R.id.textView3);
        mReplyEditText = findViewById(R.id.textView4);

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_state");
            mReplyEditTextHeader.setVisibility(View.VISIBLE);
            mReplyEditText.setText(savedInstanceState.getString("reply_state_messg"));
            mReplyEditText.setVisibility(View.VISIBLE);
        }
    }

    public void send(View view) {
        Log.d(LOG_TAG,"Button click");

        Intent intent= new Intent(this, edu.gcit.todo_4.MainActivity2.class);
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
                String reply = data.getStringExtra(edu.gcit.todo_4.MainActivity2.EXTRA_REPLY);
                mReplyEditTextHeader.setVisibility(View.VISIBLE);
                mReplyEditText.setText(reply);
                mReplyEditText.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        if(mReplyEditTextHeader.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_state",true);
            outState.putString("reply_state_messg",mReplyEditText.getText().toString());
        }
    }

}