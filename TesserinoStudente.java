package it.unisa.mensa;

import java.time.LocalDate;

public class TesserinoStudente extends Tesserino {

    private final String matricola;
    private final LocalDate scadenza;
    private final double saldo;
    private final String fascia;
    private final boolean bonus;

    public TesserinoStudente(String codice, String nome, String cognome, boolean attivo, String matricola, LocalDate scadenza, double saldo, String fascia, boolean bonus) {
        super(codice, nome, cognome, attivo);
        this.matricola = matricola;
        this.scadenza = scadenza;
        this.saldo = saldo;

        if (fascia.equalsIgnoreCase("A") || fascia.equalsIgnoreCase("B")) {
            this.fascia = fascia;
        } else {
            throw new IllegalArgumentException("Fascia studente non valida. Scegli 'A' o 'B'");
        }
        this.bonus = bonus;
    }

    //CALCOLO PREZZO
    public double calcolaPrezzo(boolean bonus) {
        double prezzoPasto = 0d;

        if (!fascia.equalsIgnoreCase("A")) {
            prezzoPasto = 1.5d;
        } else {
            prezzoPasto += 2.5d;
        }
        if (bonus) {
            prezzoPasto -= 1d;
        }

        return prezzoPasto;
    }


    public boolean isBonus() {
        return this.bonus;
    }

    public String getFascia() {
        return fascia;
    }

    public LocalDate getScadenza() {
        return this.scadenza;
    }

    public double paga(double saldo, double prezzoPasto) throws TesserinoScadutoException {
        LocalDate oggi = LocalDate.now();

        if (getScadenza().equals(oggi)) {
            throw new TesserinoScadutoException(); //eccezione controllata
        } else {
            if (saldo > prezzoPasto) {
                saldo = (saldo - prezzoPasto);
            } else {
                throw new saldoInsufficienteException("Saldo insufficiente."); //Non controllato
            }

        }
        return prezzoPasto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void versa(double x, double saldo) {

        if (x < 0) {
            throw new RuntimeException();
        } else {
            saldo += x;
        }

    }

    public String getMatricola() {
        return this.matricola;
    }
}
