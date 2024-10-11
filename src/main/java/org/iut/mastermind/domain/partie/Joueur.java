package org.iut.mastermind.domain.partie;

public class Joueur {

    private final String nom;

    // constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // getter nom joueur
    public String getNom() {
        return nom;
    }

    // equals
    @Override
    public boolean equals(Object o) {
       return nom.equals(((Joueur) o).nom) || this == o;
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
