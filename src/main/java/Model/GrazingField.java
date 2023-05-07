package Model;

import java.util.Date;

public class GrazingField extends Field{
    private double fertility;
    private Date lastGrazingDate;

    public GrazingField() {
    }

    public GrazingField(int id, String name, int size, int type, double fertility, Date lastGrazingDate) {
        super(id, name, size, type);
        this.fertility = fertility;
        this.lastGrazingDate = lastGrazingDate;
    }

    public double getFertility() {
        return fertility;
    }

    public void setFertility(double fertility) {
        this.fertility = fertility;
    }

    public Date getLastGrazingDate() {
        return lastGrazingDate;
    }

    public void setLastGrazingDate(Date lastGrazingDate) {
        this.lastGrazingDate = lastGrazingDate;
    }

    @Override
    public String toString() {
        return "GrazingField{" +
                "fertility=" + fertility +
                ", lastGrazingDate=" + lastGrazingDate +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}
