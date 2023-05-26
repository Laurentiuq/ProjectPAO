package Services;

import Model.Animal;

public interface FarmInterface {
    public void findAnimal(String identifier); //DONE
    public void addAnimal(Animal animal); //DONE

    // harvest a crop from a field
    public void harvestCrop();//TODO

    // get expected harvest from all fields
    public double getTotalHarvest();//TODO


    // cat timp ajunge mancarea aflata in depozite
    public int getFoodCapacity();//TODO

    // calculeaza cantiatea de mancare care sta la dispozitie in importanta calorica
    public double getDepositedCaloricCapacity();//TODO

    // toata cantitatea de miere din stupi in functie de numarul de etaje si de existenta separatorului
    public double getAllHoney();//TODO

    // cat valoreaza toate animalele din ferma + stupii
    public void computeTotalValue();//TODO

}
