package ufv.albertogarcia.mydatabaseapp;

public class Cancion {
    private int Id;
    private String Title;
    private String author;
    private int Duracion;

    public Cancion(String title, String author, int year) {
        Title = title;
        this.author = author;
        Duracion = year;
    }

    public Cancion(int id, String title, String author, int year) {
        Id = id;
        Title = title;
        this.author = author;
        Duracion = year;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }
}
