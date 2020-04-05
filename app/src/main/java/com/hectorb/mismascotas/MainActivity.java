package com.hectorb.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
        findViewById(R.id.btnFavoritos).setVisibility(View.VISIBLE);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais", R.drawable.mascota1));
        mascotas.add(new Mascota("Fifi", R.drawable.mascota2));
        mascotas.add(new Mascota("Jenny", R.drawable.mascota3));
        mascotas.add(new Mascota("Kika", R.drawable.mascota4));
        mascotas.add(new Mascota("Solovino", R.drawable.mascota5));
        mascotas.add(new Mascota("Max", R.drawable.mascota6));
        mascotas.add(new Mascota("Kiki", R.drawable.mascota7));
        mascotas.add(new Mascota("Tina", R.drawable.mascota8));

    }

    public void getFavoritos(){

        mascotasFavoritas = mascotas;
        Collections.sort(mascotasFavoritas, Collections.reverseOrder());

    }

    public void verFavoritos(View v){
        getFavoritos();
        Intent intent = new Intent(this, MascotasFavoritas.class);
        for(int i = 0; i < 5; i++){
            System.out.println("MascotaFav: " + mascotasFavoritas.get(i).toString());
            intent.putExtra("Favorito"+i,mascotasFavoritas.get(i).toString());
        }
        startActivity(intent);
    }

}
