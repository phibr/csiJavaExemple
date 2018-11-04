package temps;

/**
 * ExceptionMauvaisJour représente une erreur de création
 * de date en raison d'un jour incorrect
 * 
 * @see Date
 */
public class ExceptionMauvaisJour extends Exception {
    /**
     * constructeur d'ExceptionMauvaisJour
     * 
     * @param msg le message d'erreur indiquant la cause du problème
     */
    public ExceptionMauvaisJour(String msg) {
        super(msg);
    }
}
