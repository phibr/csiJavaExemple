package temps;

/**
 * Duree représente le temps écoulé entre deux instants
 */
public class Duree extends Temps {
    private static String quoi = "Duree";
    /**
     * constructeur par défaut
     */
    public Duree() {
        super();
    }
    /**
     * initialise les heures et les minutes de la durée
     * 
     * @param h un entier qui détermine l'heure
     * @param m un entier qui détermine la minute
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     * 
     * @see ExceptionMauvaiseValeurPourHeure
     * @see ExceptionMauvaiseValeurPourMinute
     */
    public Duree(int h, int m)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(h, m, quoi, false);
    }
    /**
     * initialise les heures et les minutes de la durée
     * 
     * @param texte une chaîne de caractères au format hhh:mm
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     * 
     * @see ExceptionMauvaiseValeurPourHeure
     * @see ExceptionMauvaiseValeurPourMinute
     */
    public Duree(String texte)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(texte, quoi, false);
    }
    /**
     * initialise les heures et les minutes de la durée
     * 
     * @param valeur un entier qui donne la durée en minutes
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     * 
     * @see ExceptionMauvaiseValeurPourHeure
     * @see ExceptionMauvaiseValeurPourMinute
     */
    public Duree(int valeur)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(valeur, quoi, false);
    }
    /**
     * augmente d'une heure la durée
     */
    public void uneHeureDePlus() {
        heure++;
    }
    /**
     * diminue d'une heure la durée
     */
    public void uneHeureDeMoins() {
        if (heure > 0) {
            heure--;
        } else {
            heure = 0;
            minute = 0;
        }
    }
}
