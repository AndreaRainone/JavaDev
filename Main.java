package it.unisa.simulazione2;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException, InsertionException {

        int min = 3;
        int max = 10;
        int rnd = ThreadLocalRandom.current().nextInt(min, max+1);

        GrandPrix gara1 = new GrandPrix(6,12,5,rnd);

        Benzina auto = new Benzina("Panda", 25, 25.5f, true);
        Elettrico auto2 = new Elettrico("Tesla Model Y", 347, 100f, true);
        Ibrido auto3 = new Ibrido("Toyota", 30, 20.5f, false);
        Elettrico auto4 = new Elettrico("Tesla Model Y", 347, 100f, false);
        Ibrido auto5 = new Ibrido("Golf GTI", 300, 15f, true);

        try{
            gara1.aggiungiVettura(auto);
            gara1.aggiungiVettura(auto2);
            gara1.aggiungiVettura(auto3);
            gara1.aggiungiVettura(auto4);
            gara1.aggiungiVettura(auto5);
        } catch(InsertionException e){
            System.out.println("Una delle auto è già presente");
        }

        gara1.avviaMotori();

        for (int i = 1; i <= rnd; i++){
            gara1.effettuaGiro(rnd);
            if(i==2){
                gara1.pitStop(0);
            }
        }

      //AGGIUNGERE STAMPA RISULTATI GARA

        gara1.spegniMotori();
//
//        try {
//            System.out.println(auto4.getTempoGiro(6, 12, 5));
//        } catch (AutoSpentaException e) {
//            System.out.println("L'auto è spenta.");
//        }
    }

}
