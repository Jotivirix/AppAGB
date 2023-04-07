package ufv.albertogarcia.mydatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText author;
    EditText title;
    EditText year;

    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        author= findViewById(R.id.textAuthor);
        title = findViewById(R.id.textTitle);
        year = findViewById(R.id.textYear);
        addButton = findViewById(R.id.botonAdd);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String autorInsertado = author.getText().toString().trim();
                String tituloInsertado = title.getText().toString().trim();
                String duracion = year.getText().toString().trim();

                System.out.println("La cancion a insertar es: " + tituloInsertado
                        + " del autor: " + autorInsertado
                        + " lanzada en el año: " + duracion);

                DataBaseHelper database =new DataBaseHelper(AddActivity.this);

                Cancion songToInsert = new Cancion (tituloInsertado, autorInsertado,  Integer.valueOf(duracion));

                database.createSong(songToInsert);
            }
        });
    }
}