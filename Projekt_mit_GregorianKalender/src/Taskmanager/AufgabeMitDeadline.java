package Taskmanager;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class AufgabeMitDeadline extends Aufgabe {
    private GregorianCalendar deadLine;

    public AufgabeMitDeadline(GregorianCalendar deadLine, String aufgabentext, GregorianCalendar datumErstellung){
        super(aufgabentext, datumErstellung);
        this.deadLine = deadLine;
    }

    public GregorianCalendar getDeadLine () {
        return deadLine;
    }

    public void setDeadLine ( GregorianCalendar deadLine ) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString () {
        SimpleDateFormat formatieren = new SimpleDateFormat();
        return "AufgabeMitDeadline{" +
                "deadLine='" + deadLine + '\'' +
                '}';
    }

    public void anzeigen(){
        super.anzeigen();
        SimpleDateFormat formati = new SimpleDateFormat();
        System.out.println("Deadline: " +formati.format(deadLine.getTime()));
    }
}
