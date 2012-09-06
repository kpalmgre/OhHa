package ohjelmoinninharjoitustyö;

/**
 *
 * @author elinapalmgren
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ulkoasu extends JFrame {

    /**
     * Otsikko-olio tekstin lisäämistä varten.
     */
    private JLabel teksti;
    /**
     * Nappula-olio nappulan toteutusta varten.
     */
    private JButton nappula;
    /**
     * Otsikko-olio tyhjän tekstialueen lisäämistä varten.
     */
    private JLabel tyhja;
    /**
     * Lista-olio listojen luomista varten.
     */
    private JList lista;

    /**
     * Graafisen käyttöliittymän komponentti, joka sisältää otsikon ja tyhjää
     * tilaa.
     *
     * @param otsake - asetetaan haluttu otsikko.
     */
    public void tyhja(String otsake) {
        teksti = new JLabel(otsake);
        add(teksti);
        teksti = new JLabel("");
        add(teksti);
        teksti = new JLabel("");
        add(teksti);
        teksti = new JLabel("");
        add(teksti);
        teksti = new JLabel("");
        add(teksti);
    }

    /**
     * Graafisen käyttöliittymän komponentti, joka kutsuu laskutoimituksia ja
     * listaa kursseja.
     *
     * @param opinnot - valitaan tarkasteltavat opintokokonaisuudet tai
     * pakollisuus/ vapaaehtoisuus.
     */
    public void tekstit(String opinnot, ArrayList<Kurssi> kurssilista) {
        String[] kurssitaulukko = OhjelmoinninHarjoitustyö.lueTaulukkoonParametrilla(kurssilista, opinnot);
        lista = new JList(kurssitaulukko);
        JScrollPane sp1 = new JScrollPane(lista);
        add(sp1);
        teksti = new JLabel(Laskutoimitukset.laskeKurssit("suoritettu", opinnot, kurssilista) + "/" + (Laskutoimitukset.laskeKurssit("suoritettu", opinnot, kurssilista) + Laskutoimitukset.laskeKurssit("suorittamatta", opinnot, kurssilista)) + " suoritettu(a) kurssi(a).");
        add(teksti);
        teksti = new JLabel("Suoritettujen kurssien osuus " + Laskutoimitukset.laskeOsuus(opinnot, kurssilista) + "%");
        add(teksti);
        teksti = new JLabel("Suoritetut opintopisteet " + Laskutoimitukset.laskeOpintopisteet(opinnot, kurssilista));
        add(teksti);
        teksti = new JLabel("Keskiarvo " + Laskutoimitukset.laskeKeskiarvo(opinnot, kurssilista));
        add(teksti);
    }

    /**
     * Graafisen käyttöliittymän toteutus.
     */
    public Ulkoasu(ActionListener kuuntelija, String[] kurssitaulukko, ArrayList<Kurssi> kurssilista) {

        setLayout(new GridLayout(11, 5));
        setTitle("Opintojen seurantajärjestelmä");
        tyhja = new JLabel("");
        add(tyhja);
        tyhja = new JLabel("");
        add(tyhja);
        nappula = new JButton("Lisää kurssi");
        nappula.addActionListener(kuuntelija);
        add(nappula);
        tyhja = new JLabel("");
        add(tyhja);
        tyhja = new JLabel("");
        add(tyhja);
        /////////////////////////////////////////
        tyhja("Perusopinnot");
        /////////////////////////////////////////
        tekstit("perusopinnot", kurssilista);
        /////////////////////////////////////////
        tyhja("Aineopinnot");
        /////////////////////////////////////////
        tekstit("aineopinnot", kurssilista);
        /////////////////////////////////////////
        tyhja("Pakolliset opinnot");
        /////////////////////////////////////////
        tekstit("pakollinen", kurssilista);
        /////////////////////////////////////////
        tyhja("Valinnaiset opinnot");
        /////////////////////////////////////////
        tekstit("valinnainen", kurssilista);
        /////////////////////////////////////////
        tyhja("   Luonnontieteiden kandidaatin tutkinto");
        tyhja = new JLabel("     Suoritettujen opintopisteiden määrä");
        add(tyhja);
        tyhja = new JLabel("tutkinnon laajuudesta (180 op.)");
        add(tyhja);
        JProgressBar pb = new JProgressBar(0, 100);
        pb.setStringPainted(true);
        pb.setValue((int) ((Laskutoimitukset.laskeOpintopisteet("pakollinen", kurssilista) + Laskutoimitukset.laskeOpintopisteet("valinnainen", kurssilista)) / 1.8));
        add(pb);
        tyhja = new JLabel("");
        add(tyhja);
        tyhja = new JLabel("");
        add(tyhja);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
