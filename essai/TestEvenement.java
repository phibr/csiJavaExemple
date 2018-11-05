package essai;

import static org.junit.Assert.*;
import org.junit.Test;

import agenda.Evenement;
import temps.*;

/**
 * TestEvenement est une classe de test pour la classe Evenement
 * 
 * @version 1
 */
public class TestEvenement {
    /**
     * teste les constructeurs
     */
    @Test
    public void test01constructeur() throws Exception {
        Evenement e;
        e = new Evenement("Essai", 2, 3, 2018, 12, 15);
        assertEquals("Le 2/03/2018 a 12h15 (01h00) : Essai", e.toString());
        e = new Evenement("Essai", "2/3/2018", "12:15", "1:30");
        assertEquals("Le 2/03/2018 a 12h15 (01h30) : Essai", e.toString());
    }
    /**
     * teste avancerD1Heure et repousserD1Heure
     * en conditions normales et aux limites
     */
    @Test
    public void test02avancerD1HeureEtRepousserD1Heure() throws Exception  {
        Evenement e;
        e = new Evenement("Essai", 2, 3, 2018, 12, 15);
        e.avancerD1Heure();
        assertEquals("Le 2/03/2018 a 11h15 (01h00) : Essai", e.toString());
        e.repousserD1Heure();
        assertEquals("Le 2/03/2018 a 12h15 (01h00) : Essai", e.toString());
        e = new Evenement("Essai", 2, 3, 2018, 0, 15);
        e.avancerD1Heure();
        assertEquals("Le 1/03/2018 a 23h15 (01h00) : Essai", e.toString());
        e.repousserD1Heure();
        assertEquals("Le 2/03/2018 a 00h15 (01h00) : Essai", e.toString());
    }
    /**
     * teste compareTo
     */
    @Test
    public void test03compareTo() throws Exception {
        Evenement e1, e2;
        e1 = new Evenement("01", "2/3/2018", "12:00", "1:30");
        assertTrue(e1.compareTo(e1) == 0);
        e2 = new Evenement("02", "2/3/2019", "12:00", "1:30");
        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
        e2 = new Evenement("02", "2/4/2018", "12:00", "1:30");
        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
        e2 = new Evenement("02", "3/3/2018", "12:00", "1:30");
        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
        e2 = new Evenement("02", "2/3/2018", "13:00", "1:30");
        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
        e2 = new Evenement("02", "2/3/2018", "12:30", "1:30");
        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
        e2 = new Evenement("02", "2/3/2018", "12:00", "1:45");
        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
    }
}
