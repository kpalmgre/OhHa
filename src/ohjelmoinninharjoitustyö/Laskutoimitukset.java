package ohjelmoinninharjoitustyö;

/**
 *
 * @author elinapalmgren
 */
import java.util.*;

public class Laskutoimitukset {

    /**
     * Laskee kurssien lukumäärän.
     *
     * @param suoritus Määritellään, onko kurssi suoritettu vai ei.
     * @param valinta Määritellään parametri, jonka avulla valitaan tietyt
     * tarkasteltavat kurssit.
     * @param kurssilista Kurssi-oliot sisältävä ArrayList-lista.
     * @return Tietyt ehdot toteuttavien kurssien lukumäärä.
     */
    public static int laskeKurssit(String suoritus, String valinta, ArrayList<Kurssi> kurssilista) {
        int maara = 0;
        int i = 0;
        while (i < kurssilista.size()) {
            if (kurssilista.get(i).annaOpintokokonaisuus().equals(valinta) || kurssilista.get(i).annaPakollisuus().equals(valinta)) {
                if (suoritus.equals("suoritettu") && kurssilista.get(i).annaArvosana() != 0) {
                    maara = maara + 1;
                } else if ((suoritus.equals("suorittamatta") && kurssilista.get(i).annaArvosana() == 0)) {
                    maara = maara + 1;
                }
            }
            i = i + 1;
        }
        return maara;
    }

    /**
     * Laskee suoritettujen kurssien osuuden kaikista kursseista.
     *
     * @param valinta Määritellään parametri, jonka avulla valitaan tietyt
     * tarkasteltavat kurssit.
     * @param kurssilista Kurssi-oliot sisältävä ArrayList-lista.
     * @return Suoritettujen kurssien prosenttiosuus.
     */
    public static int laskeOsuus(String valinta, ArrayList<Kurssi> kurssilista) {
        double osoittaja = Laskutoimitukset.laskeKurssit("suoritettu", valinta, kurssilista);
        double nimittaja = Laskutoimitukset.laskeKurssit("suorittamatta", valinta, kurssilista) + osoittaja;
        int osuus = (int) Math.ceil(osoittaja / nimittaja * 100);
        return osuus;
    }

    /**
     * Laskee suoritettujen kurssien opintopisteiden määrän.
     *
     * @param valinta Määritellään parametri, jonka avulla valitaan tietyt
     * tarkasteltavat kurssit.
     * @param kurssilista Kurssi-oliot sisältävä ArrayList-lista.
     * @return Opintopistemäärä.
     */
    public static int laskeOpintopisteet(String valinta, ArrayList<Kurssi> kurssilista) {
        int pisteet = 0;
        int i = 0;
        while (i < kurssilista.size()) {
            if (kurssilista.get(i).annaArvosana() != 0 && (kurssilista.get(i).annaOpintokokonaisuus().equals(valinta) || kurssilista.get(i).annaPakollisuus().equals(valinta))) {
                pisteet = pisteet + kurssilista.get(i).annaOpintopisteet();
            }
            i = i + 1;
        }
        return pisteet;

    }

    /**
     * Laskee suoritettujen kurssien arvosanojen keskiarvon.
     *
     * @param valinta Määritellään parametri, jonka avulla valitaan tietyt
     * tarkasteltavat kurssit.
     * @param kurssilista Kurssi-oliot sisältävä ArrayList-lista.
     * @return Keskiarvo.
     */
    public static int laskeKeskiarvo(String valinta, ArrayList<Kurssi> kurssilista) {
        int osoittaja = 0;
        int i = 0;
        while (i < kurssilista.size()) {
            if (kurssilista.get(i).annaArvosana() != 0 && (kurssilista.get(i).annaOpintokokonaisuus().equals(valinta) || kurssilista.get(i).annaPakollisuus().equals(valinta))) {
                osoittaja = osoittaja + kurssilista.get(i).arvosana;
            }
            i = i + 1;
        }
        double nimittaja = laskeKurssit("suoritettu", valinta, kurssilista);
        int keskiarvo = (int) Math.ceil(osoittaja / nimittaja);
        return keskiarvo;
    }
}
