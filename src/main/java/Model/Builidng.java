package Model;

abstract class Builidng {
    protected String identifier;
    protected int size;

    public Builidng() {
    }

    public Builidng(String identifier, int size) {
        this.identifier = identifier;
        this.size = size;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Builidng{" +
                "identifier='" + identifier + '\'' +
                ", size=" + size +
                '}';
    }
}
