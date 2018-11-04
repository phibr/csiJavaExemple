package temps;

/**
 * ExceptionMauvaisAnnee représente une erreur de création
 * de date en raison d'une année incorrecte
 * 
 * @see Date
 */
public class ExceptionMauvaiseAnnee extends Exception {
    /**
     * constructeur d'ExceptionMauvaiseAnnee
     * 
     * @param a un entier indiquant la valeur de l'année cause du problème
     */
    public ExceptionMauvaiseAnnee(int a) {
        super("Annee incorrecte (" + a + ") pour une date "
            + "(il faut un entier positif");
    }
}
