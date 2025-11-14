package it.unisa.simulazione2;

public class Elettrico extends Autovettura {


    public Elettrico(String nome, int numCavalli, float tempoImpiegato, boolean on) {
        super(nome, numCavalli, tempoImpiegato, on);
    }

    @Override
    public float getTempoGiro(int km, int numeroCurve, int numeroRettilinei) {
        return getTempoGiro(km, numeroCurve, numeroRettilinei, 15f, 45f);
    }


}
