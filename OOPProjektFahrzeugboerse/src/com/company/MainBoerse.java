package com.company;

import java.util.Scanner;

public class MainBoerse {
    static Datenbank fzgDatenbank = null;

    public static void main(String[] args) {
        fzgDatenbank = new Datenbank();
        fzgDatenbank.fuegeDummyDatensaetzeHinzu();
        hauptMenu();
    }

    public static void hauptMenu() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Fahrzeugbörse     Hauptmenü     von: Patryk Filipow");
        System.out.println("---------------------------------------------------");
        System.out.println("1) Fahrzeug anlegen\n2) Fahrzeug bearbeiten" +
                "\n3) Fahrzeug suchen\n4) Fahrzeug löschen\n0) Börse beenden");
        System.out.println("---------------------------------------------------");
        System.out.println("Bitte wählen:");
        Scanner scanner = new Scanner(System.in);
        String auswahlUser = scanner.nextLine();

        switch (auswahlUser) {
            case "1":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Hiermit werden Fahrzeuge angelegt, New Player.");
                System.out.println("---------------------------------------------------");
                fzgDatenbank.fzgAnlegen();
            case "2":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Hiermit werden Fahrzeuge bearbeitet, Change Loadout.");
                System.out.println("---------------------------------------------------");
                System.out.println("1) Fahrzeug bearbeiten\n9) Hauptmenü");
                System.out.println("---------------------------------------------------");
                System.out.println("Bitte wählen:");
                auswahlUser = scanner.nextLine();
                switch (auswahlUser) {
                    case "1":
                        fzgDatenbank.fzgBearbeiten();
                    case "9":
                        hauptMenu();
                    default:
                        fzgDatenbank.fehlerEingabe();
                        hauptMenu();
                }
            case "3":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Hiermit werden Fahrzeuge gesucht, Search.");
                System.out.println("---------------------------------------------------");
                System.out.println("1) Fahrzeug suchen\n9) Hauptmenü");
                System.out.println("---------------------------------------------------");
                System.out.println("Bitte wählen:");
                auswahlUser = scanner.nextLine();
                switch (auswahlUser) {
                    case "1":
                        fzgDatenbank.fzgSuchen();
                    case "9":
                        hauptMenu();
                    default:
                        fzgDatenbank.fehlerEingabe();
                        hauptMenu();
                }
            case "4":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Hiermit werden Fahrzeuge gelöscht, Destroy.");
                System.out.println("---------------------------------------------------");
                System.out.println("1) Fahrzeug löschen\n9) Hauptmenü");
                System.out.println("---------------------------------------------------");
                System.out.println("Bitte wählen:");
                auswahlUser = scanner.nextLine();
                switch (auswahlUser) {
                    case "1":
                        fzgDatenbank.fzgLoeschen();
                    case "9":
                        hauptMenu();
                    default:
                        fzgDatenbank.fehlerEingabe();
                        hauptMenu();
                }
            case "0":
                fzgDatenbank.boerseBeenden();
            default:
                fzgDatenbank.fehlerEingabe();
                hauptMenu();
        }
    }
}
