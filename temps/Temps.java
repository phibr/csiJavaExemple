package temps;

import java.util.StringTokenizer;
import java.lang.Integer;
import java.lang.Comparable;

/**
 * Temps est la classe de base pour l'héritage de Heure et Durée
 */
abstract class Temps implements Comparable<Temps> {
    protected int heure;
    protected int minute;
    /**
     * initialise les variables d'instance heure et minute
     * 
     * @param h un entier qui détermine l'heure
     * @param m un entier qui détermine la minute
     * @param classe une chaîne de caractères précisant la classe de l'objet créé
     * @param borneSupHeure un booléen qui indique s'il y a une limite à 24h
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     * 
     * @see ExceptionMauvaiseValeurPourHeure
     * @see ExceptionMauvaiseValeurPourMinute
     */
    private void initialise(int h, int m, String classe, boolean borneSupHeure)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        if (m < 0 || m > 59)
            throw new ExceptionMauvaiseValeurPourMinute("Valeur incorrecte de minute (" + m + ") pour une instance de " + classe);
        boolean heureIncorrecte = (borneSupHeure) ? (h < 0 || h > 23) : (h < 0);
        if (heureIncorrecte)
            throw new ExceptionMauvaiseValeurPourHeure("Valeur incorrecte de heure (" + h + ") pour une instance de " + classe);
        heure = h;
        minute = m;
    }
    /**
     * initialise les variables d'instance heure et minute
     * 
     * @param h un entier qui détermine l'heure
     * @param m un entier qui détermine la minute
     * @param classe une chaîne de caractères précisant la classe de l'objet créé
     * @param borneSupHeure un booléen qui indique s'il y a une limite à 24h
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     * 
     * @see ExceptionMauvaiseValeurPourHeure
     * @see ExceptionMauvaiseValeurPourMinute
     */
    public Temps(int h, int m, String classe, boolean borneSupHeure)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        initialise(h, m, classe, borneSupHeure);
    }
    /**
     * initialise les variables d'instance heure et minute
     * 
     * @param texte une chaîne de caractères au format hh:mm
     * @param quoi une chaîne de caractères précisant la classe de l'objet créé
     * @param borneSupHeure un booléen qui indique s'il y a une limite à 24h
     * 
     * @exception ExceptionMauvaiseValeurPourHeure exception indiquant si l'heure est incorrecte (< 0)
     * @exception ExceptionMauvaiseValeurPourMinute exception indiquant si la minute est incorrecte (< 0 ou > 59)
     * 
     * @see ExceptionMauvaiseValeurPourHeure
     * @see ExceptionMauvaiseValeurPourMinute
     */
    public Temps(String texte, String quoi, boolean borneSupHeure)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        StringTokenizer st = new StringTokenizer(texte, ":");
        int h, m;
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initialise(h, m, quoi, borneSupHeure);
    }
    /**
     * augmente d'une minute le temps considéré
     */
    public void uneMinuteDePlus() {
        if (minute < 59) {
            minute++;
        } else {
            minute = 0;
            uneHeureDePlus();
        }
    }
    /**
     * augmente d'une heure le temps considéré
     */
    public abstract void uneHeureDePlus();
    /**
     * diminue d'une minute le temps considéré
     */
    public void uneMinuteDeMoins() {
        if (minute > 0) {
            minute--;
        } else {
            minute = 59;
            uneHeureDeMoins();
        }
    }
    /**
     * diminue d'une heure le temps considéré
     */
    public abstract void uneHeureDeMoins();
    /**
     * convertit le temps considéré en un texte notant ce temps
     */
    public String toString() {
        String s = "";
        if (heure < 10) s += "0";
        s += heure;
        s += "h";
        if (minute < 10) s += "0";
        s += minute;
        return s;
    }
    /**
     * compare le temps considéré à un autre
     * 
     * @param autreTemps un temps
     * @return un entier nul si les temps sont égaux,
     * négatif si le temps considéré est inférieur à autreTemps
     * positif si le temps considéré est supérieur à autreTemps
     */
    public int compareTo(Temps autreTemps) {
        if (heure == autreTemps.heure) {
            return minute - autreTemps.minute;
        } else
            return heure - autreTemps.heure;
    }
}
