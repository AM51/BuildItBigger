package com.example.archit.m.myapplication.backend;

import com.example.JokeGenerator;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * Created by archit.m on 24/04/16.
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.m.archit.example.com",
                ownerName = "backend.myapplication.m.archit.example.com",
                packagePath=""
        )
)
public class JokeEndPoint {
        @ApiMethod(name = "getJoke")
        public MyBean getJoke() {
            JokeGenerator jokeGenerator = new JokeGenerator();
            String joke = jokeGenerator.getJoke();
            MyBean myBean = new MyBean();
            myBean.setData(joke);
            return myBean;
        }
}
