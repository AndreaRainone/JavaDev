package it.unisa.mensa;

public class TesserinoPersonale extends Tesserino {

    private final String facolta;
    private double sommaSpesa;
    private String categoria;


    public TesserinoPersonale(String codice, String nome, String cognome, boolean attivo, String facolta, double sommaSpesa, String categoria) {
        super(codice, nome, cognome, attivo);
        this.facolta = facolta;
        if (categoria.equalsIgnoreCase("docente") || categoria.equalsIgnoreCase("amministrativo")) {
            this.categoria = categoria;
        } else {
            throw new IllegalArgumentException("Fascia studente non valida. Scegli 'A' o 'B'");
        }
        this.sommaSpesa = sommaSpesa;
    }

    public double paga(double sommaSpesa) {
        if (categoria.equalsIgnoreCase("docente")) {
            return sommaSpesa += 1.60d;
        }
        return sommaSpesa += 4.00d;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void cambiaCategoria() {

        if (!categoria.equalsIgnoreCase("docente")) {
            categoria = "docente";
        } else {
            categoria = "amministrativo";
        }

    }

    public String getFacolta() {
        return facolta;
    }

    public double getSommaSpesa() {
        return sommaSpesa;
    }

    public void setSommaSpesa(double sommaSpesa) {
        this.sommaSpesa = sommaSpesa;
    }

}
