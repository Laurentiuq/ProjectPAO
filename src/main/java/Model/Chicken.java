package Model;

public class Chicken extends Animal{
    private boolean eggProducer;
    private int ringCode;

    public Chicken() {
        this.eggProducer = true;
        this.ringCode = -1;
    }
    public Chicken(String name, String species, double weight, int age, String healthStatus, boolean eggProducer, int ringCode){
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.age = age;
        this.healthStatus = healthStatus;
        this.eggProducer = eggProducer;
        this.ringCode = ringCode;
    }

    public boolean isEggProducer() {
        return eggProducer;
    }

    public void setEggProducer(boolean eggProducer) {
        this.eggProducer = eggProducer;
    }

    public int getRingCode() {
        return ringCode;
    }

    public void setRingCode(int ringCode) {
        this.ringCode = ringCode;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "eggProducer=" + eggProducer +
                ", ringCode=" + ringCode +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", healthStatus='" + healthStatus + '\'' +
                '}';
    }
}
