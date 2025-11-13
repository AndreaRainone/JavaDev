package it.unisa.mensa;

public class Tesserino {

    protected final String codice;
    protected final String nome;
    protected final String cognome;
    protected boolean attivo;


    public Tesserino(String codice, String nome, String cognome, boolean attivo) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.attivo = attivo;
    }


    //METODO ATTIVA
    public void attiva(boolean attivo) {
        this.attivo = true;
    }

    //METODO DISATTIVA
    public void disattiva(boolean attivo) {
        this.attivo = false;
    }


}
