package Model;

public class Deposit extends Builidng{
    private int capacity;
    private String depostiedCrop;
    private int depositedQuantity;

    public Deposit() {
    }

    public Deposit(String identifier, int size, int capacity, String depostiedCrop, int depositedQuantity) {
        super(identifier, size);
        this.capacity = capacity;
        this.depostiedCrop = depostiedCrop;
        this.depositedQuantity = depositedQuantity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepostiedCrop() {
        return depostiedCrop;
    }

    public void setDepostiedCrop(String depostiedCrop) {
        this.depostiedCrop = depostiedCrop;
    }

    public int getDepositedQuantity() {
        return depositedQuantity;
    }

    public void setDepositedQuantity(int depositedQuantity) {
        this.depositedQuantity = depositedQuantity;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "capacity=" + capacity +
                ", depostiedCrop='" + depostiedCrop + '\'' +
                ", depositedQuantity=" + depositedQuantity +
                ", identifier='" + identifier + '\'' +
                ", size=" + size +
                '}';
    }
}
