package it.unisa.mensa;

import java.time.LocalDate;

public class TesserinoStudente extends Tesserino {

    private final long  matricola;
    private final LocalDate dataScadenza;
    private double saldo;
    private final FasciaCategorie.Fascia fascia;
    private final boolean hasBonus;


    public TesserinoStudente(int codice, String nome, String cognome, boolean isAttivo, long matricola, LocalDate dataScadenza, double saldo, FasciaCategorie.Fascia fascia, boolean hasBonus) {
        super(codice, nome, cognome, isAttivo);
        this.matricola = matricola;
        this.dataScadenza = dataScadenza;
        this.saldo = saldo;
        this.fascia = fascia;
        this.hasBonus = hasBonus;
    }

    public FasciaCategorie.Fascia getFascia() {
        return fascia;
    }

    public double calcolaPrezzo() {
        double prezzo;

        if (getFascia() == FasciaCategorie.Fascia.A) {
            prezzo = 2.50d;
        } else {
            prezzo = 1.50d;
        }

        if (getHasBonus()) {
            prezzo = prezzo - 1.00d;
        }
        return prezzo;
    }

    public boolean getHasBonus() {
        return this.hasBonus;
    }

    public double paga() throws TesserinoScadutoException {

        double costoPasto = 0d;
        LocalDate today = LocalDate.now();
        if(dataScadenza.isBefore(today)){
            throw new TesserinoScadutoException("Tesserino scaduto."); //CONTROLLATA
        }else{
            if(saldo < costoPasto){
                throw new SaldoInsufficienteException("Saldo insufficiente."); //NON CONTROLLATA
            }else{
                this.saldo = this.getSaldo() - costoPasto;
            }
        }

        return costoPasto;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void versa(double x){
        if (x < 0){
            throw new RuntimeException("Valore da versare non valido");
        }else{
            this.saldo = this.saldo + x;
        }
    }

    public long getMatricola() {
        return matricola;
    }
}
