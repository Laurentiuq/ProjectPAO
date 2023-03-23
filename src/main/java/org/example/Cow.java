package org.example;


enum Size {
    Small,
    Medium,
    Large,
}

public class Cow extends Animal {
    Size size;
    private int age;
    private final String subspecies;
    private final String letterIdentifier;
    private final int uniqueNumberIdentifier;
    private final String earTag;

    public Cow() {
        age = 0;
        size = Size.Small;
        subspecies = "";
        uniqueNumberIdentifier = 0;
        letterIdentifier = "A";
        earTag = "";
    }

    public Cow(Size size, String subspecies, String letterIdentifier, int uniqueNumberIdentifier, int age) {
        this.age = age;
        this.size = size;
        this.subspecies = subspecies;
        this.letterIdentifier = letterIdentifier;
        if (!(uniqueNumberIdentifier < 1000 || uniqueNumberIdentifier > 9999)) {
            this.uniqueNumberIdentifier = uniqueNumberIdentifier;
        }
        else{
            throw new IllegalArgumentException("The unique number identifier should have 4 characters");
        }
        this.earTag = letterIdentifier + Integer.toString(uniqueNumberIdentifier);
    }

    public String getSubspecies(){
        return subspecies;
    }
    public int getUniqueNumberIdentifier(){
        return uniqueNumberIdentifier;
    }
    public String getLetterIdentifier(){
        return letterIdentifier;
    }
    public String getEarTag(){
        return earTag;
    }
    public int getAge(){
        return age;
    }

    public void setSize(Size size){
        this.size = size;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "size=" + size +
                ", age=" + age +
                ", subspecies='" + subspecies + '\'' +
                ", earTag='" + earTag + '\'' +
                '}';
    }
}
