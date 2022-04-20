package com.company;

public class Pkw extends Fzg {

    private int anzahlTueren;

    public void printPkw(int i) {
        System.out.println("Position Array: " + i + ", Pkw:" +
                ", Marke: " + super.marke +
                ", Modell: " + super.modell +
                ", Farbe: " + super.farbe +
                ", Baujahr: " + super.baujahr +
                ", Preis: " + super.preis +
                ", Anzahl Türen: " + anzahlTueren);
    }

    public Pkw(String marke, String modell, String farbe, int baujahr, double preis, int anzahlTueren) {
        super(marke, modell, farbe, baujahr, preis);
        this.anzahlTueren = anzahlTueren;
    }

    public int getAnzahlTueren() {
        return anzahlTueren;
    }

    public void setAnzahlTueren(int anzahlTueren) {
        this.anzahlTueren = anzahlTueren;
    }
}
