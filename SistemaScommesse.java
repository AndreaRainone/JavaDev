package it.unisa.gestionescommessa;

import java.util.ArrayList;
import java.util.List;

public class SistemaScommesse {

    List<Scommessa> listaScommesse;

    public SistemaScommesse(){
        listaScommesse = new ArrayList<>();
    }

    public void aggiungiScommessa(Scommessa s){
        listaScommesse.add(s);
    }

    public String daiTipoScommessa(int i){
        if(i < 0 || i >= listaScommesse.size()){
            throw  new IndexOutOfBoundsException("Indice non è valido.");
        }
        return listaScommesse.get(i).getTipo();
    }

    public Scommessa getMinimo(){
        if(listaScommesse.isEmpty()){
            return null;
        }
        Scommessa scommessaBase = listaScommesse.getFirst();
        float vincitaBase = scommessaBase.calcolaVincita();
        float vincita;

        for(Scommessa scommessa : listaScommesse){
            vincita = scommessa.calcolaVincita();
            if(vincita < vincitaBase){
                vincitaBase = vincita;
                scommessaBase = scommessa;
            }

        }
        return scommessaBase;
    }

    public Scommessa getMassimo(){
        if(listaScommesse.isEmpty()){
            return null;
        }
        Scommessa scommessaBase = listaScommesse.getFirst();
        float vincitaBase = scommessaBase.calcolaVincita();
        float vincita;

        for(Scommessa scommessa : listaScommesse){
            vincita = scommessa.calcolaVincita();
            if(vincita > vincitaBase){
                vincitaBase = vincita;
                scommessaBase = scommessa;
            }

        }
        return scommessaBase;
    }

    public double calcolaVincita(){
        double vincitaTotale = 0d;
        for(Scommessa scommessa : listaScommesse){
            vincitaTotale += scommessa.calcolaVincita();
        }
        return vincitaTotale;
    }

//    public ArrayList<Scommessa> cerca(String tipo){
//
//    }

}
