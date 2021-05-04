package Taskmanager;
import java.util.GregorianCalendar;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Aufgabenbibliothek abib = new Aufgabenbibliothek();
        GregorianCalendar now = new GregorianCalendar();
        GregorianCalendar dead = new GregorianCalendar(2021, 01, 30);
        Aufgabe aufgabe1 = new Aufgabe("Nichts", now);
        Aufgabe aufgabe2 = new AufgabeMitDeadline(dead, "Wiedernichts",now);
        abib.aufgabeHinzufuegen(aufgabe1);
        abib.aufgabeHinzufuegen(aufgabe2);
        Kommandozeilenmenu kmd = new Kommandozeilenmenu(abib);
        kmd.start();
    }
}
