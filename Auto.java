package it.unisa.hertz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Auto extends Automezzo {

    public Auto(String marca, String modello, int cavalliFiscali, String targa, LocalDate dataPrestito, boolean isDisponibile) {
        super(marca, modello, cavalliFiscali, targa, dataPrestito, isDisponibile);
    }


    @Override
    public float reso() {

        if (!isDisponibile()) {
            long between = ChronoUnit.DAYS.between(getDataPrestito(), LocalDate.now());
            return between * 3f * getCavalliFiscali();
        } else {
            throw new RuntimeException("L'auto non è stata ancora prestata.");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
