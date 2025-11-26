package it.unisa.zoo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestoreZooRobotico {

    private final String nomeZoo;
    private final int capienzaMassima;
    List<AnimaleRobotico> gestoreZoo = new ArrayList<>();


    public GestoreZooRobotico(String nomeZoo, int capienzaMassima) {
        this.nomeZoo = nomeZoo;
        this.capienzaMassima = capienzaMassima;
    }

    public void aggiungiAnimale(AnimaleRobotico a) {
        if (gestoreZoo.size() == capienzaMassima) {
            throw new RuntimeException("Capienza massima raggiunta.");
        } else {
            gestoreZoo.add(a);
            gestoreZoo.sort(Comparator.comparing(AnimaleRobotico::getSpecie));
        }
    }

    public void attivaTutti() {
        for (AnimaleRobotico animale : gestoreZoo) {
            if (animale.getStato() == Stato.DORMIENTE) {
                animale.setStato(Stato.ATTIVO);
            }
        }
    }

    public void eseguiSpettacolo() {
        for (AnimaleRobotico animale : gestoreZoo) {
            if (animale instanceof Addestrabile) {
                ((Addestrabile) animale).addestra();
                animale.comportamento();
            } else {
                animale.comportamento();
            }
        }
    }

    public void addestra(int i, int j) {
        for (AnimaleRobotico animale : gestoreZoo){
            if(animale instanceof Addestrabile){
                for(int a = 0; a < j; a++){
                    ((Addestrabile) animale).addestra();
                }
            }
        }
    }

    public void consumoGenerale(double ore) {

        if (!gestoreZoo.isEmpty()) {
            for (AnimaleRobotico animale : gestoreZoo) {
                animale.consumaEnergia(ore);
            }
        } else {
            throw new RuntimeException("Lista vuota per consumo.");
        }

    }


    public AnimaleRobotico filtraPerSpecie(String specie) {
        boolean sino = true;
        for (AnimaleRobotico animale : gestoreZoo) {
            while (sino) {

                if (animale.getSpecie().equalsIgnoreCase(specie)) {
                    sino = false;
                }
            }
            return animale;
        }
        return null;
    }

    public void eseguiTrick(String trick){
        for(AnimaleRobotico animale : gestoreZoo){
            if(animale.tricks.contains(trick)){
                animale.toString();
            }
        }
    }

    public void stampaAnimali(){
        for(AnimaleRobotico animale : gestoreZoo){
            animale.toString();
        }
    }

}
