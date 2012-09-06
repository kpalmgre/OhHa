
import org.junit.Test;
import static org.junit.Assert.*;

import ohjelmoinninharjoitustyö.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author elinapalmgren
 */
public class ApumetoditTest {

    Scanner lukija;
    PrintWriter kirjoittaja;

    // Testaa tiedoston avaamisen kirjoitettavaksi ja luettavaksi.
    @Test
    public void tiedostonMuokkaaminenTest() {
        double luku = Math.random();
        kirjoittaja = Apumetodit.avaaKirjoitettavaksi("/Users/elinapalmgren/NetBeansProjects/OhjelmoinninHarjoitustyö/src/testi.txt");
        kirjoittaja.print(luku);
        kirjoittaja.close();
        lukija = Apumetodit.avaaLuettavaksi("/Users/elinapalmgren/NetBeansProjects/OhjelmoinninHarjoitustyö/src/testi.txt");
        String tuloste = lukija.nextLine();
        lukija.close();
        assertTrue(tuloste.equals(Double.toString(luku)));
    }

    // Testaa arvosanan lisäämisen Kurssi-oliolle, joka on kurssilistassa ja kurssilistan tallettamisen tiedostoon.
    @Test
    public void lisaaArvosanaJaLueTiedostoonTest() {
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
        String[] taulukko4 = {"testikurssi4", "5", "testit", "valinnainen", "0"};
        Kurssi kurssi4 = new Kurssi(taulukko4);
        kurssilista.add(kurssi4);

        Apumetodit.lisaaArvosana(kurssilista, "testikurssi1", 1, "testikurssit");

        lukija = Apumetodit.avaaLuettavaksi("/Users/elinapalmgren/NetBeansProjects/OhjelmoinninHarjoitustyö/src/testikurssit.txt");

        String ekarivi = lukija.nextLine();
        String[] taulu = ekarivi.split("\\|");
        Kurssi kurssi = new Kurssi(taulu);

        assertTrue(kurssi.annaArvosana() == 1);
    }

    // Testaa että negatiivisen arvosanan lisääminen Kurssi-oliolle epäonnistuu.
    @Test
    public void arvosananLisaaminenEpaonnistuuTest() {
        String[] taulukko = {"testikurssi", "5", "testit", "pakollinen", "5"};
        Kurssi kurssi = new Kurssi(taulukko);
        kurssi.asetaArvosana(-1);

        assertTrue(kurssi.annaArvosana() == 5);
    }

    
}
