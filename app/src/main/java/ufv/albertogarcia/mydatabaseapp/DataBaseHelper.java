package ufv.albertogarcia.mydatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    private Context myContext;
    private static final String DATABASE_NAME = "MySongsDataBase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Songs";

    public DataBaseHelper(@Nullable Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
        myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se crea la base de datos
        String query = "CREATE TABLE " + TABLE_NAME +
            " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " title TEXT NOT NULL, " +
            " author TEXT NOT NULL, " +
            " year DOUBLE)";
        db.execSQL(query);

    }

    void createSong (Cancion song){
        //Obtenemos los valores del objeto canción
        String title = song.getTitle();
        String author = song.getAuthor();
        int year = song.getYear();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("author", author);
        contentValues.put("year", year);

        SQLiteDatabase database = this.getWritableDatabase();

        long result =database.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            Toast.makeText(myContext, "There has been an error", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(myContext, "Song inserted successfully", Toast.LENGTH_SHORT).show();
        }

    }

    ArrayList <Cancion> getCanciones(){
        ArrayList <Cancion> canciones = new ArrayList<Cancion> ();
        //Query para obtener las canciones
        String query = " SELECT id, title, author, year FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor resultado = database.rawQuery(query, null);

        while (resultado.moveToNext()){
            canciones.add(new Cancion (resultado.getInt(0),
                    resultado.getString(1),
                    resultado.getString(2),
                    resultado.getInt(3)));
        }
        resultado.close();
        return canciones;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void updateSong(String id, String title, String author, int year){
        SQLiteDatabase database =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("author", author);
        contentValues.put("year", year);

        long result = database.update(TABLE_NAME, contentValues, "id = ?", new String [] {id});

        if (result == -1 ){
            Toast.makeText(myContext, "Error @ update the book", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(myContext, "Book Updated!", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteSong(String bookSelected) {
        SQLiteDatabase database= this.getWritableDatabase();

        long result = database.delete(TABLE_NAME, "id = ?", new String[]{bookSelected});

        if (result == -1 ){
            Toast.makeText(myContext, "Error @ update the book", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(myContext, "Book Successfully Deleted!", Toast.LENGTH_SHORT).show();
        }
    }
 }
