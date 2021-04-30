[![Android RestAPI](https://img.shields.io/badge/Android%20RestAPI-Retrofit--Library-brightgreen.svg?style=flat)](https://medium.com/android-news/consuming-rest-api-using-retrofit-library-in-android-ed47aef01ecb)

## What is Retrofit?
Retrofit is a REST Client library (Helper Library) used in Android and Java to create an HTTP request and also to process the HTTP response from a REST API. 
It was created by Square, you can also use retrofit to receive data structures other than JSON, for example SimpleXML and Jackson. Before we continue, 
let’s briefly define REST Client and REST API in our context.

- [x] REST Client in our case is the Retrofit library that is used on the client side (Android) to make HTTP request to REST API, in our case, 
The Movie DB API and also process the response.

- [x] A REST API defines a set of functions which developers can perform requests and receive responses via HTTP protocol such as GET and POST. 
in our case, The Movie DB (TMDB) API is the REST API.

- [x] We can also simply say that a RESTful API is an application program interface (API) that uses HTTP requests to GET, PUT, POST and DELETE data.

> - GET, berfungsi untuk membaca data/resource dari REST server
> - POST, berfungsi untuk membuat sebuah data/resource baru di REST server
> - PUT, berfungsi untuk memperbaharui data/resource di REST server
> - DELETE, berfungsi untuk menghapus data/resource dari REST server
> - OPTIONS, berfungsi untuk mendapatkan operasi yang disupport pada resource dari REST server 

## Untuk menggunakan Retrofit di Aplikasi Android, Anda memerlukan 3 Major Class:
- Interface yang mendefinisikan operasi HTTP (Fungsi atau metode)
```java
public interface GitHubService {
@GET("users/{user}/repos")
Call<List<Repo>> listRepos(@Path("user") String user);
@GET("group/{id}/users")
Call<List<User>> groupList(@Path("id") int groupId);
}
```

- Retrofit class
```java
@GET(“group/{id}/users”)
Call<List<User>> groupList(@Path(“id”) int groupId, @Query(“sort”) String sort);
```

- Class terakhir dari 3 class yang dibutuhkan adalah POJO sederhana

## Movie Project
SplashScreen | Menu Utama | Full Project
--- | --- | ---
![splashscreen] | ![menu_utama] | ![full_project]

### Link API
http://www.omdbapi.com/?s=batman&apikey=2268147d

[splashscreen]: https://github.com/memorezasabana/RestAPI-Retrofit/blob/master/RestAPI-Retrofit/ss-splashscreen.jpg
[menu_utama]: https://github.com/memorezasabana/RestAPI-Retrofit/blob/master/RestAPI-Retrofit/ss-RestApi-Retrofit.jpg
[full_project]: https://github.com/memorezasabana/RestAPI-Retrofit/blob/master/RestAPI-Retrofit/RestApi-Retrofit.gif
