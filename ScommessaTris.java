package it.unisa.gestionescommessa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScommessaTris extends Scommessa{

    private final TipologiaGara tipo;
    private final boolean tipoScommessa; //true = vincente
    List<String> cavalli;

    public ScommessaTris(String codiceEvento, int sommaPuntata, float quotazioneScommessa, LocalDate dataEvento, TipologiaGara tipo, boolean tipoScommessa, List<String> cavalli){
        super(codiceEvento, sommaPuntata, quotazioneScommessa, dataEvento);
        this.tipo = tipo;
        this.tipoScommessa = tipoScommessa;
        cavalli = new ArrayList<>();
    }

    private int getCavalliSize(){
       return cavalli.size();
    }

    @Override
    public float calcolaVincita(){
        if(tipoScommessa){
            return (getSommaPuntata() * getQuotazioneScommessa()) / getCavalliSize();
        }else{
            return (getSommaPuntata() * getQuotazioneScommessa()) / (getCavalliSize() * 3);
        }
    }

    @Override
    public String getTipo(){
        return "Ippica";
    }

    public boolean isTipoScommessa() {
        return tipoScommessa;
    }
}
