package it.unisa.mensa;

public class TesserinoPersonale extends Tesserino{

    private final String facolta;
    private double sommaSpesa;
    private FasciaCategorie.Categoria categoria;


    public TesserinoPersonale(int codice, String nome, String cognome, boolean isAttivo, String facolta, double sommaSpesa, FasciaCategorie.Categoria categoria) {
        super(codice, nome, cognome, isAttivo);
        this.facolta = facolta;
        this.sommaSpesa = sommaSpesa;
        this.categoria = categoria;
    }


    public String getFacolta() {
        return this.facolta;
    }

    public double getSommaSpesa() {
        return this.sommaSpesa;
    }

    public FasciaCategorie.Categoria getCategoria() {
        return this.categoria;
    }


    public double paga(){
        if(this.categoria == FasciaCategorie.Categoria.DOCENTE){
            this.sommaSpesa = getSommaSpesa() + 1.60d;
        }else{
            this.sommaSpesa = getSommaSpesa() + 4.00d;
        }
        return sommaSpesa;
    }

    public void cambiaCategoria(){
        if(getCategoria() == FasciaCategorie.Categoria.AMMINISTRATIVO){
            this.categoria = FasciaCategorie.Categoria.DOCENTE;
        }else{
            this.categoria = FasciaCategorie.Categoria.AMMINISTRATIVO;
        }
    }
}
