package com.company;

public class Boot extends Fzg {

    private String antrieb;

    public void printBoot(int i) {
        System.out.println("Position Array: " + i + ", Boot:" +
                ", Marke: " + super.marke +
                ", Modell: " + super.modell +
                ", Farbe: " + super.farbe +
                ", Baujahr: " + super.baujahr +
                ", Preis: " + super.preis +
                ", Antrieb: " + antrieb);
    }

    public Boot(String marke, String modell, String farbe, int baujahr, double preis, String antrieb) {
        super(marke, modell, farbe, baujahr, preis);
        this.antrieb = antrieb;
    }

    public String getAntrieb() {
        return antrieb;
    }

    public void setAntrieb(String antrieb) {
        this.antrieb = antrieb;
    }
}
