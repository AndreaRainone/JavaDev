package it.unisa.avventura;

public abstract class Avventura implements Comparable<Avventura>{

    private final String nome;
    private final int livelloDifficolta;
    private final int durataGiorni;
    private Stato stato;


    public Avventura(String nome, int livelloDifficolta, int durataGiorni) {
        this.nome = nome;
        this.livelloDifficolta = livelloDifficolta;
        this.durataGiorni = durataGiorni;
    }

    public Stato getStato(){
        return this.stato;
    }

    public Stato setStato(Stato stato){
        return this.stato = stato;
    }

    public String getNome(){
        return this.nome;
    }

    public void avvia(){
        if(getStato() == Stato.PROGRAMMATA){
            this.stato = Stato.IN_CORSO;
        }
    }

    public void completa(){
        if(getStato() == Stato.IN_CORSO){
            this.stato = Stato.COMPLETATA;
        }
    }

    public void annulla(){
        this.stato = Stato.ANNULLATA;
    }

    public int getGiorni(){
        return this.durataGiorni;
    }

    public int getLivelloDifficolta(){
        return this.livelloDifficolta;
    }

    public abstract double calcolaRicompensa();

    @Override
    public String toString() {
        return "Avventura{" +
                "nome='" + nome + '\'' +
                ", livelloDifficolta=" + livelloDifficolta +
                ", durataGiorni=" + durataGiorni +
                ", stato=" + stato +
                '}';
    }

    @Override
    public int compareTo(Avventura a) {
        return Integer.compare(livelloDifficolta, a.livelloDifficolta);
    }
}
