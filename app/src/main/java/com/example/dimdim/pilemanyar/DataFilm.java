package com.example.dimdim.pilemanyar;

import com.google.gson.annotations.SerializedName;

public class DataFilm {
    @SerializedName("title")
    private String judulFilm;
    @SerializedName("release_date")
    private String tanggalFilm;
    @SerializedName("overview")
    private String sinopsisFilm;
    @SerializedName("poster_path")
    private String posterFilm;

    public DataFilm(String judulFilm, String tanggalFilm, String sinopsisFilm, String posterFilm) {
        this.judulFilm = judulFilm;
        this.tanggalFilm = tanggalFilm;
        this.sinopsisFilm = sinopsisFilm;
        this.posterFilm = posterFilm;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public String getTanggalFilm() {
        return tanggalFilm;
    }

    public void setTanggalFilm(String tanggalFilm) {
        this.tanggalFilm = tanggalFilm;
    }

    public String getSinopsisFilm() {
        return sinopsisFilm;
    }

    public void setSinopsisFilm(String sinopsisFilm) {
        this.sinopsisFilm = sinopsisFilm;
    }

    public String getPosterFilm() {
        return posterFilm;
    }

    public void setPosterFilm(String posterFilm) {
        this.posterFilm = posterFilm;
    }
}
