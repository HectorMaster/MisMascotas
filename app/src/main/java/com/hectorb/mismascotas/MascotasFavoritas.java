package com.hectorb.mismascotas;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getDatos();

        listaMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMascotas.setLayoutManager(llm);
        MascotaAdaptador adaptador = new MascotaAdaptador((mascotas),this);
        listaMascotas.setAdapter(adaptador);


    }

    public void getDatos(){
        Bundle parametros = getIntent().getExtras();
        String[] recibido;
        mascotas = new ArrayList<Mascota>();
        for (int i = 0; i < 5; i++){
            recibido = parametros.getString("Favorito"+i).split("/");
            System.out.println("Mascota: " + parametros.getString("Favorito"+i));
            System.out.println("Mascota[0]: " + recibido[0]);
            System.out.println("Mascota[1]: " + recibido[1]);
            System.out.println("Mascota[2]: " + recibido[2]);
            mascotas.add(new Mascota(recibido[0],
                    Integer.parseInt(recibido[1]),
                    Integer.parseInt(recibido[2])));
        }
    }


}
