package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Reponse {
    //mot secret à trouver
    private final String motSecret;
    //construction du résultat (ex: PXXNP)
    private final List<Lettre> resultat = new ArrayList<>();
    //position de la lettre à tester dans le mot testé
    private int position;

    public Reponse(String mot) {

        this.motSecret = mot;
    }

    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        position = 0;
        for (char c : essai.toCharArray()) {
            resultat.add(evaluationCaractere(c));
            position += 1;
        }
    }

    // si toutes les lettres sont bien placées
    public boolean lettresToutesPlacees() {
        return !resultat.contains(Lettre.NON_PLACEE) && !resultat.contains(Lettre.INCORRECTE);
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    // renvoie le statut du caractère, s'il est bien placé ou pas ou non présent
    private Lettre evaluationCaractere(char carCourant) {

        if (estPlace(carCourant)) {
            return Lettre.PLACEE;
        }
        else if (estPresent(carCourant)) {
            return Lettre.NON_PLACEE;
        }
        else {
            return Lettre.INCORRECTE;
        }
    }

    // le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        return motSecret.contains(String.valueOf(carCourant));
    }

    // le caractère est placé à la bonne place dans le mot secret
    private boolean estPlace(char carCourant) {
        return motSecret.charAt(position) == carCourant;
    }
}
