import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import agenda.*;
import outils.*;

/**
 * GestAgenda représente l'application de gestion d'agenda
 */
abstract class GestAgenda {
    private static void ajouterEvenement(Agenda a) {
        String nom, txtDate, txtHeure, txtDuree;
        System.out.println("Désignation ?");
        nom = IN.getString();
        System.out.println("Date ?");
        txtDate = INTemps.getTexteDate();
        System.out.println("Heure ?");
        txtHeure = INTemps.getTexteHeure();
        System.out.println("Durée ?");
        txtDuree = INTemps.getTexteDuree();
        try {
            a.ajouter(new Evenement(nom, txtDate, txtHeure, txtDuree));
            a.trier();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    private static Evenement selectionnerEvenement(Agenda a) {
        int num, max = a.taille();
        System.out.println("numéro de l'événement ?");
        do {
            num = IN.getInt();
        } while(num < 1 || num > max);
        return a.evenement(num);
    }
    private static void afficherMenu(Agenda a, Evenement e) {
        System.out.print("a)jouter ");
        if (!a.estVide()) System.out.print("s)électionner ");
        if (e != null) {
            System.out.print("<)1j+tôt ");
            System.out.print(">)1j+tard ");
            System.out.print("-)1h+tôt ");
            System.out.print("+)1h+tard ");
            System.out.print("d)urée ");
            System.out.print("e)ffacer ");
        }
        System.out.print("q)uitter ? ");
    }
    private static void changerDuree(Evenement evt) {
        String txtDuree;
        System.out.println("Durée ?");
        txtDuree = INTemps.getTexteDuree();
        try {
            evt.changerDuree(txtDuree);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    /**
     * le programme principal
     * 
     * @param arg un tableau de chaînes de caractères non utilisé
     */
    public static void main(String arg[]) {
        char choix;
        Evenement courant = null;
        Agenda agenda = new Agenda();
        do {
            System.out.println();
            agenda.afficher(courant);
            afficherMenu(agenda, courant);
            choix = IN.getChar();
            switch(choix) {
                case 'a' : ajouterEvenement(agenda); break;
                case 's' : courant = selectionnerEvenement(agenda); break;
                case 'e' : agenda.supprimer(courant); courant = null; break;
                case '<' : courant.passerALaVeille(); agenda.trier(); break;
                case '>' : courant.passerAuLendemain(); agenda.trier(); break;
                case '-' : courant.avancerD1Heure(); agenda.trier(); break;
                case '+' : courant.repousserD1Heure(); agenda.trier(); break;
                case 'd' : changerDuree(courant); break;
            }
        } while (choix != 'q');
        enregistre(agenda);
    }
}
