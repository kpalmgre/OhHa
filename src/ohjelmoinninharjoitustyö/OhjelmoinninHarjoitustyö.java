package ohjelmoinninharjoitustyö;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * 
 * @author elinapalmgren
 */
public class OhjelmoinninHarjoitustyö implements ActionListener {

    /**
     * Ulkoasu-olio, joka on implementoinut JFramen ja pystyy näin toteuttamaan
     * dialogi- yms operaatiot.
     */
    static Ulkoasu ikkuna;
    /**
     * String-taulukko joka sisältää Kurssi-oloiden (so kurssien) nimet ja
     * mahdolliset arvosanat.
     */
    static String[] kurssitaulukko;
    /**
     * ArrayList-lista joka sisältää Kurssi-oliot.
     */
    static ArrayList<Kurssi> kurssilista;
    /**
     * Tapahtumankuuntelija graafisen käyttöliittymän nappulan toteutusta
     * varten.
     */
    static ActionListener kuuntelija;

    /**
     * Luo kuuntelijan graafisen käyttöliittymän nappulaa varten.
     *
     * @param tapahtuma
     */
    public void actionPerformed(ActionEvent tapahtuma) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object eka = null;
        Object kurssi = JOptionPane.showInputDialog(ikkuna, "Valitse lisättävä kurssi/ kurssi, jonka arvosanan haluat muuttaa", "Kurssilistojen muokkaaminen", JOptionPane.QUESTION_MESSAGE, null, kurssitaulukko, eka);
        if (kurssi != null) {
            String vastaus = JOptionPane.showInputDialog(ikkuna, "Arvosana kurssista " + kurssi.toString());
            if (vastaus != null) {
                int arvosana = Integer.parseInt(vastaus);
                Apumetodit.lisaaArvosana(kurssilista, kurssi.toString(), arvosana, "kurssit");
                ikkuna.dispose();
                ikkuna = new Ulkoasu(kuuntelija, kurssitaulukko, kurssilista);

            } else {

                JOptionPane.showMessageDialog(ikkuna, "Kurssilistaa ei muokattu.");
            }
        } else {
            JOptionPane.showMessageDialog(ikkuna, "Kurssilistaa ei muokattu.");
        }
    }

    /**
     * Lukee kurssit-tekstitiedoston kaikki rivit Kurssi-olioiksi
     * ArrayList-listaan.
     *
     * @return lista, joka sisältää kaikki tekstitiedoston määrittelemät
     * Kurssi-oliot.
     */
    public static ArrayList<Kurssi> lueListaan() {
        Scanner syottotiedosto = Apumetodit.avaaLuettavaksi("/Users/elinapalmgren/NetBeansProjects/OhjelmoinninHarjoitustyö/src/kurssit.txt");
        String[] temp = new String[5];
        ArrayList<Kurssi> lista = new ArrayList<Kurssi>();
        while (syottotiedosto.hasNextLine()) {
            temp = syottotiedosto.nextLine().split("\\|");
            Kurssi kurssi = new Kurssi(temp);
            lista.add(kurssi);
        }

        syottotiedosto.close();
        return lista;
    }

    /**
     * Lukee kurssit-tekstitiedoston kaikkien kurssien nimet ja mahdolliset
     * arvosanat String-taulukkoon.
     *
     * @return String-taulukko, jossa kaikkien kurssien nimet ja mahdolliset
     * arvosanat.
     */
    public static String[] lueTaulukkoon() {
        kurssilista = lueListaan();
        String[] taulukko = new String[kurssilista.size()];
        int i = 0;
        while (i < kurssilista.size()) {
            if (kurssilista.get(i).annaArvosana() == 0) {
                taulukko[i] = kurssilista.get(i).annaNimi();
            } else {
                taulukko[i] = kurssilista.get(i).annaNimi() + "         " + kurssilista.get(i).annaArvosana();
            }
            i = i + 1;
        }
        return taulukko;
    }
    
     /**
     * Luetaan ArrayList-kurssilistasta parametrin avulla määritellyt kurssit
     * taulukkoon.
     *
     * @param kurssilista Lista Kurssi-olioita.
     * @param valinta Parametri jonka avulla määritellään taulukkoon haluttavat
     * kurssit, opintokokonaisuus/ pakollisuus.
     * @return Taulukko joka sisältää haluttujen kurssien nimet/ nimet ja
     * arvosanat.
     */
    public static String[] lueTaulukkoonParametrilla(ArrayList<Kurssi> kurssilista, String valinta) {
        int koko = 0;
        int i = 0;
        while (i < kurssilista.size()) {
            if (kurssilista.get(i).annaOpintokokonaisuus().equals(valinta) || kurssilista.get(i).annaPakollisuus().equals(valinta)) {
                koko = koko + 1;
            }
            i = i + 1;
        }
        String[] taulukko = new String[koko];
        int j = 0;
        int k = 0;
        while (j < kurssilista.size()) {
            if (kurssilista.get(j).annaOpintokokonaisuus().equals(valinta) || kurssilista.get(j).annaPakollisuus().equals(valinta)) {
                if (kurssilista.get(j).annaArvosana() == 0) {
                    taulukko[k] = kurssilista.get(j).annaNimi();

                } else {
                    taulukko[k] = kurssilista.get(j).annaNimi() + "         " + kurssilista.get(j).annaArvosana();

                }
                k = k + 1;
            }
            j = j + 1;

        }
        return taulukko;
    }

    // Ohjelman käynnistävä main-metodi
    public static void main(String args[]) {
        kurssitaulukko = lueTaulukkoon();
        kurssilista = lueListaan();
        kuuntelija = new OhjelmoinninHarjoitustyö();
        ikkuna = new Ulkoasu(kuuntelija, kurssitaulukko, kurssilista);
    }
}
