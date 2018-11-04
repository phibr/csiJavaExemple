package temps;

/**
 * ExceptionMauvaiseValeurPourMinute représente une erreur de création
 * de temps en raison d'une valeur incorrecte de minute
 * 
 * @see Temps
 */
public class ExceptionMauvaiseValeurPourMinute extends Exception {
    /**
     * constructeur d'ExceptionMauvaiseValeurPourMinute
     * 
     * @param msg le message d'erreur indiquant la cause du problème
     */
    public ExceptionMauvaiseValeurPourMinute(String msg) {
        super(msg);
    }
}
