package org.example;

abstract class Animal {
    // popular name for the animal
    protected String name;
    // scientific term of the animal
    protected String species;
    // total number of animals alive
    protected double weight;
    protected int age;
    // general information about the animal's health, any recent diseases, etc.
    protected String healthStatus;
    static int totalNumber;

    static{
        totalNumber = 0;
    }
    protected Animal(){
        this.name = "";
        this.species = "";
        this.weight = 0;
        this.age = 0;
        this.healthStatus = "";
        totalNumber += 1;
    }
    protected Animal(String name, String species, double weight, int age, String healthStatus) {
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.age = age;
        this.healthStatus = healthStatus;
        totalNumber += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public static int getTotalNumber() {
        return totalNumber;
    }

    public static void setTotalNumber(int totalNumber) {
        Animal.totalNumber = totalNumber;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", healthStatus='" + healthStatus + '\'' +
                '}';
    }
    @Override
    protected void finalize(){
        totalNumber -= 1;
    }

}
