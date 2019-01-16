package com.example.dimdim.pilemanyar;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {

    List<DataFilm> dataFilms;
    Context context;

    public List<DataFilm> getDataFilms() {
        return dataFilms;
    }

    public void setDataFilms(List<DataFilm> dataFilms) {
        this.dataFilms = dataFilms;
    }

    public FilmAdapter(List<DataFilm> dataFilms, Context context) {

        this.dataFilms = dataFilms;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmAdapter.FilmHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FilmHolder(LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.FilmHolder filmHolder, int i) {
        DataFilm dataFilm = dataFilms.get(i);

        filmHolder.judulFilm.setText(dataFilm.getJudulFilm());
        filmHolder.tanggalFilm.setText(dataFilm.getTanggalFilm());
        filmHolder.sinopsisFilm.setText(dataFilm.getSinopsisFilm());

        Picasso.with(context).load("http://image.tmdb.org/t/p/w185/"+dataFilm.getPosterFilm()).into(filmHolder.sampulFilm);

        filmHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFilm.class);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FilmHolder extends RecyclerView.ViewHolder {
        ImageView sampulFilm;
        TextView judulFilm;
        TextView tanggalFilm;
        TextView sinopsisFilm;

        FilmHolder(@NonNull View itemView) {
            super(itemView);

            sampulFilm = itemView.findViewById(R.id.gambar_sampul);
            judulFilm = itemView.findViewById(R.id.judul_film);
            tanggalFilm = itemView.findViewById(R.id.tanggal_film);
            sinopsisFilm = itemView.findViewById(R.id.sinopsis_film);

        }
    }
}
