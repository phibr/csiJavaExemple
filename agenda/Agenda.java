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
        afficher(null);
    }
    /**
     * affiche l'agenda à la console
     * 
     * @param particulier un événement à distinguer à l'affichage
     */
    public void afficher(Evenement particulier) {
        int num = 1;
        for(Evenement evt : contenu) {
            if (evt != particulier)
                System.out.println(" " + num + ") " + evt);
            else
                System.out.println("{" + num + ") " + evt + "}");
            num++;
        }
    }
    /**
     * renvoie un élément de l'agenda
     * 
     * @param index un entier indiquant l'événement considéré,
     * le permier élément étant numéro 1
     * @return l'événement de l'agenda ayant le numéro index
     */
    public Evenement evenement(int index) {
        return contenu.get(index - 1);
    }
    /**
     * supprimer un événement de l'agenda
     * 
     * @param e un événement
     */
    public void supprimer(Evenement e) {
        contenu.remove(e);
    }
}
