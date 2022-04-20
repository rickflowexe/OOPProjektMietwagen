package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.MainBoerse.hauptMenu;

public class Datenbank {

    private final ArrayList<Fzg> FZG_ARRAYLIST;
    Scanner scanner = new Scanner(System.in);
    private String markeHinzufuegen = null, modellHinzufuegen = null,
            farbeHinzufuegen = null, antriebHinzufuegen = null,
            typHinzufuegen = null;
    private int baujahrHinzufuegen = 0, anzahlTuerenHinzufuegen = 0;
    private double preisHinzufuegen = 0;
    private boolean mitAnhaengerHinzufuegen = false;

    public void fehlerEingabe() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Fehlerhafte Eingabe");
        System.out.println("---------------------------------------------------");
    }

    public void fzgFuellen() {
        System.out.println("---------------------------------------------------");
        System.out.println("Marke eingeben:(String)");
        markeHinzufuegen = scanner.nextLine();
        System.out.println("Modell eingeben:(String)");
        modellHinzufuegen = scanner.nextLine();
        System.out.println("Farbe eingeben:(String)");
        farbeHinzufuegen = scanner.nextLine();
        System.out.println("Baujahr eingeben:(int)");
        baujahrHinzufuegen = scanner.nextInt();
        System.out.println("Preis eingeben:(double)");
        preisHinzufuegen = scanner.nextDouble();
    }

    public void printArray() {
        System.out.println("\n----------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------------------------------------");
        for (int i = 0; i < FZG_ARRAYLIST.size(); i++) {
            if (FZG_ARRAYLIST.get(i) instanceof Pkw) {
                ((Pkw) FZG_ARRAYLIST.get(i)).printPkw(i);
            }
            if (FZG_ARRAYLIST.get(i) instanceof Lkw) {
                ((Lkw) FZG_ARRAYLIST.get(i)).printLkw(i);
            }
            if (FZG_ARRAYLIST.get(i) instanceof Boot) {
                ((Boot) FZG_ARRAYLIST.get(i)).printBoot(i);
            }
            if (FZG_ARRAYLIST.get(i) instanceof Motorrad) {
                ((Motorrad) FZG_ARRAYLIST.get(i)).printMotorrad(i);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------------------------------------");
    }

    public void neuesFzgHinzuMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("1) Neues Fahrzeug anlegen\n9) Hauptmenü");
        System.out.println("---------------------------------------------------");
        System.out.println("Bitte wählen:");
        String auswahlUser = scanner.nextLine();
        switch (auswahlUser) {
            case "1":
                fzgAnlegen();
            case "9":
                hauptMenu();
            default:
                fehlerEingabe();
                hauptMenu();
        }
    }

    public void anderesFzgBearbeitenMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("1) Anderes Fahrzeug bearbeiten\n9) Hauptmenü");
        System.out.println("---------------------------------------------------");
        System.out.println("Bitte wählen:");
        String auswahlUser = scanner.nextLine();
        switch (auswahlUser) {
            case "1":
                fzgBearbeiten();
            case "9":
                hauptMenu();
            default:
                fehlerEingabe();
                hauptMenu();
        }
    }

    public void neuesFzgSuchenMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("1) Neues Fahrzeug suchen?\n9) Hauptmenü");
        System.out.println("---------------------------------------------------");
        System.out.println("Bitte wählen:");
        String auswahlUser = scanner.nextLine();
        switch (auswahlUser) {
            case "1":
                fzgSuchen();
            case "9":
                hauptMenu();
            default:
                fehlerEingabe();
                hauptMenu();
        }
    }

    public void anderesFzgLoeschenMenu() {
        System.out.println("1) Anderes Fahrzeug löschen\n9) Hauptmenü");
        System.out.println("---------------------------------------------------");
        System.out.println("Bitte wählen:");
        String auswahlUser = scanner.nextLine();
        switch (auswahlUser) {
            case "1":
                fzgLoeschen();
            case "9":
                hauptMenu();
            default:
                fehlerEingabe();
                hauptMenu();
        }
    }

    public Datenbank() {
        FZG_ARRAYLIST = new ArrayList<>();
    }

    public void fuegeDummyDatensaetzeHinzu() {
        FZG_ARRAYLIST.add(new Pkw("Ferrari", "LaFerrari", "Schwarz",
                2019, 250000, 3));
        FZG_ARRAYLIST.add(new Lkw("Mercedes", "Actros", "Silber",
                2012, 150000, true));
        FZG_ARRAYLIST.add(new Boot("Ferrari", "Riva", "Rot",
                2018, 350000, "Motor"));
        FZG_ARRAYLIST.add(new Motorrad("Ducati", "Superleggera V4",
                "Rot-Schwarz", 2020, 100000, "Supersport"));
    }

    public void fzgAnlegen() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Auswahl Fahrzeug");
        System.out.println("---------------------------------------------------");
        System.out.println("1) Pkw\n2) Lkw\n3) Boot\n4) Motorrad\n9) Hauptmenü");
        System.out.println("---------------------------------------------------");
        System.out.println("Bitte wählen:");
        String auswahlUser = scanner.nextLine();

        switch (auswahlUser) {
            case "1":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Pkw anlegen ausgewählt");
                fzgFuellen();
                System.out.println("Anzahl Türen eingeben:(int)");
                anzahlTuerenHinzufuegen = scanner.nextInt();
                scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0 && anzahlTuerenHinzufuegen != 0) {
                    FZG_ARRAYLIST.add(new Pkw(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            anzahlTuerenHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug angelegt");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                neuesFzgHinzuMenu();
            case "2":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Lkw anlegen ausgewählt");
                fzgFuellen();
                System.out.println("Mit Anhänger?(true/false)");
                mitAnhaengerHinzufuegen = scanner.nextBoolean();
                scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0) {
                    FZG_ARRAYLIST.add(new Lkw(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            mitAnhaengerHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug angelegt");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                neuesFzgHinzuMenu();
            case "3":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Boot anlegen ausgewählt");
                fzgFuellen();
                scanner.nextLine();
                System.out.println("Antrieb eingeben:(String)");
                antriebHinzufuegen = scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0 && antriebHinzufuegen != null) {
                    FZG_ARRAYLIST.add(new Boot(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            antriebHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug angelegt");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                neuesFzgHinzuMenu();
            case "4":
                System.out.println("\n---------------------------------------------------");
                System.out.println("Motorrad anlegen ausgewählt");
                fzgFuellen();
                scanner.nextLine();
                System.out.println("Typ eingeben:(String)");
                typHinzufuegen = scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0 && typHinzufuegen != null) {
                    FZG_ARRAYLIST.add(new Motorrad(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            typHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug angelegt");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                neuesFzgHinzuMenu();
            case "9":
                hauptMenu();
            default:
                fehlerEingabe();
                hauptMenu();
        }
    }

    public void fzgBearbeiten() {
        printArray();
        System.out.println("\n---------------------------------------------------");
        System.out.println("Wähle die Position des Arrays aus die du bearbeiten möchtest:");
        int bearbeitenUser = scanner.nextInt();
        scanner.nextLine();
        boolean bearbeitenUserRichtig = false;
        if (bearbeitenUser >= 0 && bearbeitenUser < FZG_ARRAYLIST.size()) {
            bearbeitenUserRichtig = true;
            if (FZG_ARRAYLIST.get(bearbeitenUser) instanceof Pkw) {
                System.out.println("\n---------------------------------------------------");
                System.out.println("Pkw bearbeiten");
                fzgFuellen();
                System.out.println("Anzahl Türen eingeben:(int)");
                anzahlTuerenHinzufuegen = scanner.nextInt();
                scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0 && anzahlTuerenHinzufuegen != 0) {
                    FZG_ARRAYLIST.set(bearbeitenUser, new Pkw(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            anzahlTuerenHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug geändert");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                anderesFzgBearbeitenMenu();
            }
            if (FZG_ARRAYLIST.get(bearbeitenUser) instanceof Lkw) {
                System.out.println("\n---------------------------------------------------");
                System.out.println("Lkw bearbeiten");
                fzgFuellen();
                System.out.println("Mit Anhänger?(true/false)");
                mitAnhaengerHinzufuegen = scanner.nextBoolean();
                scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0) {
                    FZG_ARRAYLIST.set(bearbeitenUser, new Lkw(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            mitAnhaengerHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug geändert");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                anderesFzgBearbeitenMenu();
            }
            if (FZG_ARRAYLIST.get(bearbeitenUser) instanceof Boot) {
                System.out.println("\n---------------------------------------------------");
                System.out.println("Boot bearbeiten");
                fzgFuellen();
                scanner.nextLine();
                System.out.println("Antrieb eingeben:(String)");
                antriebHinzufuegen = scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0 && antriebHinzufuegen != null) {
                    FZG_ARRAYLIST.set(bearbeitenUser, new Boot(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            antriebHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug geändert");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                anderesFzgBearbeitenMenu();
            }
            if (FZG_ARRAYLIST.get(bearbeitenUser) instanceof Motorrad) {
                System.out.println("\n---------------------------------------------------");
                System.out.println("Motorrad bearbeiten");
                fzgFuellen();
                scanner.nextLine();
                System.out.println("Typ eingeben:(String)");
                typHinzufuegen = scanner.nextLine();
                if (markeHinzufuegen != null && modellHinzufuegen != null
                        && farbeHinzufuegen != null && baujahrHinzufuegen != 0
                        && preisHinzufuegen != 0 && typHinzufuegen != null) {
                    FZG_ARRAYLIST.set(bearbeitenUser, new Motorrad(markeHinzufuegen, modellHinzufuegen,
                            farbeHinzufuegen, baujahrHinzufuegen, preisHinzufuegen,
                            typHinzufuegen));
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fahrzeug geändert");
                } else {
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Fehler: Fahrzeug nicht angelegt");
                }
                anderesFzgBearbeitenMenu();
            }
        }
        if (!bearbeitenUserRichtig) {
            fehlerEingabe();
            System.out.println("1) Neues Fahrzeug bearbeiten?\n9) Hauptmenü");
            System.out.println("---------------------------------------------------");
            System.out.println("Bitte wählen:");
            String auswahlUser = scanner.nextLine();
            switch (auswahlUser) {
                case "1":
                    fzgBearbeiten();
                case "9":
                    hauptMenu();
                default:
                    fehlerEingabe();
                    hauptMenu();
            }
        }
    }

    public void fzgSuchen() {
        boolean sucheErfolgreich = false;
        ArrayList<Fzg> fzgSucheArrayList = new ArrayList<>();
        System.out.println("\n---------------------------------------------------");
        System.out.println("Bitte gebe die Marke ein nach der du suchst:");
        String sucheUser = scanner.nextLine().toLowerCase();
        for (int i = 0; i < FZG_ARRAYLIST.size(); i++) {
            if (FZG_ARRAYLIST.get(i) instanceof Pkw &&
                    FZG_ARRAYLIST.get(i).getMarke().toLowerCase().contains(sucheUser)) {
                sucheErfolgreich = true;
                fzgSucheArrayList.add(FZG_ARRAYLIST.get(i));
            }
            if (FZG_ARRAYLIST.get(i) instanceof Lkw &&
                    FZG_ARRAYLIST.get(i).getMarke().toLowerCase().contains(sucheUser)) {
                sucheErfolgreich = true;
                fzgSucheArrayList.add(FZG_ARRAYLIST.get(i));
            }
            if (FZG_ARRAYLIST.get(i) instanceof Boot &&
                    FZG_ARRAYLIST.get(i).getMarke().toLowerCase().contains(sucheUser)) {
                sucheErfolgreich = true;
                fzgSucheArrayList.add(FZG_ARRAYLIST.get(i));
            }
            if (FZG_ARRAYLIST.get(i) instanceof Motorrad &&
                    FZG_ARRAYLIST.get(i).getMarke().toLowerCase().contains(sucheUser)) {
                sucheErfolgreich = true;
                fzgSucheArrayList.add(FZG_ARRAYLIST.get(i));
            }
        }
        if (sucheErfolgreich) {
            System.out.println("\n–––––––––––––----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------------------------------");
        }
        for (int i = 0; i < fzgSucheArrayList.size(); i++) {
            if (fzgSucheArrayList.get(i) instanceof Pkw) {
                ((Pkw) fzgSucheArrayList.get(i)).printPkw(i);
            }
            if (fzgSucheArrayList.get(i) instanceof Lkw) {
                ((Lkw) fzgSucheArrayList.get(i)).printLkw(i);
            }
            if (fzgSucheArrayList.get(i) instanceof Boot) {
                ((Boot) fzgSucheArrayList.get(i)).printBoot(i);
            }
            if (fzgSucheArrayList.get(i) instanceof Motorrad) {
                ((Motorrad) fzgSucheArrayList.get(i)).printMotorrad(i);
            }
        }
        if (sucheErfolgreich) {
            System.out.println("–––––––––––––----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------------------------------");
            System.out.println("\n---------------------------------------------------");
            System.out.println("Fahrzeuge mit Marke: " + sucheUser + " gefunden");

        }
        if (!sucheErfolgreich) {
            System.out.println("\n---------------------------------------------------");
            System.out.println("Kein Fahrzeug mit Marke: " + sucheUser + " gefunden");
        }
        neuesFzgSuchenMenu();
    }

    public void fzgLoeschen() {
        printArray();
        System.out.println("\n---------------------------------------------------");
        System.out.println("Wähle die Position des Arrays aus die du löschen möchtest:");
        int loescheUser = scanner.nextInt();
        scanner.nextLine();
        boolean loescheUserRichtig = false;
        if (loescheUser >= 0 && loescheUser < FZG_ARRAYLIST.size()) {
            loescheUserRichtig = true;
            System.out.println("\n---------------------------------------------------");
            System.out.println("Position Array: " + loescheUser + " wirklich löschen");
            System.out.println("---------------------------------------------------");
            System.out.println("1) Ja\n2) Anderes Fahrzeug löschen\n9) Hauptmenü");
            System.out.println("---------------------------------------------------");
            System.out.println("Bitte wählen:");
            String auswahlUser = scanner.nextLine();
            switch (auswahlUser) {
                case "1":
                    FZG_ARRAYLIST.remove(loescheUser);
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("Position Array: " + loescheUser + " erfolgreich gelöscht");
                    System.out.println("---------------------------------------------------");
                    anderesFzgLoeschenMenu();
                case "2":
                    fzgLoeschen();
                case "9":
                    hauptMenu();
                default:
                    fehlerEingabe();
                    anderesFzgLoeschenMenu();
            }
        }
        if (!loescheUserRichtig) {
            fehlerEingabe();
            anderesFzgLoeschenMenu();
        }
    }

    public void boerseBeenden() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Hiermit wird die Fahrzeugbörse beendet, Finisher.");
        System.out.println("---------------------------------------------------");
        System.out.println("0) Börse beenden bestätigen\n9) Hauptmenü");
        System.out.println("---------------------------------------------------");
        System.out.println("Bitte wählen:");
        String auswahlUser = scanner.nextLine();
        switch (auswahlUser) {
            case "0":
                System.exit(0);
            case "9":
                hauptMenu();
            default:
                fehlerEingabe();
                hauptMenu();
        }
    }
}
