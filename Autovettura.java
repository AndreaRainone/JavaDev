package it.unisa.simulazione2;

public abstract class Autovettura implements Comparable<Autovettura> {

    protected final String nome;
    protected final int numCavalli;
    protected float tempoImpiegato;
    protected boolean on;


    public Autovettura(String nome, int numCavalli, float tempoImpiegato, boolean on) {
        this.nome = nome;
        this.numCavalli = numCavalli;
        this.tempoImpiegato = tempoImpiegato;
        this.on = on;
    }

    public String getNome() {
        return this.nome;
    }

    public void pitStop() {
        this.tempoImpiegato += 2;
    }

    protected void start() {
        this.on = true;
    }

    protected void stop() {
        this.on = false;
    }
/*
* getTempoGiro è implementato così perchè:
* - In caso di estensione del progetto non sono costretto ad aggiungere attributi di classe ulteriori nella superclasse
* - La seconda strada evitata era creare attributi di classe e usare il metodo getter da passare come "constCurve/Rett"
* - Espongo all'esterno solamente i tre valori richiesti, implementando nelle sottoclassi il metodo astratto getTempoGiro
*  con i soli parametri richiesti, più le due costanti che verranno utilizzato dal metodo principale (non astratto)
* - Non ho necessità di riscrivere lo stesso metodo nelle sottoclassi (poco incapsulamento/ereditarietà)
 */
    protected float getTempoGiro(int km, int numeroCurve, int numeroRettilinei, float constCurve, float constRett) throws AutoSpentaException {

        if (on) {
            return km * (numeroCurve * constCurve + numeroRettilinei * constRett) / this.numCavalli;
        } else {
            throw new AutoSpentaException();
        }


    }

    public abstract float getTempoGiro(int km, int numeroCurve, int numeroRettilinei);

/*
* Implementando la classe Comparable, ho riscritto il metodo "compareTo" passando come parametro un oggetto Autovettura.
* Ho poi sfruttato il metodo "compare" della classe Integer, per confrontare x,y
 */
    @Override
    public int compareTo(Autovettura autovettura) {
        return Integer.compare(numCavalli, autovettura.numCavalli);
    }
}
