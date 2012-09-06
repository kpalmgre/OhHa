
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import ohjelmoinninharjoitustyö.*;
import java.util.*;

/**
 *
 * @author elinapalmgren
 */
public class LaskutoimituksetTest {

    private static ArrayList<Kurssi> kurssilista;

    @BeforeClass
    public static void setUpClass() {
        kurssilista = new ArrayList<Kurssi>();
        String[] taulukko1 = {"testikurssi1", "5", "testit", "pakollinen", "0"};
        Kurssi kurssi1 = new Kurssi(taulukko1);
        kurssilista.add(kurssi1);
        String[] taulukko2 = {"testikurssi2", "5", "testit", "pakollinen", "5"};
        Kurssi kurssi2 = new Kurssi(taulukko2);
        kurssilista.add(kurssi2);
        String[] taulukko3 = {"testikurssi3", "5", "testit", "valinnainen", "5"};
        Kurssi kurssi3 = new Kurssi(taulukko3);
        kurssilista.add(kurssi3);
        String[] taulukko4 = {"testikurssi4", "5", "testit", "valinnainen", "0"};
        Kurssi kurssi4 = new Kurssi(taulukko4);
        kurssilista.add(kurssi4);
    }

    // Testaa kurssien määrän laskemisen.
    @Test
    public void laskeKurssitTest() {
        int lkm = Laskutoimitukset.laskeKurssit("suoritettu", "testit", kurssilista);

        assertTrue(lkm == 2);
    }

    // Testaa suoritettujen kurssien osuuden laskemisen.
    @Test
    public void laskeOsuusTest() {
        double osuus = Laskutoimitukset.laskeOsuus("pakollinen", kurssilista);

        assertTrue(osuus == 50);
    }

    // Testaa suoritettujen kurssien opintopisteiden laskemisen.
    @Test
    public void laskeOpintopisteetTest() {
        int op = Laskutoimitukset.laskeOpintopisteet("testit", kurssilista);

        assertTrue(op == 10);
    }

    // Testaa suoritettujen kurssien arvosanojen keskiarvon laskemisen.
    @Test
    public void laskeKeskiarvoTest() {
        int keskiarvo = Laskutoimitukset.laskeKeskiarvo("testit", kurssilista);

        assertTrue(keskiarvo == 5);
    }
}
