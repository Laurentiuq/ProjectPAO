package Services;

import Model.*;


// TODO implement the interface *FarmInterface*
public class FarmService {
    public Farm farm = new Farm();

    // Primeste un identificator ca string si cauta animalul in lista de animale
    // Pentru cow si sheep identifier este tot string
    // Pentru chicken trebuie sa convertim identifier la int
    // Facem un downcast la animal si verificam daca earTag sau ringCode sunt egale cu identifier
    public Animal findAnimal(String identifier){
        for(Animal animal : farm.getAnimals()){
            if(animal instanceof Cow){
                if(((Cow) animal).getEarTag().equals(identifier)){
                    return animal;
                }
            }
            else if(animal instanceof Sheep){
                if(((Sheep) animal).getEarTag().equals(identifier)){
                    return animal;
                }
            }
            else if(animal instanceof Chicken){
                if(((Chicken) animal).getRingCode() == Integer.parseInt(identifier)){
                    return animal;
                }
            }
        }
        return null;
    }
    public void addAnimal(Animal animal){
        farm.getAnimals().add(animal);
    }

    public Farm getFarm() {
        return farm;
    }

}
