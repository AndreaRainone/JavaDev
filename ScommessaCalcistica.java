package it.unisa.gestionescommessa;

import java.time.LocalDate;

public class ScommessaCalcistica extends Scommessa{

    private final String tipoCompetizione;
    private final String squadraA;
    private final String squadraB;
    private final Risultato scommessa;

    public ScommessaCalcistica(String codiceEvento, int sommaPuntata, float quotazioneScommessa, LocalDate dataEvento, String tipoCompetizione, String squadraA, String squadraB, Risultato scommessa){
        super(codiceEvento, sommaPuntata, quotazioneScommessa, dataEvento);
        this.tipoCompetizione = tipoCompetizione;
        this.squadraA = squadraA;
        this.squadraB = squadraB;
        this.scommessa = scommessa;
    }

    @Override
    public float calcolaVincita(){
        return getSommaPuntata() * getQuotazioneScommessa();
    }

    @Override
    public String getTipo(){
        return "Calcio";
    }

}
