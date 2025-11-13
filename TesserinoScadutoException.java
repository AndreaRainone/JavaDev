package it.unisa.mensa;

public class TesserinoScadutoException extends Exception{

    public TesserinoScadutoException(){
        super("Il tesserino è scaduto.");
    }

    public TesserinoScadutoException(String s){
        super(s);
    }

}
