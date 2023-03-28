package Model;

import java.util.Date;

public class Sheep extends Animal{
    private String woolBreed;
    private String letterIdentifier;
    private int uniqueNumberIdentifier;
    private String earTag;
    private Date lastShearing;

    public Sheep() {
        this.woolBreed = "";
        this.letterIdentifier = "A";
        this.uniqueNumberIdentifier = 0;
        this.earTag = "";
        this.lastShearing = Date.from(java.time.Instant.now());
    }

    public Sheep(String name, String species, double weight, int age, String healthStatus, String woolBreed, String letterIdentifier, int uniqueNumberIdentifier, String earTag, Date lastShearing) {
        super(name, species, weight, age, healthStatus);
        this.woolBreed = woolBreed;
        this.letterIdentifier = letterIdentifier;
        this.uniqueNumberIdentifier = uniqueNumberIdentifier;
        this.earTag = earTag;
        this.lastShearing = lastShearing;
    }

    public Sheep(String name, String species, double weight, int age, String healthStatus, String woolBreed, String letterIdentifier, int uniqueNumberIdentifier, Date lastShearing) {
        super(name, species, weight, age, healthStatus);
        this.woolBreed = woolBreed;
        this.letterIdentifier = letterIdentifier;
        // the difference between cow and sheep is that sheep has 5 digits for the unique number identifier
        if (!(uniqueNumberIdentifier < 10000 || uniqueNumberIdentifier > 99999)) {
            this.uniqueNumberIdentifier = uniqueNumberIdentifier;
        }
        else{
            throw new IllegalArgumentException("The unique number identifier should have 5 characters");
        }
        this.earTag = letterIdentifier + Integer.toString(uniqueNumberIdentifier);
        this.lastShearing = lastShearing;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "woolBreed='" + woolBreed + '\'' +
                ", letterIdentifier='" + letterIdentifier + '\'' +
                ", uniqueNumberIdentifier=" + uniqueNumberIdentifier +
                ", earTag='" + earTag + '\'' +
                ", lastShearing=" + lastShearing +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", healthStatus='" + healthStatus + '\'' +
                '}';
    }
}
