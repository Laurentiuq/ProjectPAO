package Model;

import Persistence.Repos.AnimalGrazingFieldRepository;

public class AnimalGrazingField {
    private String id;
    private String animalId;
    private int grazingFieldId;
    public AnimalGrazingField() {
    }
    public AnimalGrazingField(String id, String animalId, int grazingFieldId) {
        this.id = id;
        this.animalId = animalId;
        this.grazingFieldId = grazingFieldId;
    }

    public AnimalGrazingField(Sheep sheep1, GrazingField grazingField1) {
        this.animalId = sheep1.getEarTag();
        this.grazingFieldId = grazingField1.getId();
    }
    public AnimalGrazingField(Cow cow1, GrazingField grazingField1) {
        this.animalId = cow1.getEarTag();
        this.grazingFieldId = grazingField1.getId();
    }

    public String getAnimalId() {
        return animalId;
    }
    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }
    public int getGrazingFieldId() {
        return grazingFieldId;
    }
    public void setGrazingFieldId(int grazingFieldId) {
        this.grazingFieldId = grazingFieldId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
