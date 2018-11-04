package temps;

/**
 * ExceptionMauvaiseValeurPourHeure représente une erreur de création
 * de temps en raison d'une valeur incorrecte de heure
 * 
 * @see Temps
 */
public class ExceptionMauvaiseValeurPourHeure extends Exception {
    /**
     * constructeur d'ExceptionMauvaiseValeurPourHeure
     * 
     * @param msg le message d'erreur indiquant la cause du problème
     */
    public ExceptionMauvaiseValeurPourHeure(String msg) {
        super(msg);
    }
}
