package Services;

import Model.*;

import java.awt.*;

import java.util.List;




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

    public void removeAnimal(String identifier){
        Animal animal = findAnimal(identifier);
        farm.getAnimals().remove(animal);
    }

    public void addBeehive(Beehive beehive){
//        Beehive beehive = new Beehive();
        farm.getBeehives().put(beehive.getIdentifier(), beehive);
    }

    public void sortBeehives(){
        System.out.println("------Beehives sorted by identifier--------");
        // transferam valorile din map in lista si sortam lista
        List<Beehive> beehives = new java.util.ArrayList<>(farm.getBeehives().values().stream().toList());
        beehives.sort((b1, b2) -> b1.getIdentifier().compareTo(b2.getIdentifier()));

        for (Beehive beehive : beehives) {
            System.out.println(beehive);
        }
        System.out.println("------Beehives sorted by identifier--------");
        System.out.println();
    }

    public void removeBeehive(String identifier){
        farm.getBeehives().remove(identifier);
    }

    // output all the animals in the farm
    public void printAnimals(){
        System.out.println("------Animals--------");
        for(Animal animal : farm.getAnimals()){
            System.out.println(animal);
        }
        System.out.println("------Animals--------");
        System.out.println();
    }

    public Farm getFarm() {
        return farm;
    }

}
