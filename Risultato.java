package it.unisa.gestionescommessa;

public enum Risultato {
    VITTORIA("1"),
    PAREGGIO("X"),
    SCONFITTA("2");

    private final String simbolo;

    Risultato(String simbolo){
        this.simbolo = simbolo;
    }

    public String getSimbolo(){
        return simbolo;
    }

    public static Risultato fromSingolo(String simbolo){
        for(Risultato risultato : values()){
            if (risultato.simbolo.equalsIgnoreCase(simbolo)){
                return risultato;
            }
        }
        throw new IllegalArgumentException("Simbolo non valido: " + simbolo);
    }
}
