package ufv.albertogarcia.mydatabaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton boton;
    RecyclerView recyclerView;
    DataBaseHelper dbHelper;
    CustomAdapter customAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.boton = findViewById(R.id.addButton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(myIntent);
            }
        });

        dbHelper = new DataBaseHelper(MainActivity.this);

        ArrayList <Cancion> canciones = dbHelper.getCanciones();

        for(int i=0; i<canciones.size(); i++){
            System.out.println("La canción " + i + " es: " + canciones.get(i).getTitle()
                    + " compuesta por: " + canciones.get(i).getAuthor()
                    + " en el año: "+ canciones.get(i).getYear());
        }

        recyclerView = findViewById(R.id.recyclerView);

        customAdapter = new CustomAdapter(MainActivity.this, canciones);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

}