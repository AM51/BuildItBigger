package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by archit.m on 24/04/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class FetchJokeTaskTest  {

    private String jokeURL;
    private FetchJokeTask fetchJokeTask;
    private JSONObject jsonObject;

    @Before
    public void setUp() throws Exception {

        jokeURL = "http://10.0.2.2:8080/_ah/api/jokeApi/v1/mybean";
        fetchJokeTask = new FetchJokeTask();
        jsonObject = new JSONObject();


    }

    @Test
    public void testDoInBackground() throws Exception {
        //fetchJokeTask = new FetchJokeTask();
        String joke = fetchJokeTask.doInBackground();
        System.out.println(joke);
        Assert.assertTrue(joke!=null && !joke.equals(""));
    }
}