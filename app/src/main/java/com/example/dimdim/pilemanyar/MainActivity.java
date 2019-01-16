package com.example.dimdim.pilemanyar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button tombolJudul;
    EditText inputJudul;
    RecyclerView listJudul;

    FilmAdapter filmAdapter;
    List<DataFilm> dataFilms;
    String API_KEY = "b1dca0c5a8cfff9e5b20dea41f8ae346";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tombolJudul = findViewById(R.id.tombol_cari);
        tombolJudul.setOnClickListener(this);

        inputJudul = findViewById(R.id.input_judul);
        listJudul = findViewById(R.id.list_film);

        dataFilms = new ArrayList<>();
        filmAdapter = new FilmAdapter(dataFilms, this);
        filmAdapter.notifyDataSetChanged();

        listJudul.setHasFixedSize(true);
        listJudul.setLayoutManager(new LinearLayoutManager(this));
        listJudul.setAdapter(filmAdapter);

    }

    @Override
    public void onClick(View v) {

        InterfaceFilm interfaceFilm;
        Call<FilmResponse> filmResponseCall;

        final String judulFilm = inputJudul.getText().toString();
        String lang = "en-US";

        interfaceFilm = FilmClients.getClient().create(InterfaceFilm.class);
        filmResponseCall = interfaceFilm.getSearchFilm(API_KEY, lang, judulFilm);

        filmResponseCall.enqueue(new Callback<FilmResponse>() {
            @Override
            public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {
                if (response.body() == null){
                    Toast.makeText(getApplicationContext(), "Tidak ada film dengan judul"+judulFilm, Toast.LENGTH_LONG).show();

                }
                else{
                    dataFilms = response.body().getDataFilms();
                    filmAdapter = new FilmAdapter(dataFilms, getApplicationContext());
                    filmAdapter.notifyDataSetChanged();

                    listJudul.setAdapter(filmAdapter);
                    Toast.makeText(getApplicationContext(), "Judul Ada", Toast.LENGTH_LONG).show();
                }
                            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Memuat", Toast.LENGTH_LONG).show();

            }
        });

    }
}
