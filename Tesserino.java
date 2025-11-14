package it.unisa.mensa;

public class Tesserino {

    private final int codice;
    private final String nome;
    private final String cognome;
    private boolean isAttivo;


    public Tesserino(int codice, String nome, String cognome, boolean isAttivo) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.isAttivo = isAttivo;
    }

    protected void attiva(){
        this.isAttivo = true;
    }

    protected void disattiva(){
        this.isAttivo = false;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean isAttivo() {
        return isAttivo;
    }
}
