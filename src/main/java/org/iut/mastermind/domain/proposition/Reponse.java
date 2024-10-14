package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Reponse {
    //mot secret à trouver
    private final String motSecret;
    //construction du résultat (ex: PXXNP)
    private final List<Lettre> resultat = new ArrayList<>();

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre du mot proposé
    public void compare(String essai) {
        for (char character : essai.toCharArray()) {
            resultat.add(evaluationCaractere(character, essai.indexOf(Character.toString(character))));
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
    private Lettre evaluationCaractere(char carCourant, int position) {
        // le caractère est présent dans le mot secret
        if (motSecret.contains(String.valueOf(carCourant))) {
            // le caractère est placé à la bonne place dans le mot secret
            if (motSecret.charAt(position) == carCourant)  {
                return Lettre.PLACEE;
            }
            return Lettre.NON_PLACEE;
        }
        return Lettre.INCORRECTE;
    }
}
