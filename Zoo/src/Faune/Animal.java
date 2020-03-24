package Faune;

public abstract class Animal {

    private String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Je suis " + this.nom + ", je fais " + getSon();
    }

    public abstract String getSon();
}
