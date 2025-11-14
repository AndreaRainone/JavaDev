package it.unisa.mensa;

import java.util.HashMap;
import java.util.Map;

public class PagamentoPasti {

    private final Map<Integer, Tesserino> archivio;
    private double totaleIncassato;

    public PagamentoPasti(Map<Integer, Tesserino> archivio, double totaleIncassato) {
        this.archivio = new HashMap<>();
        this.totaleIncassato = totaleIncassato;
    }

    public void aggiungiTesserino(Tesserino t){
        archivio.put(t.getCodice(), t);
    }

    public boolean usaTesserino(int code){
        if(archivio.containsKey(code)){
            Tesserino tesserino = archivio.get(code);

            if(tesserino instanceof TesserinoStudente){
                totaleIncassato += ((TesserinoStudente)tesserino).calcolaPrezzo();
            }else if(tesserino instanceof TesserinoPersonale){
                totaleIncassato += ((TesserinoPersonale)tesserino).paga();
            }
            return true;
        }else{
            return false;
        }
    }

    public double calcolaTotale(){
        return this.totaleIncassato;
    }
}
