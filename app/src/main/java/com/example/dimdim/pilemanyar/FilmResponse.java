package com.example.dimdim.pilemanyar;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmResponse {

    @SerializedName("results")
    private List <DataFilm> dataFilms;

    public FilmResponse(List<DataFilm> dataFilms) {
        this.dataFilms = dataFilms;
    }

    public List<DataFilm> getDataFilms() {
        return dataFilms;
    }

    public void setDataFilms(List<DataFilm> dataFilms) {
        this.dataFilms = dataFilms;
    }
}
