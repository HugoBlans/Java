import Flore.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jardin {

    private int ligne;
    private int colonne;
    private Emplacement[][] emplacements;
    private HashMap<String, Integer> panier;

    public Emplacement[][] getEmplacement() {
        return emplacements;
    }

    public void setEmplacement(Emplacement[][] emplacement) {
        this.emplacements = emplacement;
    }

    public Jardin(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.panier = new HashMap<String, Integer>();
        initEmplacements();
    }

    private void initEmplacements() {
        this.emplacements = new Emplacement[this.ligne][this.colonne];
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.emplacements[i][j] = new Emplacement();
            }
        }
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public HashMap<String, Integer> getPanier() {
        return panier;
    }

    public void setPanier(HashMap<String, Integer> panier) {
        this.panier = panier;
    }

    public void ajouterPanier(String nomVegetal, int quantite) {
        // TODO vérifications suivantes :
        // - Si le végétale existe
        // - Si la quantité est correcte
        if (this.panier.containsKey(nomVegetal)) {
            panier.replace(nomVegetal, panier.get(nomVegetal) + quantite);
        } else {
            this.panier.put(nomVegetal, quantite);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Voici notre jardin :\n");
        for (Emplacement[] ligne : this.emplacements
        ) {
            for (Emplacement cell : ligne
            ) {
                sb.append(cell.toString());
            }
            sb.append("\n");
        }
        if (!panier.isEmpty()) {
            sb.append("Et notre panier contient :\n");
            for (Map.Entry<String, Integer> contenu : this.panier.entrySet()
            ) {
                sb.append(contenu.getKey() + " : " + contenu.getValue() + "graine(s)\n");
            }
        } else {
            sb.append("Et notre panier est vide.");
        }

        return sb.toString();
    }

    public void semer() {
        Scanner scanner = new Scanner(System.in);
        String[] Vege = {"Ail", "Tomate", "Betterave", "Carotte"};
        int resV = 0;
        int resX = 0;
        int resY = 0;
        do {
            System.out.println("Quel végétale souhaitez vous planter ?"
                    + "[1] Ail"
                    + "[2] Tomate"
                    + "[3] Betterave"
                    + "[4] Carotte");

            try {
                resV = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
            }
        } while (resV <= 0 || resV >= 5);

        boolean xValide = false;
        do {
            System.out.println("Sur quelle ligne planter la graine ?");
            try {
                resX = scanner.nextInt();
                if (resX >= 0 && resX < this.ligne) xValide = true;
            } catch (Exception e) {
                scanner.next();
            }
        } while (!xValide);

        boolean yValide = false;
        do {
            System.out.println("Sur quelle colonne planter la graine ?");
            try {
                resY = scanner.nextInt();
                if (resY >= 0 && resY < this.colonne) yValide = true;
            } catch (Exception e) {
                scanner.next();
            }
        } while (!yValide);

        if (this.panier.get(Vege[resV - 1]) > 0) {
            Vegetal graine = null;
            switch (resV) {
                case 1:
                    graine = new Ail();
                    break;
                case 2:
                    graine = new Tomate();
                    break;
                case 3:
                    graine = new Betterave();
                    break;
                case 4:
                    graine = new Carotte();
                    break;
                default:
            }
            this.panier.replace(Vege[resV - 1], this.panier.get(Vege[resV - 1]) - 1);
            this.emplacements[resX][resY].setVegetal(graine);
        } else {
            System.out.println("La quantité de graine est insuffisante");
        }
    }

    public void semer(Coordonnee cord, String vegetale) {

    switch (vegetale) {
            case "Ail" :
                this.emplacements[cord.getCoordX()][cord.getCoordY()].setVegetal(new Ail());
                break;
            case "Betterave" :
                this.emplacements[cord.getCoordX()][cord.getCoordY()].setVegetal(new Betterave());
                break;
            case "Carotte" :
                this.emplacements[cord.getCoordX()][cord.getCoordY()].setVegetal(new Carotte());
                break;
            case "Tomate" :
                this.emplacements[cord.getCoordX()][cord.getCoordY()].setVegetal(new Tomate());
                break;
        }
    }

    public void saisonSuivante() {
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                if (this.emplacements[i][j].getVegetal() != null) this.emplacements[i][j].getVegetal().grandir();
            }
        }
    }

    public void recolter() {
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                if (this.emplacements[i][j].getVegetal() != null) {
                    if (this.emplacements[i][j].getVegetal().getEtat() == Etat.FLEUR) {
                        if (this.emplacements[i][j].getVegetal() instanceof IRacePure) {
                            IRacePure vege = (IRacePure) this.emplacements[i][j].getVegetal();
                            vege.seReproduire(this.panier);
                        } else if (this.emplacements[i][j].getVegetal() instanceof IOgm) {
                            IOgm vege = (IOgm) this.emplacements[i][j].getVegetal();
                            Coordonnee coord = vege.seDupliquer(this.ligne,this.colonne);
                            semer(coord, this.emplacements[i][j].getVegetal().getClass().getSimpleName());
                        }
                        this.emplacements[i][j].setVegetal(null);
                    }


                }
            }
        }
    }
}
