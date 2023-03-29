package Model;

import java.util.List;
import java.util.Vector;

public class Farm {
    private String name;
    private Vector<Field> fields;
    private Vector<Builidng> buildings;

    private List<Animal> animals;

    public Farm() {
        this.name = "Farm";
        this.fields = new Vector<Field>();
        this.buildings = new Vector<Builidng>();
        this.animals = new Vector<Animal>();
    }
    public Farm(String name, Vector<Field> fields, Vector<Builidng> buildings, List<Animal> animals) {
        this.name = name;
        this.fields = fields;
        this.buildings = buildings;
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Field> getFields() {
        return fields;
    }

    public void setFields(Vector<Field> fields) {
        this.fields = fields;
    }

    public Vector<Builidng> getBuildings() {
        return buildings;
    }

    public void setBuildings(Vector<Builidng> buildings) {
        this.buildings = buildings;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "name='" + name + '\'' +
                ", fields=" + fields +
                ", buildings=" + buildings +
                '}';
    }
}
