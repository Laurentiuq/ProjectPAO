package Model;
import java.text.DateFormat;
// df.parse() can throw a ParseException so we need to import this to parse the exception
import java.text.ParseException;
// We need this to convert the string to a date, as I choose to give the date as a string in the constructor
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Instant;

public class Beehive {
    private int nrSupers;
    private boolean queenExcluder;
    private Date lastExtractionDate;
    private double lastExtractionQuantity;

    public Beehive() {
        this.nrSupers = 0;
        this.queenExcluder = false;
        this.lastExtractionDate = Date.from(java.time.Instant.now());
        this.lastExtractionQuantity = -1;
    }

    public Beehive(int nrSupers, boolean queenExcluder, String lastExtractionDate, double lastExtractionQuantity) throws ParseException {
        this.nrSupers = nrSupers;
        this.queenExcluder = queenExcluder;
        // We need this to convert the string to a date
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.lastExtractionDate = df.parse(lastExtractionDate);
        this.lastExtractionQuantity = lastExtractionQuantity;
    }

    public int getNrSupers() {
        return nrSupers;
    }
    public void setNrSupers(int nrSupers) {
        this.nrSupers = nrSupers;
    }

    public boolean isQueenExcluder() {
        return queenExcluder;
    }
    public void setQueenExcluder(boolean queenExcluder) {
        this.queenExcluder = queenExcluder;
    }

    public Date getLastExtractionDate() {
        return lastExtractionDate;
    }
    public void setLastExtractionDate(Date lastExtractionDate) {
        this.lastExtractionDate = lastExtractionDate;
    }

    public double getLastExtractionQuantity() {
        return lastExtractionQuantity;
    }

    public void setLastExtractionQuantity(double lastExtractionQuantity){
        this.lastExtractionQuantity = lastExtractionQuantity;
    }

    @Override
    public String toString() {
        return "Beehive{" +
                "nrSupers=" + nrSupers +
                ", queenExcluder=" + queenExcluder +
                ", lastExtractionDate=" + lastExtractionDate +
                ", lastExtractionQuantity=" + lastExtractionQuantity +
                '}';
    }

}
