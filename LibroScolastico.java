package it.unisa.libreria;

public class LibroScolastico extends Libro{

    private final String ordine;
    private final String gradoScolastico;
    private final String materia;
    private final String titoloCd;

    public LibroScolastico(String ordine, String gradoScolastico, String materia, String titoloCd) {
        this.ordine = ordine;
        this.gradoScolastico = gradoScolastico;
        this.materia = materia;
        this.titoloCd = titoloCd;
    }

    public String getOrdine() {
        return this.ordine;
    }

    public String getGradoScolastico() {
        return this.gradoScolastico;
    }

    public String getMateria() {
        return this.materia;
    }

    public String getTitoloCd() {
        return this.titoloCd;
    }
}
