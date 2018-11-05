package essai;

import static org.junit.Assert.*;
import org.junit.Test;


import temps.*;

/**
 * TestDate est une classe de test de la classe Date
 *
 * @version 1
 */
public class TestDate {
    /**
     * teste les deux constructeurs de Date en conditions normales
     */
    @Test
    public void test01constructeur()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        Date d;
        d = new Date(5, 11, 2018);
        assertEquals("5/11/2018", d.toString());
        d = new Date("31/12/2018");
        assertEquals("31/12/2018", d.toString());
    }

    /**
     * teste le constructeur ayant 3 entiers en paramètres
     * avec une valeur incorrecte du mois
     * le test réussit en levant l'exception ExceptionMauvaisMois
     */
    @Test(expected = ExceptionMauvaisMois.class)
    public void test02constructeur()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        new Date(1, 13, 2018);
    }

    /**
     * teste le constructeur ayant 3 entiers en paramètres
     * avec une valeur incorrecte du mois
     * le test réussit en levant l'exception ExceptionMauvaisMois
     */
    @Test(expected = ExceptionMauvaisMois.class)
    public void test03constructeur()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        new Date(1, 0, 2018);
    }

    /**
     * teste le constructeur ayant 3 entiers en paramètres
     * avec une valeur incorrecte du jour
     * le test réussit en levant l'exception ExceptionMauvaisJour
     */
    @Test(expected = ExceptionMauvaisJour.class)
    public void test04constructeur()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        new Date(0, 1, 2018);
    }

    /**
     * teste le constructeur ayant 3 entiers en paramètres
     * avec une valeur incorrecte du jour
     * le test réussit en levant l'exception ExceptionMauvaisJour
     */
    @Test(expected = ExceptionMauvaisJour.class)
    public void test05constructeur()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        new Date(32, 1, 2018);
    }

    /**
     * teste le constructeur ayant 3 entiers en paramètres
     * avec une valeur incorrecte du jour
     * le test réussit en levant l'exception ExceptionMauvaisJour
     */
    @Test(expected = ExceptionMauvaisJour.class)
    public void test06constructeur()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        new Date(31, 4, 2018);
    }

    /**
     * teste le constructeur ayant 3 entiers en paramètres
     * avec une valeur incorrecte du jour
     * le test réussit en levant l'exception ExceptionMauvaisJour
     */
    @Test(expected = ExceptionMauvaisJour.class)
    public void test07constructeur()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        new Date(29, 2, 2018);
    }

    /**
     * teste passerAuLendemain et passerALaVeille
     * en conditions normales et aux limites
     * (fin de moi, fin d'année, début de mois, début d'année)
     */
    @Test
    public void test08passerAuLendemainEtALaVeille()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        Date d;
        d = new Date(10, 3, 2018);
        d.passerAuLendemain();
        assertEquals("11/03/2018", d.toString());
        d.passerALaVeille();
        assertEquals("10/03/2018", d.toString());
        d = new Date(31, 1, 2018);
        d.passerAuLendemain();
        assertEquals("1/02/2018", d.toString());
        d.passerALaVeille();
        assertEquals("31/01/2018", d.toString());
        d = new Date(31, 12, 2018);
        d.passerAuLendemain();
        assertEquals("1/01/2019", d.toString());
        d.passerALaVeille();
        assertEquals("31/12/2018", d.toString());
    }

    /**
     * teste bissextile
     */
    @Test
    public void test09bissextile() {
        assertTrue(Date.bissextile(2016));
        assertFalse(Date.bissextile(2018));
    }

    /**
     * teste nombreDeJoursDuMois
     */
    @Test
    public void test10nombreDeJoursDuMois() {
        assertEquals(31, Date.nombreDeJoursDuMois(1, 2018));
        assertEquals(28, Date.nombreDeJoursDuMois(2, 2018));
        assertEquals(29, Date.nombreDeJoursDuMois(2, 2020));
        assertEquals(31, Date.nombreDeJoursDuMois(3, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(4, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(5, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(6, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(7, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(8, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(9, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(10, 2018));
        assertEquals(30, Date.nombreDeJoursDuMois(11, 2018));
        assertEquals(31, Date.nombreDeJoursDuMois(12, 2018));
    }

    /**
     * teste compareTo
     */
    @Test
    public void test11compareTo()
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        Date d1, d2;
        d1 = new Date(15, 1, 2018);
        d2 = new Date(15, 1, 2019);
        assertTrue(d2.compareTo(d1) > 0);
        assertTrue(d2.compareTo(d2) == 0);
        assertTrue(d1.compareTo(d2) < 0);
        d2 = new Date(15, 2, 2018);
        assertTrue(d2.compareTo(d1) > 0);
        d2 = new Date(17, 1, 2018);
        assertTrue(d2.compareTo(d1) > 0);
    }
}
