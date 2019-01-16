package com.example.dimdim.pilemanyar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceFilm {
    @GET("search/movie/")
    Call<FilmResponse> getSearchFilm(@Query("api_key") String API_KEY, @Query("language") String language, @Query("query") String judul);
}
