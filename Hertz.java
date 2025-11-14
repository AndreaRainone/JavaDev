package it.unisa.hertz;

import java.util.ArrayList;
import java.util.List;

public class Hertz {

    List<Automezzo> automezzi;
    private final String targa;
    private final String modello;

    public Hertz(String targa, String modello) {
        automezzi = new ArrayList<>();
        this.targa = targa;
        this.modello = modello;
    }


    public Automezzo dammiAutomezzoPerTarga(String targa) {

        if (!automezzi.isEmpty()) {
            for (Automezzo automezzo : automezzi) {
                if (automezzo.getTarga().equalsIgnoreCase(targa)) {
                    return automezzo;
                }
            }
        }
        return null;
    }

    public Automezzo dammiAutomezzoPerModello(String modello) {

        if (!automezzi.isEmpty()) {
            for (Automezzo automezzo : automezzi) {
                if (automezzo.getModello().equalsIgnoreCase(modello)) {
                    return automezzo;
                }
            }
        }
        return null;
    }

    public Automezzo dammiAutomezzoInPrestito() {

        if (!automezzi.isEmpty()) {
            for (Automezzo automezzo : automezzi) {
                if (automezzo.isDisponibile()) {
                    return automezzo;
                }
            }
        }
        return null;
    }

    /*
     * Ricerco per targa:
     * SI -> effettuaPrestito(targa)
     * NO -> TargaException
     */
    public void effettuaPrestito(String targa) {

        if (!automezzi.isEmpty()) {
            for (Automezzo automezzo : automezzi) {
                if (automezzo.getTarga().equalsIgnoreCase(targa)) {
                    automezzo.prestito();
                } else {
                    throw new TargaException("Impossibile effettuare il prestito. Veicolo non presente.");
                }
            }
        }

    }

    public void effettuaReso(String targa) throws PrestitoException {

        if (!automezzi.isEmpty()) {
            for (Automezzo automezzo : automezzi) {
                if (automezzo.isDisponibile()) { //se disponibile = true = non è stato prestato
                    throw new PrestitoException(); //eccezione controllata
                } else {
                    if (automezzo.getTarga().equalsIgnoreCase(targa)) {
                        automezzo.reso();
                    } else {
                        throw new TargaException("Impossibile effettuare il reso. Veicolo non presente.");
                    }
                }

            }
        }
    }


}
