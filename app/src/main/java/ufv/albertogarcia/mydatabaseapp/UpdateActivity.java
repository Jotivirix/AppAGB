package ufv.albertogarcia.mydatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText editSongTitle;
    EditText editSongAuthor;
    EditText editSongDuracion;

    Button updateButton;
    Button deleteButton;

    DataBaseHelper myDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        String arrayPosition = getIntent().getStringExtra("arrayPosition");
        String songId = getIntent().getStringExtra("songId");
        String songAuthor = getIntent().getStringExtra("author");
        String songTitle = getIntent().getStringExtra("title");
        String songDuracion = getIntent().getStringExtra("duracion");

        System.out.println("La canción seleccionada está en la posición: " + arrayPosition
                + " su ID en la base de datos es: " + songId
                + " su autor es: " + songAuthor
                + ", su título es: " + songTitle
                + ", y dura " + songDuracion + " minutos.");

        editSongTitle = findViewById(R.id.editTextTitulo);
        editSongTitle = findViewById(R.id.editTextArtist);
        editSongDuracion = findViewById(R.id.editTextDuracion);

        editSongTitle.setText(songTitle);
        editSongAuthor.setText(songAuthor);
        editSongDuracion.setText(songDuracion);

        updateButton = findViewById(R.id.buttonEditSong);

        myDataBaseHelper = new DataBaseHelper(UpdateActivity.this);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle = editSongTitle.getText().toString().trim();
                String newAuthor = editSongAuthor.getText().toString().trim();
                int newDuracion = Integer.valueOf(editSongDuracion.getText().toString().trim());

                myDataBaseHelper.updateSong(songId, newTitle, newAuthor, newDuracion);
            }
        });
        deleteButton = findViewById(R.id.buttonDeleteSong);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataBaseHelper.deleteSong(songId);
            }
        });
    }
}