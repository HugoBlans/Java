package Exercice1;

import java.util.ArrayList;

public class FicheImpot {
    private Foyer foyerImposition;
    private ArrayList<TrancheImpot> tranches;

    public FicheImpot(Foyer foyerImposition, ArrayList<TrancheImpot> tranches) {
        this.foyerImposition = foyerImposition;
        this.tranches = tranches;
    }

    public Double getParts() {
        Double nbParts = 1.0;
        if (foyerImposition.isCouple()) nbParts += 1.0;
        if (foyerImposition.getNbEnfant() <= 2) {
            nbParts += foyerImposition.getNbEnfant() * 0.5;
        } else {
            nbParts += (2*0.5) + ((foyerImposition.getNbEnfant() - 2));
        }
        return nbParts;
    }
    public Double getRevenuParPart() {
        return (foyerImposition.getRevenuAnnuel() / this.getParts());
    }
    public Double getImpotRevenu() {
        Double revenuParPart = getRevenuParPart();
        Double impotApayer = 0.0;
        for (TrancheImpot ti : this.tranches
        ) {
            if (revenuParPart > ti.getBorneInf()) {
                if (revenuParPart < ti.getBorneSup() || ti.getBorneSup() <= 0) {
                    impotApayer += (revenuParPart - ti.getBorneInf()) * ti.getTaux();
                } else {
                    impotApayer += (ti.getBorneSup() - ti.getBorneInf()) * ti.getTaux();
                }
            } else {
                break;
            }
        }
        return (double) Math.round(impotApayer*getParts() * 100)/100;
    }

    @Override
    public String toString() {
        String s = "\nLe nombre de part est de " + getParts() + ".\nL'impôt sur le revenu est d'un montant de : " + getImpotRevenu() + "€";
        return this.foyerImposition.toString() + s;
    }
}
