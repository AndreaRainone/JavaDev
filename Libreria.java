package it.unisa.libreria;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Libreria {

    List<Libro> listaLibri;

    public Libreria() {
        listaLibri = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {

        listaLibri.add(libro);
    }

    public Libro ricercaLibro(String titolo) throws Exception {
        if (!listaLibri.isEmpty()) {
            for (Libro libro : listaLibri) {
                if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                    return libro;
                }
            }
            throw new Exception();
        }
        return null;
    }

    public String elencoLibri(){
        if(!listaLibri.isEmpty()){
            for(Libro libro : listaLibri) {
                return libro.toString();
            }
        }
        return null;
    }
    
}
