package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Farm {
    private int id;
    private String name;
    private Vector<Field> fields;
    private Vector<Builidng> buildings;
    private List<Animal> animals;
    private Map<String, Beehive> beehives;

    public Farm() {
        this.id = -1;
        this.name = "";
        this.fields = new Vector<>();
        this.buildings = new Vector<>();
        this.animals = new Vector<>();
        this.beehives = new HashMap<String, Beehive>();
    }

    public Farm(int id, String name, Vector<Field> fields, Vector<Builidng> buildings, List<Animal> animals, Map<String, Beehive> beehives) {
        this.id = id;
        this.name = name;
        this.fields = fields;
        this.buildings = buildings;
        this.animals = animals;
        this.beehives = beehives;
    }

    public String getName() {
        return name;
    }

    public Map<String, Beehive> getBeehives() {
        return beehives;
    }

    public void setBeehives(Map<String, Beehive> beehives) {
        this.beehives = beehives;
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
