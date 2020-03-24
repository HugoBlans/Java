package Exercice1;

public class TrancheImpot {
    private int borneInf;
    private int borneSup;
    private Double taux;

    public TrancheImpot(int borneInf, int borneSup, Double taux) {
        this.borneInf = borneInf;
        this.borneSup = borneSup;
        this.taux = taux;
    }

    public int getBorneInf() {
        return borneInf;
    }

    public void setBorneInf(int borneInf) {
        this.borneInf = borneInf;
    }

    public int getBorneSup() {
        return borneSup;
    }

    public void setBorneSup(int borneSup) {
        this.borneSup = borneSup;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
