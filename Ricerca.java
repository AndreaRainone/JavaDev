package it.unisa.avventura;

public class Ricerca extends Avventura{

    private final int distanzaKm;

    public Ricerca(String nome, int livelloDifficolta, int durataGiorni, int distanzaKm){
        super(nome, livelloDifficolta, durataGiorni);
        this.distanzaKm = distanzaKm;
    }


    private int getDistanzaKm() {
        return this.distanzaKm;
    }


    @Override
    public double calcolaRicompensa(){
        return (30 * getGiorni()) + (5 * getDistanzaKm());
    }


}
