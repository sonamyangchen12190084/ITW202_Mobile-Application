package com.example.todo_22;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private EditText Bookinput;
    private TextView TitleText;
    private TextView AuthorText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bookinput = findViewById(R.id.bookInput);
        TitleText = findViewById(R.id.titleText);
        AuthorText = findViewById(R.id.authorText);

        if(getSupportLoaderManager().getLoader(0) != null){
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    public void searchBooks(View view) {
        String queryString = Bookinput.getText().toString();

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() !=0) {
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
//          new FetchBook(TitleText, AuthorText).execute(queryString);
            AuthorText.setText("");
            TitleText.setText("Loading.....");
        }
        else {
            if (queryString.length() == 0) {
                AuthorText.setText("");
                TitleText.setText("Please enter a search term");
            } else {
                AuthorText.setText("");
                TitleText.setText("Please check your network connection");
            }
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";
        if (args != null) {
            queryString = args.getString("queryString");
        }
        return new BookLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            //parse the data using json object and jsonArrays
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemsArray.length() &&
                    authors == null && title == null) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i++;

            if (title != null && authors != null) {
                TitleText.setText(title);
                AuthorText.setText(authors);
            } else {
                TitleText.setText("No Result Found");
                AuthorText.setText("");
            }

        } catch (JSONException e) {
            TitleText.setText("No Result Found");
            AuthorText.setText("");
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}