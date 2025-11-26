package it.unisa.zoo;

public class RoboPappagallo extends AnimaleRobotico {

    private final String coloreAli;

    public RoboPappagallo(String id, String specie, double energia, Stato stato, String coloreAli){
        super(id, specie, energia, stato);
        this.coloreAli = coloreAli;
    }

    @Override
    public void comportamento(){
        setEnergia(getEnergia() - 0.5);
        if(getEnergia() == 0){
            setStato(Stato.DORMIENTE);
        }
    }

    @Override
    public String toString() {
        return "RoboPappagallo{" +
                "coloreAli='" + coloreAli + '\'' +
                '}';
    }
}
