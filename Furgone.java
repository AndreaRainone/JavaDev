package it.unisa.hertz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Furgone extends Automezzo{

    public Furgone(String marca, String modello, int cavalliFiscali, String targa, LocalDate dataPrestito, boolean disponibile){
        super(marca, modello, cavalliFiscali, targa, dataPrestito, disponibile);
    }

    @Override
    public float reso(){
        long between = ChronoUnit.DAYS.between(getDataPrestito(), LocalDate.now());
        if(getMarca().equalsIgnoreCase("Fiat")){
            return between * 30f;
        }else if(getMarca().equalsIgnoreCase("Citroen")){
            return between * 35f;
        }else{
            return between * 40f;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
