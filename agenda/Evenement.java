package agenda;

/*
import temps.Date;
import temps.Heure;
import temps.Duree;
*/
import temps.*;
import java.lang.Comparable;

/**
 * Evenenement représente un élément d'agenda
 * 
 * @see Agenda
 */
public class Evenement implements Comparable<Evenement> {
    private static Heure uneHeure = null;
    private static Heure vingtTroisHeures = null;
    private String designation;
    private Date date;
    private Heure heure;
    private Duree duree;
    /**
     * constructeur d'Evenement
     * 
     * @param designation une chaîne de caractéres désignant l'événement
     * @param jour un entier indiquant le jour de la date de l'événement
     * @param mois un entier indiquant le mois de la date de l'événement
     * @param annee un entier indiquant l'annee de la date de l'événement
     * @param heure un entier indiquant l'heure de l'instant où débute l'événement
     * @param minute un entier indiquant la minute de l'instant où débute l'événement
     * 
     * @exception ExceptionMauvaisJour exception indiquant si le jour est incorrect (par exemple <= 0 ou > 31)
     * @exception ExceptionMauvaisMois exception indiquant si le mois est incorrect (en dehors de [1 - 12])
     * @exception ExceptionMauvaiseAnnee exception indiquant si l'année est incorrecte
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     */
    public Evenement(String designation,
                     int jour, int mois, int annee,
                     int heure, int minute)
    throws ExceptionMauvaisJour,
           ExceptionMauvaisMois,
           ExceptionMauvaiseAnnee,
           ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        this.designation = designation;
        date = new Date(jour, mois, annee);
        this.heure = new Heure(heure, minute);
        duree = new Duree(1, 0);
        if (uneHeure == null) try { uneHeure = new Heure(1, 0); } catch (Exception e) { }
        if (vingtTroisHeures == null) try { vingtTroisHeures = new Heure(23, 0); } catch (Exception e) { }
    }
    /**
     * constructeur d'Evenement
     * 
     * @param nom une chaîne de caractéres désignant l'événement
     * @param txtDate une chaîne de caractères au format jj/mm/aaaa indiquant la date de l'événement
     * @param txtHeure une chaîne de caractères au format hh:mm indiquant l'heure de l'événement
     * @param txtDuree une chaîne de caractères au format hhh:mm indiquant la durée de l'événement
     * 
     * @exception ExceptionMauvaisJour exception indiquant si le jour est incorrect (par exemple <= 0 ou > 31)
     * @exception ExceptionMauvaisMois exception indiquant si le mois est incorrect (en dehors de [1 - 12])
     * @exception ExceptionMauvaiseAnnee exception indiquant si l'année est incorrecte
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     */
    public Evenement(String nom, String txtDate,
                     String txtHeure, String txtDuree)
    throws ExceptionMauvaisJour,
           ExceptionMauvaisMois,
           ExceptionMauvaiseAnnee,
           ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        designation = nom;
        date = new Date(txtDate);
        heure = new Heure(txtHeure);
        duree = new Duree(txtDuree);
        if (uneHeure == null) try { uneHeure = new Heure(1, 0); } catch (Exception e) { }
        if (vingtTroisHeures == null) try { vingtTroisHeures = new Heure(23, 0); } catch (Exception e) { }
    }
    /**
     * convertit l'événement en un texte
     * 
     * @return une chaîne de caractères notant l'événement
     */
    public String toString() {
        String s = "Le " + date;
        s += " a " + heure;
        s += " (" + duree + ")";
        s += " : " + designation;
        return s;
    }
    /**
     * compare l'événement considéré à un autre
     * 
     * @param autre une instance de Evenement
     * @return un entier nul si les événements sont simultanés,
     * négatif si l'événement considéré est antiérieur à autre,
     * positif si l'événement considéré est postérieur à autre
     */
    public int compareTo(Evenement autre) {
        int diffDates = date.compareTo(autre.date);
        if (diffDates == 0) {
            int diffHeures = heure.compareTo(autre.heure);
            if (diffHeures == 0)
                return duree.compareTo(autre.duree);
            else
                return diffHeures;
        } else
            return diffDates;
    }
    /**
     * positionne l'événement un jour plus tôt
     */
    public void passerALaVeille() {
        date.passerALaVeille();
    }
    /**
     * positionne l'événement un jour plus tard
     */
    public void passerAuLendemain() {
        date.passerAuLendemain();
    }
    /**
     * positionne l'événement une heure plus tard
     */
    public void repousserD1Heure() {
        heure.uneHeureDePlus();
        if (heure.compareTo(uneHeure) < 0) passerAuLendemain();
    }
    /**
     * positionne l'événement une heure plus tôt
     */
    public void avancerD1Heure() {
        heure.uneHeureDeMoins();
        if (heure.compareTo(vingtTroisHeures) >= 0) passerALaVeille();
    }
    /**
     * change la durée de l'événement
     * 
     * @param txtDuree une chaîne de caractères notant la nouvelle durée au format hhh:mm
     * @exception ExceptionMauvaiseValeurPourHeure une exception si la nouvelle durée a une valeur incorrecte de heure
     * @exception ExceptionMauvaiseValeurPourMinute une exception si la nouvelle durée a une valeur incorrecte de minute
     */
    public void changerDuree(String txtDuree)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        duree = new Duree(txtDuree);
    }
}
