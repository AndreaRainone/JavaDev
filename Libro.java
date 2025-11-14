package it.unisa.libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Libro {

    protected int id = 1;
    protected String titolo;
    protected final String autore;
    protected final int numPagine;
    List<String> listaCapitoli;

    public Libro(){
        this.id = 0;
        this.titolo = "Sconosciuto";
        this.autore = "Sconosciuto";
        this.numPagine = 0;
        this.listaCapitoli = null;
    }

    public Libro(String titolo, int numPagine, List<String> listaCapitoli){
        this.id += 1;
        this.titolo = titolo;
        this.autore = "Sconosciuto";
        this.numPagine = numPagine;
    }

    public Libro(int id, String titolo, String autore, int numPagine, List<String> listaCapitoli){
        this.id += 1;
        this.titolo = titolo;
        this.autore = autore;
        this.numPagine = numPagine;
        this.listaCapitoli = listaCapitoli;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return numPagine == libro.numPagine && Objects.equals(titolo, libro.titolo) && Objects.equals(autore, libro.autore) && Objects.equals(listaCapitoli, libro.listaCapitoli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, autore, numPagine, listaCapitoli);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", numPagine=" + numPagine +
                ", listaCapitoli=" + listaCapitoli +
                '}';
    }

    public String getAutore(){
        return this.autore;
    }

    public String getInitials() {
        String iniziali;
        if (getAutore().equalsIgnoreCase("Sconosciuto")) {
            throw new RuntimeException("Autore sconosciuto, iniziali non disponibili.");
        } else {
            String[] parti = getAutore().split(" ");
            iniziali = "";
            iniziali =
                    String.valueOf(parti[0].charAt(0) +
                            parti[1].charAt(0) +
                            parti[2].charAt(0));
            iniziali.toUpperCase();
        }
        return iniziali;
    }

    public String getTitolo(){
        return titolo;
    }
}
