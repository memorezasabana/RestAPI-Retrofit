package com.ozzamo.movieproject;

import android.util.Log;

import com.bumptech.glide.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static MovieService service;

    public static MovieService getMovieService() {
        if (service == null) {
            String API_BASE_URL = "http://www.omdbapi.com";

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) {
                loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            } else {
                loggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
            }

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(loggingInterceptor);

            httpClient.addInterceptor(chain -> {
                Request request = chain.request();
                String newUrl = request.url().toString()
                        .replace("www.omdbapi.com", "www.omdbapi.com?apikey=2268147d&s=batman");
                return chain.proceed(
                        request.newBuilder()
                                .url(newUrl)
                                .build()
                );
            });

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(MovieService.class);
        }
        return service;

    }
}
