package com.hectorb.mismascotas;


public class Mascota implements Comparable<Mascota>{

    private String nombre;
    private int foto;
    private Integer likes;

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = 0;
    }

    public Mascota(String nombre, int foto, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getLikes() {
        return likes+"";
    }

    public void addLike() {
        this.likes ++;
    }

    public Integer getLik(){
        return likes;
    }

    @Override
    public String toString() {
        return nombre + "/" + foto + "/" + likes;
    }

    @Override
    public int compareTo(Mascota o) {
        return this.getLik().compareTo(o.getLik());
    }
}
