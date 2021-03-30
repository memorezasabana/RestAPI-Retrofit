package com.ozzamo.movieproject;

import android.telecom.Call;

public interface MovieService {

    @GET("/JSONParsingTutorial/jsonMovie")
    Call<MovieService> getMovies();
}
