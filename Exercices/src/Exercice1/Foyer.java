package Exercice1;

public class Foyer {
    private boolean couple;
    private int nbEnfant;
    private Double revenuAnnuel;

    public Foyer(boolean couple, int nbEnfant, Double revenuAnnuel) {
        this.couple = couple;
        this.nbEnfant = nbEnfant;
        this.revenuAnnuel = revenuAnnuel;
    }

    public Foyer() {
        this.couple = false;
        this.nbEnfant = 0;
        this.revenuAnnuel = 0.0;
    }

    public boolean isCouple() {
        return couple;
    }

    public void setCouple(boolean couple) {
        this.couple = couple;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) throws Exception {
        if (nbEnfant >= 0) {
            this.nbEnfant = nbEnfant;
        } else {
            throw new Exception(nbEnfant + " n'est pas un nombre d'enfant valide");
        }

    }

    public Double getRevenuAnnuel() {
        return revenuAnnuel;
    }

    public void setRevenuAnnuel(Double revenuAnnuel) {
        this.revenuAnnuel = revenuAnnuel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pour un foyer avec " + revenuAnnuel + "€ composé de :\n");
        if (couple) {
            sb.append("- un couple marié\n");
        } else {
            sb.append("- une personne célibataire\n");
        }
        if (nbEnfant > 0) {
            sb.append("- " + nbEnfant + " enfant(s) à charge");
        } else {
            sb.append("- 0 enfant à charge");
        }
        return sb.toString();
    }


}
