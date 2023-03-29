package Model;

import java.util.List;

public class Stable extends Builidng{
    private boolean mixed;
    private List<Animal> animals;

    public Stable() {
    }

    public Stable(String identifier, int size, boolean mixed, List<Animal> animals) {
        super(identifier, size);
        this.mixed = mixed;
        this.animals = animals;
    }

    public boolean isMixed() {
        return mixed;
    }

    public void setMixed(boolean mixed) {
        this.mixed = mixed;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Stable{" +
                "mixed=" + mixed +
                ", animals=" + animals +
                ", identifier='" + identifier + '\'' +
                ", size=" + size +
                '}';
    }
}
