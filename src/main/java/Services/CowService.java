package Services;

import Model.Animal;
import Model.Cow;
import Model.Size;

public class CowService implements AnimalInterface{
    public void computeFoodNeeded(Animal animal) {
        System.out.println("This is a cow service");
        double foodMultiplier = 0;
        double foodNeeded = 0;
        Cow cow = (Cow) animal;
        if(cow.getSize() == Size.Small){
            foodMultiplier += 0.5;
        }
        else if(cow.getSize() == Size.Medium){
            foodMultiplier += 1;
        }
        else if(cow.getSize() == Size.Large){
            foodMultiplier += 1.5;
        }
        if (cow.getSubspecies().equalsIgnoreCase("belgian blue")){
            foodMultiplier += 1;
        }
        foodNeeded = cow.getWeight() * foodMultiplier;
        System.out.println(foodNeeded + " calories needed for " + cow.getEarTag());
    }
    public double computeValue(Animal animal) {
        System.out.println("This is a cow service");
        double valueMultiplier = 0;
        double value = 0;
        Cow cow = (Cow) animal;
        if(cow.getSize() == Size.Small){
            valueMultiplier += 0.5;
        }
        else if(cow.getSize() == Size.Medium){
            valueMultiplier += 2;
        }
        else if(cow.getSize() == Size.Large){
            valueMultiplier += 2.5;
        }
        if (cow.getSubspecies().equalsIgnoreCase("belgian blue")){
            valueMultiplier += 3;
        }
        value = cow.getWeight() * valueMultiplier;
        return value;
    }
}
