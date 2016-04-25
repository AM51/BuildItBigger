package com.udacity.gradle.builditbigger;

import junit.framework.TestCase;


/**
 * Created by archit.m on 24/04/16.
 */
public class FetchJokeTaskTest extends TestCase {

    private String jokeURL;
    private FetchJokeTask fetchJokeTask;

    public void setUp() throws Exception {
        super.setUp();

        jokeURL = "http://10.0.2.2:8080/_ah/api/jokeApi/v1/mybean";
        fetchJokeTask = new FetchJokeTask();
    }

    public void testDoInBackground() throws Exception {
        String jokeInfo = fetchJokeTask.doInBackground();
        assertTrue(jokeInfo != null);
    }
}