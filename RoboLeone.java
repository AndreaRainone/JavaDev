package it.unisa.zoo;

public class RoboLeone extends AnimaleRobotico implements Addestrabile {

    private final int potenzaRuggito;


    public RoboLeone(String id, String specie, double energia, Stato stato, int potenzaRuggito) {
        super(id, specie, energia, stato);
        this.potenzaRuggito = potenzaRuggito;
    }


    public int getPotenzaRuggito() {
        return this.potenzaRuggito;
    }

    @Override
    public void comportamento(){
        setEnergia(getEnergia() * 0.9);
    }


    @Override
    public void addestra() {
        if(getEnergia() > 0 ){
            setEnergia(getEnergia() - 1);
        }
        setLivelloAddestramento(getLivelloAddestramento() + 1);

            if(getLivelloAddestramento() > 2){
                tricks.add("Ruggito");
            }else if(getLivelloAddestramento() > 4) {
                tricks.add("Balzo");
            }else if(getLivelloAddestramento() > 6){
                tricks.add("Andatura Elegante");
            }
    }

    @Override
    public boolean puoEseguire(String trick) {
        return tricks.contains(trick);
    }

    @Override
    public String toString() {
        return "RoboLeone{" +
                "potenzaRuggito=" + potenzaRuggito +
                '}';
    }
}
