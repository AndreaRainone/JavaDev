package it.unisa.hertz;

public class Main {

    public static void main(String[] args) throws PrestitoException {

        Hertz automezzo = new Hertz("BG084EV", "Golf 1999");
        try {
            automezzo.effettuaReso("BG084EV");
        } catch (PrestitoException e) {
            System.out.println("Il veicolo non risulta in prestito. Reso non disponibile.");
        }

    }
}
