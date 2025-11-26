package it.unisa.avventura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestoreCompagnia {

    private final String nomeCompagnia;
    private final int maxAvventureAttive;
    private List<Avventura> gestore;

    public GestoreCompagnia(String nomeCompagnia, int maxAvventureAttive) {
        this.nomeCompagnia = nomeCompagnia;
        this.maxAvventureAttive = maxAvventureAttive;
        this.gestore = new ArrayList<>();
    }

    public String getNomeCompagnia() {
        return nomeCompagnia;
    }

    public int getMaxAvventureAttive() {
        return maxAvventureAttive;
    }

    public void aggiungiAvventura(Avventura a) {
        gestore.add(a);
        Collections.sort(gestore);
    }

    /*
    avviaAvventure() che avvia tutte le avventure nello stato “Programmata”, fino a un massimo
di maxAvventureAttive avventure contemporaneamente nello stato “In corso”. Se il numero
di avventure già in corso ha raggiunto il limite, le avventure rimanenti restano nello stato
“Programmata”.
     */
    public void avviaAvventure() {

        for (Avventura avventura : gestore) {

            for (int i = 0; i < getMaxAvventureAttive(); i++) {

                if (avventura.getStato() == Stato.PROGRAMMATA) {
                    avventura.setStato(Stato.IN_CORSO);
                }

            }

        }
    }


    public Avventura cercaAvventura(String nome) {
        if (!gestore.isEmpty()) {
            throw new RuntimeException();
        } else {
            for (Avventura avventura : gestore) {
                if (avventura.getNome().equalsIgnoreCase(nome)) {
                    return avventura;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public void annullaAvventureLunghe(int giorniMax) {

        for (Avventura avventura : gestore) {

            if (avventura.getGiorni() > giorniMax) {
                avventura.setStato(Stato.ANNULLATA);
            }

        }

    }

    public void eseguiCombattimenti(){


        for (Avventura avventura : gestore) {
            try{
                Combattente combattente = (Combattente)avventura;
                combattente.combatti();
            }catch(Exception e){
                continue;
            }
        }
    }

    public Avventura stampaAvventura(){
        for (Avventura avventura : gestore){
            avventura.toString();
        }
        return null;
    }

}
