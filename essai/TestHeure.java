package essai;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import temps.*;

/**
 * TestHeure est une classe de test de la classe Heure
 *
 * @version 2
 */
public class TestHeure {
    protected static Heure h1;
    protected static Heure h2;

    @BeforeClass
    public static void setUp()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        h1 = new Heure(14,57);
        h2 = new Heure("23:56");
    }

    /**
     * teste les deux constructeurs de Heure en conditions normales
     */
    @Test
    public void test1Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Heure h;
        h = new Heure(14, 57);
        assertEquals("14h57", h.toString());
        h = new Heure("23:56");
        assertEquals("23h56", h.toString());
    }

    /**
     * teste le constructeur de Heure ayant 2 entiers en paramètres
     * avec une valeur incorrecte de la minute
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourMinute
     */
    @Test(expected = ExceptionMauvaiseValeurPourMinute.class)
    public void test2Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Heure(12, 61);
    }

    /**
     * teste le constructeur de Heure ayant une chaîne de caractères en paramètres
     * avec une valeur incorrecte de la minute
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourMinute
     */
    @Test(expected = ExceptionMauvaiseValeurPourMinute.class)
    public void test3Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Heure("12:61");
    }

    /**
     * teste le constructeur de Heure ayant 2 entiers en paramètres
     * avec une valeur incorrecte de l'heure
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourHeure
     */
    @Test(expected = ExceptionMauvaiseValeurPourHeure.class)
    public void test4Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Heure(25, 15);
    }

    /**
     * teste le constructeur de Heure ayant une chaîne de caractères en paramètres
     * avec une valeur incorrecte de l'heure
     * le test réussit en levant l'exeption ExceptionMauvaiseValeurPourHeure
     */
    @Test(expected = ExceptionMauvaiseValeurPourHeure.class)
    public void test5Constructeur()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        new Heure("25:15");
    }

    /**
     * teste la méthode une minute de plus en conditions normales
     * et aux limites (59 minutes, 23 heures)
     */
    @Test
    public void test6uneMinuteDePlus() {
        h1.uneMinuteDePlus();
        assertEquals("14h58", h1.toString());
        h1.uneMinuteDePlus();
        assertEquals("14h59", h1.toString());
        h1.uneMinuteDePlus();
        assertEquals("15h00", h1.toString());
        h1.uneMinuteDePlus();
        assertEquals("15h01", h1.toString());
        h2.uneMinuteDePlus();
        assertEquals("23h57", h2.toString());
        h2.uneMinuteDePlus();
        assertEquals("23h58", h2.toString());
        h2.uneMinuteDePlus();
        assertEquals("23h59", h2.toString());
        h2.uneMinuteDePlus();
        assertEquals("00h00", h2.toString());
    }
    
    /**
     * teste la méthode une heure de plus en conditions normales
     * et à la limite (23 heures)
     */
    @Test
    public void test7uneHeureDePlus()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Heure h = new Heure(22, 05);
        h.uneHeureDePlus();
        assertEquals("23h05", h.toString());
        h.uneHeureDePlus();
        assertEquals("00h05", h.toString());
    }

    /**
     * teste la méthode une minute de moins en conditions normales
     * et aux limites (0 minute, 0 heure)
     */
    @Test
    public void test8uneMinuteDeMoins()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Heure h;
        h = new Heure(16, 20);
        h.uneMinuteDeMoins();
        assertEquals("16h19", h.toString());
        h = new Heure(12, 0);
        h.uneMinuteDeMoins();
        assertEquals("11h59", h.toString());
        h = new Heure(0, 0);
        h.uneMinuteDeMoins();
        assertEquals("23h59", h.toString());
    }

    /**
     * teste la méthode une heure de moins en conditions normales
     * et à la limite (0 heure)
     */
    @Test
    public void test9uneHeureDeMoins()
    throws ExceptionMauvaiseValeurPourHeure, ExceptionMauvaiseValeurPourMinute {
        Heure h;
        h = new Heure(16, 20);
        h.uneHeureDeMoins();
        assertEquals("15h20", h.toString());
        h = new Heure(0, 20);
        h.uneHeureDeMoins();
        assertEquals("23h20", h.toString());
    }
}
