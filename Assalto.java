package it.unisa.avventura;

import java.util.Random;

public class Assalto extends Avventura implements Combattente {

    private final int gradoPericolo;

    public Assalto(String nome, int livelloDifficolta, int durataGiorni, int gradoPericolo) {
        super(nome, livelloDifficolta, durataGiorni);
        this.gradoPericolo = gradoPericolo;
    }

    public int getGradoPericolo() {
        return this.gradoPericolo;
    }

    @Override
    public double calcolaRicompensa() {
        return (200 * getGradoPericolo()) + (getLivelloDifficolta() * 40);
    }

    @Override
    public int getForza() {
        return 10 * getGradoPericolo();
    }

    private int getPericoloAssalto(){
        Random rnd = new Random();
        int numero = 1 + rnd.nextInt(14);
        return numero*getGradoPericolo();
    }

    @Override
    public String combatti(){
        if(getForza() > (getGradoPericolo()*1.5)){
            return "Assalto riuscito alla perfezione";
        }else if((getForza() > 1.5 * getPericoloAssalto()) || (getForza() < getPericoloAssalto())){
            return "Assalto riuscito con difficoltà";
        }else if( getForza() == getPericoloAssalto() ){
            return "Stallo";
        }else{
            return "Assalto fallito";
        }
    }

    @Override
    public String toString() {
        return "Assalto{" +
                "gradoPericolo=" + gradoPericolo +
                '}';
    }
}
