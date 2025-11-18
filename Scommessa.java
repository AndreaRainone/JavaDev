package it.unisa.gestionescommessa;

import java.time.LocalDate;

public abstract class Scommessa {

    private final String codiceEvento;
    private final int sommaPuntata;
    private final float quotazioneScommessa;
    private final LocalDate dataEvento;


    public Scommessa(String codiceEvento, int sommaPuntata, float quotazioneScommessa, LocalDate dataEvento) {
        this.codiceEvento = codiceEvento;

        if(sommaPuntata > 0){
            this.sommaPuntata = sommaPuntata;
        }else throw new IllegalArgumentException("La sommma puntata deve essere maggiore di 0.");

        this.quotazioneScommessa = quotazioneScommessa;

        if(dataEvento.isAfter(LocalDate.now())){
            this.dataEvento = dataEvento;
        }else throw new IllegalArgumentException("La data inserita è antecedente ad oggi.");

    }

    public abstract float calcolaVincita();
    public abstract String getTipo();

    public int getSommaPuntata() {
        return sommaPuntata;
    }

    public float getQuotazioneScommessa() {
        return quotazioneScommessa;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getCodiceEvento() {
        return codiceEvento;
    }

}
