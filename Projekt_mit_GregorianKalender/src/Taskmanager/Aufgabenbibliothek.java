package Taskmanager;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;

public class Aufgabenbibliothek {
    private ArrayList<Aufgabe> bibliothek;
    public Aufgabenbibliothek(){
        this.bibliothek = new ArrayList<>();
    }
    public void aufgabeHinzufuegen(Aufgabe aufgabe){
        this.bibliothek.add(aufgabe);
    }
    public void aufgabeErledigt(Aufgabe aufgabe){
        this.bibliothek.remove(aufgabe);
    }

    public void aufgabenAusgeben(){
        for(Aufgabe aufgabe : this.bibliothek){
            aufgabe.anzeigen();
        }
    }

    public ArrayList<AufgabeMitDeadline> gibDeadlines() {
        ArrayList<AufgabeMitDeadline> deadlineListe = new ArrayList<>();
        for(Aufgabe aufgabe : bibliothek){
            if(aufgabe instanceof AufgabeMitDeadline){
                deadlineListe.add((AufgabeMitDeadline)aufgabe);
            }
        }
        return deadlineListe;
    }

    public ArrayList<Aufgabe> alleAufgaben(){
        ArrayList<Aufgabe> allaufg = new ArrayList<>();
        for(Aufgabe aufgabe : this.bibliothek){
            allaufg.add(aufgabe);
        }

        return allaufg;
    }

}
