package com.example.dimdim.pilemanyar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class FilmClients {
    private static Retrofit retrofit = null;

    static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
