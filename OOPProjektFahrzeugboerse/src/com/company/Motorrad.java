package com.company;

public class Motorrad extends Fzg {

    private String typ;

    public void printMotorrad(int i) {
        System.out.println("Position Array: " + i + ", Motorrad:" +
                ", Marke: " + super.marke +
                ", Modell: " + super.modell +
                ", Farbe: " + super.farbe +
                ", Baujahr: " + super.baujahr +
                ", Preis: " + super.preis +
                ", Typ: " + typ);
    }

    public Motorrad(String marke, String modell, String farbe, int baujahr, double preis, String typ) {
        super(marke, modell, farbe, baujahr, preis);
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
