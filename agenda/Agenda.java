package agenda;

import java.sql.*;

/**
 * Agenda représente un ensemble d'événements
 * 
 * @see Evenement
 */
public class Agenda {
    private Connection BD;
    /**
     * constructeur d'agenda
     */
    public Agenda()
    throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        BD = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
    }
    /**
     * teste si l'agenda est vide
     * 
     * @return vrai quant l'agenda est vide, faux dans le cas contraire
     */
    public boolean estVide() {
        return taille() == 0;
    }
    /**
     * renvoie la taille de l'agenda
     * 
     * @return un entier indiquant combien l'agenda contient d'événements
     */
    public int taille() {
        // return select count(*) from evenement
    }
    /**
     * ajoute un événement à l'agenda
     * 
     * @param e un événement à ajouter à l'agenda
     */
    public void ajouter(Evenement e) {
        // insert into evenement
    }
    /**
     * affiche l'agenda à la console
     */
    public void afficher() {
        Statement s = BD.createStatement();
        ResultSet rs;
        rs = s.executeQuery("select * from evenement");
        while (rs.next()) {
            int n = rs.getInt("numero");
            String txtDate = rs.getString("datevt");
            int heure = rs.getInt("heure");
            int duree = rs.getInt("duree");
            String des = rs.getString("designation");
            System.out.println(n + "   " + txtDate);
        }
        rs.close();
        // select * from evenement
    }
    /**
     * affiche l'agenda à la console
     * 
     * @param particulier un événement à distinguer à l'affichage
     */
    public void afficher(Evenement particulier) {
        // select * from evenement
    }
    /**
     * renvoie un élément de l'agenda
     * 
     * @param cle un entier indiquant l'événement considéré
     * @return l'événement de l'agenda ayant la clé cle
     */
    public Evenement evenement(int cle) {
        // select * from evenement where cle = ?
    }
    /**
     * supprime un événement de l'agenda
     * 
     * @param e un événement
     */
    public void supprimer(int cle) {
        // delete from evenement where cle = ?
    }
}
