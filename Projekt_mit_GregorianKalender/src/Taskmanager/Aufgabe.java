package Taskmanager;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Aufgabe {
    private String aufgabentext;
    private final GregorianCalendar datumErstellung;


    public Aufgabe (String aufgabentext, GregorianCalendar datumErstellung){
        this.aufgabentext = aufgabentext;
        this.datumErstellung = datumErstellung;
    }

    public String getAufgabentext () {
        return aufgabentext;
    }

    public GregorianCalendar getDatumErstellung () {
        return datumErstellung;
    }

    public void setAufgabentext ( String aufgabentext ) {
        this.aufgabentext = aufgabentext;
    }

    @Override
    public String toString () {
        SimpleDateFormat formati = new SimpleDateFormat();
        return "Aufgabe{" +
                "aufgabentext='" + aufgabentext + '\'' +
                ", datumErstellung='" + formati.format(datumErstellung.getTime()) + '\'' + '}';
    }

    public void anzeigen(){
        SimpleDateFormat formati = new SimpleDateFormat();
        System.out.println("Aufgabentext : " +  aufgabentext + " Erstellungsdatum: " + formati.format(datumErstellung.getTime()));
    }
}
