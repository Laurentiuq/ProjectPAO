package Services;

import Model.Animal;
import Model.Cow;
import Model.Size;

import java.sql.Connection;
import java.util.Scanner;

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
        // it is a belgian blue cow then the food needed is increased by 1
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

    public Cow readAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Species: ");
        String species = scanner.nextLine();
        System.out.println("Weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Health: (mentions)");
        String health = scanner.nextLine();
        System.out.println("Size: (Small, Medium, Large)");
        String size = scanner.nextLine();
        System.out.println("Subspecies: ");
        String subspecies = scanner.nextLine();
        System.out.println("Letter identifier: ");
        String letterIdentifier = scanner.nextLine();
        System.out.println("Unique number identifier: (>= 1000 <= 9999)");
        int uniqueNumberIdentifier = scanner.nextInt();
        scanner.nextLine();
        Cow cow = new Cow(name, species, weight, age, health, Size.valueOf(size), subspecies, letterIdentifier, uniqueNumberIdentifier);
        System.out.println(cow.toString());
        return cow;
    }

}
