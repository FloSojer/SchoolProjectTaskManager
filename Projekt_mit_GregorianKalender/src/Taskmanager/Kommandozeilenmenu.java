package Taskmanager;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import java.util.Scanner;

public class Kommandozeilenmenu {
    Scanner scan;
    Aufgabenbibliothek aufgabenBibliothek;
    //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public Kommandozeilenmenu(Aufgabenbibliothek aufgabenBibliothek) {
        this.scan = new Scanner(System.in);
        this.aufgabenBibliothek = aufgabenBibliothek;
    }

    public void MenuAnzeigen() {
        System.out.println("MEN�");
        System.out.println("1) Alle Aufgaben anzeigen");
        System.out.println("2) Aufgaben durchsuchen");
        System.out.println("3) Deadlines anzeigen");
        System.out.println("4) Neue Aufgabe hinzufuegen");
        System.out.println("    a) Standard Aufgabe ");
        System.out.println("    b) Aufgabe mit Deadline ");
        System.out.println("5) Aufgabe erledigt");
        System.out.println("6) Beenden");

    }

    public void start() {
        String s = "-";
        while (!s.equals("6")) {
            MenuAnzeigen();
            s = scan.nextLine();
            switch(s)
            {
                case "1":
                    alleAufgabenAnzeigen();
                    break;
                case "2":
                    aufgabenDurchsuchen();
                    break;
                case "3":
                    deadLinesAnzeigen();
                    break;
                case "4":
                    aufgabehinzf();
                    break;
                case "5":
                    aufgabeerledigt();
                    break;
                case "6":
                    break;
                default:
                    this.fehler();
                    break;
            }
        }
        scan.close();
    }

    public void alleAufgabenAnzeigen() {
        this.aufgabenBibliothek.aufgabenAusgeben();
    }

    public void aufgabenDurchsuchen(){
        System.out.println("Nach Welcher Aufgabe suchen Sie? ");
        String aufgabentextSuche = scan.nextLine();
        boolean gefunden = false;
        for(Aufgabe aufg : aufgabenBibliothek.alleAufgaben() ){
            if(aufg.getAufgabentext().equals(aufgabentextSuche)){
                System.out.println("wir haben Sie gefunden! ");
                aufg.anzeigen();
                gefunden = true;
            }
        }
        if(!gefunden){
            System.out.println("Wir konnten Sie leider nicht finden.");
            System.out.println(" ");
        }
    }

    public void deadLinesAnzeigen(){
        GregorianCalendar now = new GregorianCalendar();
        SimpleDateFormat formati = new SimpleDateFormat();
        for(AufgabeMitDeadline aufgabe : aufgabenBibliothek.gibDeadlines()){
            if(aufgabe.getDatumErstellung().compareTo(now) < 0 ){
                int laenge = aufgabe.getAufgabentext().length();
                String teiltext = aufgabe.getAufgabentext();
                String grossSchreib = teiltext.substring(0, laenge).toUpperCase();
                aufgabe.setAufgabentext(grossSchreib);
                aufgabe.anzeigen();
                aufgabe.setAufgabentext(teiltext);
            }
            else{
                aufgabe.anzeigen();
            }

        }
    }

    public void aufgabehinzf(){
        System.out.println("Moechten sie eine Stanardaufgabe oder mit Deadline hinzufuegne? (a = Standard | b = mit deadline)");
        String eingabe = scan.nextLine();
        if(eingabe.equals("a")){
            System.out.println("Bitte geben Sie den Aufgaqbentext ein: ");
            String aufgabentext = scan.nextLine();
            GregorianCalendar now = new GregorianCalendar();
            Aufgabe neueAufgabe = new Aufgabe(aufgabentext, now);
            aufgabenBibliothek.aufgabeHinzufuegen(neueAufgabe);
        }
        else if(eingabe.equals("b")){
            System.out.println("Bitte geben Sie den Aufgaqbentext ein: ");
            String aufgabentext = scan.nextLine();
            System.out.println("Bitte geben Sie eine Deadline ein: (YYYY.MM.DD) ");
            String deadLine = scan.nextLine();
            int jahr = Integer.parseInt(deadLine.substring(0,3));
            int monat = Integer.parseInt(deadLine.substring(5,6));
            int tag = Integer.parseInt(deadLine.substring(8,9));
            GregorianCalendar now = new GregorianCalendar();
            GregorianCalendar deadTime = new GregorianCalendar(jahr, monat, tag);

            Aufgabe neueAufgabe = new AufgabeMitDeadline(deadTime, aufgabentext,now);
            aufgabenBibliothek.aufgabeHinzufuegen(neueAufgabe);
        }
        else{
            System.out.println("Falsche Eingabe!");
        }

    }

    public void aufgabeerledigt(){
        System.out.println("Welche Aufgabe moechten sie loeschen? ");
        String aufgabentextSuche = scan.nextLine();
        boolean gefunden = false;
        for(Aufgabe aufg : aufgabenBibliothek.alleAufgaben() ){
            if(aufg.getAufgabentext().equals(aufgabentextSuche)){
                aufgabenBibliothek.aufgabeErledigt(aufg);
                gefunden = true;
            }
        }
        if(!gefunden){
            System.out.println("Wir konnten Sie leider nicht finden.");
            System.out.println(" ");
        }
    }
    public void fehler(){
        System.out.println("Fehler! ");
    }
}