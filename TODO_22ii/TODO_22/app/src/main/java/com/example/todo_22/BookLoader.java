package com.example.todo_22;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class BookLoader extends AsyncTaskLoader<String> {
     private String mQueryString;

    BookLoader(@NonNull Context context, String mQueryString) {
        super(context);
        this.mQueryString = mQueryString;
    }

    public BookLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        forceLoad();
    }
}
