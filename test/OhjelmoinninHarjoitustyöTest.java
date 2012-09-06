
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

import ohjelmoinninharjoitustyö.*;

/**
 *
 * @author elinapalmgren
 */
public class OhjelmoinninHarjoitustyöTest {

    // Testaa kaikkien kurssien listaan lukemisen.
    @Test
    public void lueListaanTest() {

        assertTrue(OhjelmoinninHarjoitustyö.lueListaan().size() == 29);
    }

    // Testaa kaikkien kurssien taulukkoon lukemisen.
    @Test
    public void lueTaulukkoonTest() {

        assertTrue(OhjelmoinninHarjoitustyö.lueTaulukkoon().length == 29);
    }
    // Testaa parametrin avulla taulukkoon lukemisen.
    @Test
    public void lueTaulukkoonParametrillaTest() {
        ArrayList<Kurssi> kurssilista = new ArrayList<Kurssi>();
        String[] taulukko1 = {"testikurssi1", "5", "testit", "pakollinen", "0"};
        Kurssi kurssi1 = new Kurssi(taulukko1);
        kurssilista.add(kurssi1);
        String[] taulukko2 = {"testikurssi2", "5", "testit", "pakollinen", "5"};
        Kurssi kurssi2 = new Kurssi(taulukko2);
        kurssilista.add(kurssi2);
        String[] taulukko3 = {"testikurssi3", "5", "testit", "valinnainen", "5"};
        Kurssi kurssi3 = new Kurssi(taulukko3);
        kurssilista.add(kurssi3);

        assertTrue(OhjelmoinninHarjoitustyö.lueTaulukkoonParametrilla(kurssilista, "pakollinen").length == 2);
    }
}
