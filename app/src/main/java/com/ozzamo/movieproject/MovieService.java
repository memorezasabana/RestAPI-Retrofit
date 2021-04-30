package com.ozzamo.movieproject;


import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

//@GET("/JSONParsingTutorial/jsonMovie")
//Call<MovieService> getMovies();

    //merubah kode menjadi seperi berikut
    @GET("/")
    Call<MovieResponse> getMovies();
}