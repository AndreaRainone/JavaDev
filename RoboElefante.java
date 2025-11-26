package it.unisa.zoo;

import java.util.Random;

public class RoboElefante extends AnimaleRobotico implements Addestrabile{

    private final double capacitaSollevamento;

    public RoboElefante(String id, String specie, double energia, Stato stato, double capacitaSollevamento){
        super(id, specie, energia, stato);
        this.capacitaSollevamento = capacitaSollevamento;
    }

    public double getCapacitaSollevamento() {
        return this.capacitaSollevamento;
    }

    @Override
    public void comportamento(){
        Random rnd = new Random();
        int pesoSollevato = 1 + rnd.nextInt((int) getCapacitaSollevamento());
        setEnergia(getEnergia() - (pesoSollevato / getCapacitaSollevamento()));
        if(getEnergia() == 0){
            setStato(Stato.DORMIENTE);
        }
    }

    @Override
    public void addestra(){
        if(getEnergia() > 0){
            setEnergia(getEnergia() - 1.5);
        }
        setLivelloAddestramento(getLivelloAddestramento() + 1);
        if(getLivelloAddestramento() > 1){
            tricks.add("Solleva Pesi");
        }else if(getLivelloAddestramento() > 3){
            tricks.add("Spruzza Acqua");
        }else if(getLivelloAddestramento() > 6){
            tricks.add("Trascina Oggetti");
        }
    }

    @Override
    public boolean puoEseguire(String trick){
        return tricks.contains(trick);
    }

    @Override
    public String toString() {
        return "RoboElefante{" +
                "capacitaSollevamento=" + capacitaSollevamento +
                '}';
    }
}
