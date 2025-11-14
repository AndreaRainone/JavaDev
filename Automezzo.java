package it.unisa.hertz;

import java.time.LocalDate;

public abstract class Automezzo {

    protected final String marca; //serve getter per sottoclassi
    protected final int cavalliFiscali; //serve getter per sottoclassi
    protected LocalDate dataPrestito; //serve getter per sottoclassi
    protected boolean disponibile; //serve getter per sottoclassi
    public final String targa; //serve getter per Hertz
    public final String modello; //serve getter per Hertz


    public Automezzo(String marca, String modello, int cavalliFiscali, String targa, LocalDate dataPrestito, boolean disponibile) {
        this.marca = marca;
        this.modello = modello;
        this.cavalliFiscali = cavalliFiscali;
        this.targa = targa;
        this.dataPrestito = dataPrestito;
        this.disponibile = disponibile;
    }

    protected String getMarca() {
        return this.marca;
    }

    protected int getCavalliFiscali() {
        return this.cavalliFiscali;
    }

    protected LocalDate getDataPrestito() {
        return this.dataPrestito;
    }

    protected boolean isDisponibile() {
        return this.disponibile;
    }

    public String getTarga() {
        return this.targa;
    }

    public String getModello() {
        return this.modello;
    }

    public boolean prestito() {
        if (isDisponibile()) {
            this.disponibile = false;
            this.dataPrestito = LocalDate.now();
        }
        return this.disponibile;
    }

    public abstract float reso();

    @Override
    public String toString() {
        return "Automezzo{" +
                "marca='" + marca + '\'' +
                ", cavalliFiscali=" + cavalliFiscali +
                ", dataPrestito=" + dataPrestito +
                ", disponibile=" + disponibile +
                ", modello='" + modello + '\'' +
                ", targa='" + targa + '\'' +
                '}';
    }
}
