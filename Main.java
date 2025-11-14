package it.unisa.mensa;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws TesserinoScadutoException{

        // TEST ECCEZIONE CONTROLLATA
        TesserinoStudente tesserinoStudente1 = new TesserinoStudente(
                1001,
                "Andrea",
                "Rainone",
                true,
                23522,
                (LocalDate.of(2025, 11, 1)),
                12.5,
                FasciaCategorie.Fascia.A,
                true);
        try{
            tesserinoStudente1.paga();
        } catch (TesserinoScadutoException e) {
            System.out.println("Attenzione, tesserino scaduto");
        }

    }
}
