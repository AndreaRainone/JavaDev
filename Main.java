package it.unisa.libreria;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Libro libro1 = new Libro(0,"Pinocchio", "Andrea Rainone", 200, List.of("1: Prefazione", "2: Introduzione"));
        Libro libro2 = new Libro(1,"Il piccolo principe", "Andrea Antonio Rainone", 230, List.of("1: Prefazione", "2: Introduzione", "3: Capitolo I"));
        Libro libro3 = new Libro(2,"La solitudine dei numeri primi", "Lupo Lucio", 100, List.of("1: Prefazione", "2: Introduzione", "3: Presentazione"));
        Libro libro4 = new Libro(3,"Decamerone", "Pasquale Sospetto", 300, List.of("1: Prefazione", "2: Introduzione"));


        Libreria libreria1 = new Libreria();
        libreria1.aggiungiLibro(libro1);
        libreria1.aggiungiLibro(libro2);
        libreria1.aggiungiLibro(libro3);
        libreria1.aggiungiLibro(libro4);

        try{
            Libro trovato = libreria1.ricercaLibro("Il piccolo principe");
            System.out.println(trovato);
        }catch (Exception e){
            System.out.println("Il libro con il titolo da te cercato non è presente.");
        }

       libreria1.elencoLibri();

    }
}
