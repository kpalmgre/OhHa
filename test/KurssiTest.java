
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import ohjelmoinninharjoitustyö.*;

/**
 *
 * @author elinapalmgren
 */
public class KurssiTest {

    Kurssi kurssi;

    @Before
    public void setUp() {
        String[] taulukko = {"eka", "1", "toka", "pakollinen", "2"};
        kurssi = new Kurssi(taulukko);
    }

    // Testaa Kurssi-olion luomisen.
    @Test
    public void testaaKurssi() {
        assertTrue(kurssi.annaNimi().equals("eka") && kurssi.annaArvosana() == 2);
    }
    
    @Test
    public void asetettavaArvosanaLiianPieni() {
        kurssi.asetaArvosana(-1);
        
        assertTrue(kurssi.annaArvosana() == 2);
    }
    
    @Test
    public void asetettavaArvosanaLiianSuuri() {
        kurssi.asetaArvosana(6);
        
        assertTrue(kurssi.annaArvosana() == 2);
    }
}
