package agenda;

import java.util.LinkedList;
import java.util.Collections;

/**
 * Agenda représente un ensemble d'événements
 * 
 * @see Evenement
 */
public class Agenda {
    private LinkedList<Evenement> contenu;
    /**
     * trie les événements de l'agenda dans l'ordre chronologique
     */
    public void trier() {
        Collections.sort(contenu);
    }
    /**
     * constructeur d'agenda
     * 
     * crée un agenda vide
     */
    public Agenda() {
        contenu = new LinkedList<Evenement>();
    }
    /**
     * teste si l'agenda est vide
     * 
     * @return vrai quant l'agenda est vide, faux dans le cas contraire
     */
    public boolean estVide() {
        return contenu.isEmpty();
    }
    /**
     * renvoie la taille de l'agenda
     * 
     * @return un entier indiquant combien l'agenda contient d'événements
     */
    public int taille() {
        return contenu.size();
    }
    /**
     * ajoute un événement à l'agenda
     * 
     * @param e un événement à ajouter à l'agenda
     */
    public void ajouter(Evenement e) {
        contenu.add(e);
    }
    /**
     * affiche l'agenda à la console
     */
    public void afficher() {
        int num = 1;
        for(Evenement evt : contenu) {
            System.out.println(num + ") " + evt);
            num++;
        }
    }
}
