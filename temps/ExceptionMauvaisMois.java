package temps;

/**
 * ExceptionMauvaisMois représente une erreur de création
 * de date en raison d'un mois incorrect
 * 
 * @see Date
 */
public class ExceptionMauvaisMois extends Exception {
    /**
     * constructeur d'ExceptionMauvaisMois
     * 
     * @param m un entier indiquant la valeur du mois cause du problème
     */
    public ExceptionMauvaisMois(int m) {
        super("Mois incorrect (" + m + ") pour une date "
            + "(il faut un entier entre 1 et 12");
    }
}
