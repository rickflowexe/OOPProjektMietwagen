package com.company;

public class Lkw extends Fzg {

    private boolean mitAnhaenger;

    public void printLkw(int i) {
        System.out.println("Position Array: " + i + ", Lkw:" +
                ", Marke: " + super.marke +
                ", Modell: " + super.modell +
                ", Farbe: " + super.farbe +
                ", Baujahr: " + super.baujahr +
                ", Preis: " + super.preis +
                ", Mit Anhänger: " + mitAnhaenger);
    }

    public Lkw(String marke, String modell, String farbe, int baujahr, double preis, boolean mitAnhaenger) {
        super(marke, modell, farbe, baujahr, preis);
        this.mitAnhaenger = mitAnhaenger;
    }

    public boolean isMitAnhaenger() {
        return mitAnhaenger;
    }

    public void setMitAnhaenger(boolean mitAnhaenger) {
        this.mitAnhaenger = mitAnhaenger;
    }
}
