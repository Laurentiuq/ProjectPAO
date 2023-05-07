package Services;

import Model.Chicken;
import Model.Animal;

import java.util.Scanner;

public class ChickenService implements AnimalInterface{

    @Override
    public void computeFoodNeeded(Animal animal) {
        System.out.println("This is a chicken service");
        double foodMultiplier = 0;
        double foodNeeded = 0;
        Chicken chicken = (Chicken) animal;
        foodMultiplier += 0.5;
        if (chicken.getAge() > 1){
            foodMultiplier += 0.5;
        }
        if(chicken.isEggProducer()){
            foodMultiplier += 0.5;
        }
        foodNeeded = chicken.getWeight() * foodMultiplier;
        System.out.println(foodNeeded + " calories needed for " + chicken.getRingCode());
    };

    @Override
    public double computeValue(Animal animal) {
        System.out.println("This is a chicken service");
        double valueMultiplier = 0;
        double value = 0;
        Chicken chicken = (Chicken) animal;
        valueMultiplier += 2;
        if (chicken.getAge() > 1){
            valueMultiplier += 1;
        }
        if(chicken.isEggProducer()){
            valueMultiplier += 1;
        }
        value = chicken.getWeight() * valueMultiplier;
        System.out.println(value + " value for " + chicken.getRingCode());
        return value;
    };

    @Override
public Chicken readAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Species: ");
        String species = scanner.nextLine();
        System.out.println("Weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Health status: ");
        String healthStatus = scanner.nextLine();
        System.out.println("Egg producer: ");
        boolean eggProducer = scanner.nextBoolean();
        System.out.println("Ring code: ");
        int ringCode = scanner.nextInt();
        scanner.nextLine();
        return new Chicken(name, species, weight, age, healthStatus, eggProducer, ringCode);
    };
}
