package ohjelmoinninharjoitustyö;

/**
 *
 * @author elinapalmgren
 */
import java.io.*;
import java.util.*;

public class Apumetodit {

    /**
     * Käsiteltävät listat sisältävät Kurssi-olioita.
     */
    private static Kurssi kurssi;

    /**
     * Avaa tekstitiedoston lukemista varten.
     *
     * @param tiedosto Valitaan tarkasteltava tekstitiedosto.
     * @return Lukemista varten avattu tiedosto.
     */
    public static Scanner avaaLuettavaksi(String tiedosto) {
        try {
            File tiedostoKahva = new File(tiedosto);
            Scanner syottotiedosto = new Scanner(tiedostoKahva);
            return syottotiedosto;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * Avaa tekstitiedoston muokkausta varten.
     *
     * @param tiedosto Valitaan tarkasteltava tiedosto.
     * @return Muokkausta varten avattu tiedosto.
     */
    public static PrintWriter avaaKirjoitettavaksi(String tiedosto) {
        try {
            File tiedostoKahva = new File(tiedosto);
            PrintWriter kirjoitettavatiedosto = new PrintWriter(tiedostoKahva);
            return kirjoitettavatiedosto;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * Kirjoitetaan ArrayList-listan sisältämät Kurssi-oliot
     * kurssit-tekstitiedostoon.
     *
     * @param taulukko Lista tekstitiedostoon siirrettävistä Kurssi-olio
     * -tiedoista.
     * @param tiedosto Tekstitiedosto johon taulukko talletetaan.
     */
    public static void lueListaTiedostoon(ArrayList<Kurssi> taulukko, String tiedosto) {
        PrintWriter syottotiedosto;
        if (tiedosto.equals("testikurssit")) {
            syottotiedosto = avaaKirjoitettavaksi("/Users/elinapalmgren/NetBeansProjects/OhjelmoinninHarjoitustyö/src/testikurssit.txt");
        } else {
            syottotiedosto = avaaKirjoitettavaksi("/Users/elinapalmgren/NetBeansProjects/OhjelmoinninHarjoitustyö/src/kurssit.txt");
        }
        syottotiedosto.print(taulukko.get(0).annaNimi() + "|" + taulukko.get(0).annaOpintopisteet() + "|" + taulukko.get(0).annaOpintokokonaisuus() + "|" + taulukko.get(0).annaPakollisuus() + "|" + taulukko.get(0).annaArvosana());
        int i = 1;
        while (i < taulukko.size()) {
            syottotiedosto.print("\n" + taulukko.get(i).annaNimi() + "|" + taulukko.get(i).annaOpintopisteet() + "|" + taulukko.get(i).annaOpintokokonaisuus() + "|" + taulukko.get(i).annaPakollisuus() + "|" + taulukko.get(i).annaArvosana());
            i = i + 1;
        }
        syottotiedosto.close();
    }

    /**
     * Muokkaa kurssilistaan sisältyvän Kurssi-olion arvosanaa.
     *
     * @param kurssilista ArrayList-lista joka sisältää Kurssi-olioita.
     * @param kurssinimi Sen kurssin nimi, jonka arvosanaa halutaan muokata.
     * @param arvosana Kurssille asetettava arvosana.
     */
    public static void lisaaArvosana(ArrayList<Kurssi> kurssilista, String kurssinimi, int arvosana, String tiedosto) {
        int i = 0;
        while (i < kurssilista.size()) {
            kurssi = kurssilista.get(i);
            if (kurssi.annaNimi().equals(kurssinimi)) {
                kurssi.asetaArvosana(arvosana);
                break;
            }
            i = i + 1;
        }
        Apumetodit.lueListaTiedostoon(kurssilista, tiedosto);
    }

   
}
