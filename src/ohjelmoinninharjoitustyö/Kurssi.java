package ohjelmoinninharjoitustyö;

/**
 *
 * @author elinapalmgren
 */
public class Kurssi {

    /**
     * Kurssi-olion eli kurssin nimi.
     */
    String nimi;
    /**
     * Kurssi-olion eli kurssin opintopistemäärä.
     */
    int opintopisteet;
    /**
     * Opintokokonaisuus johon Kurssi-olio eli kurssi kuuluu.
     */
    String opintokokonaisuus;
    /**
     * Kurssi-olion eli kurssin arvosana.
     */
    int arvosana;
    /**
     * Kurssi-olion eli kurssin pakollisuus/ vapaaehtoisuus.
     */
    String pakollisuus;
    /**
     * String-taulukko Kurssi-olion luontia ja kurssin tietoja varten.
     */
    String[] taulu = new String[5];

    /**
     * Luokan Kurssi konstruktori.
     *
     * @param taulu Parametrina annetaan taulukko, joka sisältää olion tiedot.
     */
    public Kurssi(String[] taulu) {
        this.nimi = taulu[0];
        this.opintopisteet = Integer.parseInt(taulu[1]);
        this.opintokokonaisuus = taulu[2];
        this.pakollisuus = taulu[3];
        this.arvosana = Integer.parseInt(taulu[4]);
    }

    /**
     * Nimigetteri.
     *
     * @return Kurssi-olion nimi.
     */
    public String annaNimi() {
        return nimi;
    }

    /**
     * Opintopistegetteri.
     *
     * @return Kurssi-olion opintopisteet.
     */
    public int annaOpintopisteet() {
        return opintopisteet;
    }

    /**
     * Pakollisuusgetteri.
     *
     * @return Kurssi-olion pakollisuustieto.
     */
    public String annaPakollisuus() {
        return pakollisuus;
    }

    /**
     * Opintokokonaisuusgetteri.
     *
     * @return Kurssi-olion opintokokonaisuus.
     */
    public String annaOpintokokonaisuus() {
        return opintokokonaisuus;
    }

    /**
     * Arvosanagetteri.
     *
     * @return Kurssi-olion arvosana.
     */
    public int annaArvosana() {
        return arvosana;
    }

    /**
     * Arvosanasetteri.
     *
     * @param arvosana Kurssi-oliolle asetettava arvosana.
     */
    public void asetaArvosana(int arvosana) {
        if (arvosana > 0 && arvosana < 6) {
            this.arvosana = arvosana;
        }
    }
}
