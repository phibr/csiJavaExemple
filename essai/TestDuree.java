package essai;

import static org.junit.Assert.*;
import org.junit.Test;

import temps.*;

/**
 * TestDuree est une classe de test de la classe Duree
 *
 * @version 1
 */
public class TestDuree {
    /**
     * teste les deux constructeurs de Duree en conditions normales
     */
    @Test
    public void test1Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Duree d;
        d = new Duree(1, 30);
        assertEquals("01h30", d.toString());
        d = new Duree("48:00");
        assertEquals("48h00", d.toString());
    }
    
    /**
     * teste le constructeur de Duree ayant 2 entiers en paramètres
     * avec une valeur incorrecte de la minute
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourMinute
     */
    @Test(expected = ExceptionMauvaiseValeurPourMinute.class)
    public void test2Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Duree(0, 61);
    }

    /**
     * teste le constructeur de Duree ayant une chaîne de caractères en paramètres
     * avec une valeur incorrecte de la minute
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourMinute
     */
    @Test(expected = ExceptionMauvaiseValeurPourMinute.class)
    public void test3Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Duree("0:75");
    }

    /**
     * teste le constructeur de Duree ayant 2 entiers en paramètres
     * avec une valeur incorrecte de l'heure
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourHeure
     */
    @Test(expected = ExceptionMauvaiseValeurPourHeure.class)
    public void test4Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Duree(-1, 0);
    }

    /**
     * teste le constructeur de Duree ayant une chaîne de caractères en paramètres
     * avec une valeur incorrecte de l'heure
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourHeure
     */
    @Test(expected = ExceptionMauvaiseValeurPourHeure.class)
    public void test5Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Heure("-1:15");
    }

    /**
     * teste la méthode une minute de plus en conditions normales
     * et à la limite (59 minutes)
     */
    @Test
    public void test6uneMinuteDePlus()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Duree d;
        d = new Duree(72, 58);
        d.uneMinuteDePlus();
        assertEquals("72h59", d.toString());
        d.uneMinuteDePlus();
        assertEquals("73h00", d.toString());
    }
    
    /**
     * teste la méthode une heure de plus
     */
    @Test
    public void test7uneHeureDePlus()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Duree d = new Duree(23, 15);
        d.uneHeureDePlus();
        assertEquals("24h15", d.toString());
    }

    /**
     * teste la méthode une minute de moins en conditions normales
     * et aux limites (0 minute, 0 heure)
     */
    @Test
    public void test8uneMinuteDeMoins()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Duree d;
        d = new Duree(10, 0);
        d.uneMinuteDeMoins();
        assertEquals("09h59", d.toString());
        d.uneMinuteDeMoins();
        assertEquals("09h58", d.toString());
        d = new Duree(0, 0);
        d.uneMinuteDeMoins();
        assertEquals("00h00", d.toString());
    }

    /**
     * teste la méthode une heure de moins en conditions normales
     * et à la limite (0 heure)
     */
    @Test
    public void test9uneHeureDeMoins()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Duree d;
        d = new Duree(12, 0);
        d.uneHeureDeMoins();
        assertEquals("11h00", d.toString());
        d = new Duree(0, 30);
        d.uneHeureDeMoins();
        assertEquals("00h00", d.toString());
    }
}
