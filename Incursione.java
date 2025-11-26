package it.unisa.avventura;

import java.util.Random;

public class Incursione extends Avventura implements Combattente{

    private final int numeroNemici;
    private int sommaForzaNemici = 0;

    public Incursione(String nome, int livelloDifficolta, int durataGiorni, int numeroNemici){
        super(nome, livelloDifficolta, durataGiorni);
        this.numeroNemici = numeroNemici;
    }

    private int getNumeroNemici() {
        return this.numeroNemici;
    }

    @Override
    public double calcolaRicompensa(){
        return (50 * getGiorni()) + (20 * getNumeroNemici());
    }

    @Override
    public int getForza(){
        return 5 * getNumeroNemici();
    }

    private int getSommaForzaNemici(){
        Random rnd = new Random();
        for(int i = 0; i <= getNumeroNemici(); i++){
            sommaForzaNemici += 1+rnd.nextInt(7);
        }
        return sommaForzaNemici;
    }

     @Override
    public String combatti(){
        if(getForza() > 1.5 * getSommaForzaNemici()){
            return "Vittoria Schiacciante";
        }else if( (getForza() > 1.5 * getSommaForzaNemici()) || (getForza() < getSommaForzaNemici())){
            return "Vittoria Sofferta";
        }else if(getForza() == getSommaForzaNemici()){
            return "Pareggio";
        }else{
            return "Sconfitta";
        }
     }

    @Override
    public String toString() {
        return "Incursione{" +
                "numeroNemici=" + numeroNemici +
                ", sommaForzaNemici=" + sommaForzaNemici +
                '}';
    }
}
