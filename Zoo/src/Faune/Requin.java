package Faune;

public class Requin extends Poisson {
    private int nbHumainsDevores;


    public Requin(String nom, int nbVertebres, int nbNageoires, int nbHumainsDevores) {
        super(nom, nbVertebres, nbNageoires);
        this.nbHumainsDevores = nbHumainsDevores;
    }

    @Override
    public String toString() {
        return super.toString() + ", j'ai mangé " + nbHumainsDevores + " personnes";
    }

    @Override
    public String getSon() {
        return "Cheh !";
    }
}
