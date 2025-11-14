package it.unisa.simulazione2;

public class Benzina extends Autovettura {

    public Benzina(String nome, int numCavalli, float tempoImpiegato, boolean on) {
        super(nome, numCavalli, tempoImpiegato, on);
    }

    @Override
    public float getTempoGiro(int km, int numeroCurve, int numeroRettilinei) {
        return getTempoGiro(km, numeroCurve, numeroRettilinei, 30f, 30f);
    }


}
