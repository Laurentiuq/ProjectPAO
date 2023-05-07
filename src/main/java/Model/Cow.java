package Model;


public final class Cow extends Animal {
    Size size;
    private String subspecies;
    private String letterIdentifier;
    private int uniqueNumberIdentifier;
    private  String earTag;

    public Cow() {
        this.age = 0;
        this.size = Size.Small;
        this.subspecies = "";
        this.uniqueNumberIdentifier = 0;
        this.letterIdentifier = "A";
        this.earTag = "";
    }

    // we compute the earTag in the constructor because it is a combination of the letterIdentifier and the uniqueNumberIdentifier
    public Cow(String name, String species, double weight, int age, String healthStatus, Size size, String subspecies, String letterIdentifier, int uniqueNumberIdentifier) {
        super(name, species, weight, age, healthStatus);
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


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }
    public void setLetterIdentifier(String letterIdentifier) {
        this.letterIdentifier = letterIdentifier;
    }
    public String getSubspecies() {
        return subspecies;
    }

    public String getLetterIdentifier() {
        return letterIdentifier;
    }

    public int getUniqueNumberIdentifier() {
        return uniqueNumberIdentifier;
    }

    public String getEarTag() {
        return earTag;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", healthStatus='" + healthStatus + '\'' +
                ", size=" + size +
                ", subspecies='" + subspecies + '\'' +
                ", letterIdentifier='" + letterIdentifier + '\'' +
                ", uniqueNumberIdentifier=" + uniqueNumberIdentifier +
                ", earTag='" + earTag + '\'' +
                '}';
    }
}
