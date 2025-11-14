package it.unisa.hertz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Moto extends Automezzo {

    public Moto(String marca, String modello, int cavalliFiscali, String targa, LocalDate dataPrestito, boolean disponibile) {
        super(marca, modello, cavalliFiscali, targa, dataPrestito, disponibile);
    }

    private int getWeekend() {

        int numGiorniWeekend = 0;
        while (getDataPrestito().isAfter(LocalDate.now())) {
            DayOfWeek weekend = getDataPrestito().getDayOfWeek();
            if (weekend == DayOfWeek.SATURDAY || weekend == DayOfWeek.SUNDAY) {
                numGiorniWeekend++;
            }
        }
        return numGiorniWeekend;
    }

    private int getInfrasettimanali() {
        long between = ChronoUnit.DAYS.between(getDataPrestito(), LocalDate.now());
        return (int) between - getWeekend();
    }

    @Override
    public float reso() {
        return 30 * getWeekend() + 20 * getInfrasettimanali();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
