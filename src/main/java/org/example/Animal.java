package org.example;

abstract class Animal {
    // popular name for the animal
    protected String name;
    // scientific term of the animal
    protected String species;
    static int totalNumber;

    protected Animal(){
        this.name = "";
        this.species = "";
    }
    protected Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSpecies(String species){
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

//    @Override
//    public String toString(){
//        return
//    }
}
