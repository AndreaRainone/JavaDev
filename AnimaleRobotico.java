package it.unisa.zoo;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimaleRobotico{

    private final String id;
    private final String specie;
    private double energia;
    private Stato stato;
    private int livelloAddestramento = 0;
    List<String> tricks = new ArrayList<>();

    public AnimaleRobotico(String id, String specie, double energia, Stato stato) {
        this.id = id;
        this.specie = specie;
        this.energia = energia;
        this.stato = stato;
    }

    public double getEnergia() {
        return this.energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public Stato getStato() {
        return this.stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public String getSpecie(){
        return this.specie;
    }
    public void attiva() {
        if (getEnergia() > 0) {
            setStato(Stato.ATTIVO);
        }
    }

    public void disattiva() {
        setStato(Stato.IN_MANUTENZIONE);
    }

    public double consumaEnergia(double ore) {
        return energia -= ore * 0.5;
    }

    public abstract void comportamento();

    @Override
    public String toString() {
        return "AnimaleRobotico{" +
                "id='" + id + '\'' +
                ", specie='" + specie + '\'' +
                ", energia=" + energia +
                ", stato=" + stato +
                '}';
    }


    public int getLivelloAddestramento() {
        return this.livelloAddestramento;
    }

    public void setLivelloAddestramento(int livelloAddestramento){
        this.livelloAddestramento = livelloAddestramento;
    }

}
