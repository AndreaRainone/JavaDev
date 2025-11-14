package it.unisa.simulazione2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrandPrix {

    private final List<Autovettura> autovetture;
    private final int km;
    private final int numeroCurve;
    private final int numeroRettilinei;
    private final int giri;


    public GrandPrix(int km, int numeroCurve, int numeroRettilinei, int giri) {
        this.autovetture = new ArrayList<>();
        this.km = km;
        this.numeroCurve = numeroCurve;
        this.numeroRettilinei = numeroRettilinei;
        this.giri = giri;
    }

    public void aggiungiVettura(Autovettura a) throws InsertionException {
        for (Autovettura autovettura : autovetture) {
            if (autovettura.getNome().equals(a.getNome())) {
                throw new InsertionException();
            }
        }
        autovetture.add(a);
        Collections.sort(autovetture);
    }

    public void avviaMotori() {
        for (Autovettura autovettura : autovetture) {
            autovettura.start();
        }
    }

    public void spegniMotori(){
        for(Autovettura autovettura : autovetture){
            autovettura.stop();
        }
    }

    public void pitStop(int i) {
        autovetture.get(i).pitStop();
    }

    public void effettuaGiro(int giri) {

        for (Autovettura autovettura : autovetture) {
            autovettura.getTempoGiro(this.km * this.giri, this.numeroCurve, this.numeroRettilinei);
        }

    }

    public List<Autovettura> getAutovetture() {
        return autovetture;
    }

    @Override
    public String toString() {
        return "GrandPrix{" +
                "autovetture=" + autovetture +
                ", km=" + km +
                ", numeroCurve=" + numeroCurve +
                ", numeroRettilinei=" + numeroRettilinei +
                ", giri=" + giri +
                '}';
    }
}
