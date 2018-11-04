package temps;

/**
 * Heure représente un instant de la journée
 */
public class Heure extends Temps {
    private static String quoi = "Heure";
    /**
     * initialise l'heure et la minute de l'instant de la journée représenté par cet objet Heure
     * 
     * @param h un entier qui détermine l'heure
     * @param m un entier qui détermine la minute
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0 ou > 23)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59])
     */
    public Heure(int h, int m)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(h, m, quoi, true);
    }
    /**
     * initialise l'heure et la minute de l'instant de la journée représenté par cet objet Heure
     * 
     * @param texte une chaîne de caractères au format hh:mm
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0 ou > 23)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59])
     */
    public Heure(String texte)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(texte, quoi, true);
    }
    /**
     * retarde d'une heure l'instant de la journée
     */
    public void uneHeureDePlus() {
        if (heure < 23) {
            heure++;
        } else {
            heure = 0;
        }
    }
    /**
     * avance d'une heure l'instant de la journée
     */
    public void uneHeureDeMoins() {
        if (heure > 0) {
            heure--;
        } else {
            heure = 23;
        }
    }
}
