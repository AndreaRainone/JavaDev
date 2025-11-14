package it.unisa.libreria;

public class Volume extends Libro{

    private final String titoloEnciclopedia;
    private final String nomeCuratore;


    public Volume(String titoloEnciclopedia, String nomeCuratore) {
        this.titoloEnciclopedia = titoloEnciclopedia;
        this.nomeCuratore = nomeCuratore;
    }

    public String getTitoloEnciclopedia() {
        return titoloEnciclopedia;
    }

    public String getNomeCuratore() {
        return nomeCuratore;
    }
}
