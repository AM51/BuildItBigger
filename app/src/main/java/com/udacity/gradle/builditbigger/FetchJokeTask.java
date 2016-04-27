package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.android.androidjokelibrary.DisplayJokeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by archit.m on 24/04/16.
 */
public class FetchJokeTask extends AsyncTask<Void,Void,String> {

    Context context;


    public FetchJokeTask(Context context) {
        this.context = context;
    }

    public FetchJokeTask() {
    }

    private String DEFAULT_RESPONSE = "No Joke Available";

    @Override
    protected String doInBackground(Void... params) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String jokeInfo = null;

//        Uri.Builder builder=new Uri.Builder();
//        builder.scheme("http")
//                .authority("10.0.2.2:8080")
//                .appendPath("_ah/api")
//                .appendPath("jokeApi/v1")
//                .appendPath("mybean");
//
//
//        Log.v("archit",builder.build().toString());
        URL url = null;
        try {
            url = new URL("http://10.0.2.2:8080/_ah/api/jokeApi/v1/mybean");
            //url = new URL("http://localhost:8080/_ah/api/jokeApi/v1/mybean");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            jokeInfo = buffer.toString();

            return jokeInfo;
//            System.out.println(jokeInfo);
//            JSONObject jokeJson = new JSONObject(jokeInfo);
//
//
//            System.out.println(jokeJson);
//            return jokeJson.getString("data");

        } catch (Exception e){
            Log.e(getClass().getName(), e.getMessage());
        }
        return DEFAULT_RESPONSE;
    }



    @Override
    protected void onPostExecute(String jokeInfo) {
        try {
            super.onPostExecute(jokeInfo);
            JSONObject jsonObject = new JSONObject(jokeInfo);
            String joke = jsonObject.getString("data");
            Intent intent = new Intent(context, DisplayJokeActivity.class);
            intent.putExtra("joke", joke);
            context.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
