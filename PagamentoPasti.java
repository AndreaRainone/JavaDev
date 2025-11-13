package it.unisa.mensa;


import java.util.ArrayList;
import java.util.List;

public class PagamentoPasti {

    List<Tesserino> tesserinoList = new ArrayList<>();
    ;
    private final int code;
    private double costoTotale;


    public PagamentoPasti(int code, double costoTotale) {
        this.code = code;
        this.costoTotale = costoTotale;
    }

    public void aggiungiTesserino(Tesserino t) {
        tesserinoList.add(t);
    }

    public boolean usaTesserino(int code) {
        boolean test = false;
        for (Tesserino tesserino : tesserinoList) {
            if (!tesserinoList.equals(code)) {
                continue;
            }
            test = true;
        }
        return test;
    }

//    /*
//    * double calcolaTotale() che restituisce la somma incassata fino a quello istante. N.B. Utilizzare una
//      variabile che tiene traccia di tale somma durante i pagamenti.
//     */
//    public double calcolaTotale(double sommaTotale){
//
//        for(Tesserino tesserino : tesserinoList){
//           sommaTotale += (double)tesserinoList.get(1);
//        }
//        return 0;
//    }
}
