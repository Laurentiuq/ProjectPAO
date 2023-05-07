package Services;

import Model.Animal;
import Model.Sheep;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SheepService implements AnimalInterface{
    @Override
    public void computeFoodNeeded(Animal animal) {
        System.out.println("This is a sheep service");
        double foodMultiplier = 0;
        double foodNeeded = 0;
        Sheep sheep = (Sheep) animal;
        foodMultiplier += 0.5;
        if (animal.getAge() > 1){
            foodMultiplier += 0.5;
        }
        if(sheep.getWoolBreed().equalsIgnoreCase("merino")){
            foodMultiplier += 0.5;
        }
        foodNeeded = animal.getWeight() * foodMultiplier;
        System.out.println(foodNeeded + " calories needed for " + sheep.getEarTag());
    };
    @Override
    public double computeValue(Animal animal) {
        System.out.println("This is a sheep service");
        double valueMultiplier = 0;
        double value = 0;
        Sheep sheep = (Sheep) animal;
        valueMultiplier += 2;
        if (animal.getAge() > 1){
            valueMultiplier += 1;
        }
        if(sheep.getWoolBreed().equalsIgnoreCase("merino")){
            valueMultiplier += 1;
        }
        value = animal.getWeight() * valueMultiplier;
        System.out.println(value + " value for " + sheep.getEarTag());
        return value;
    };
    @Override
    public Sheep readAnimal() throws ParseException {
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
        System.out.println("Wool breed: ");
        String woolBreed = scanner.nextLine();
        System.out.println("Letter identifier: ");
        String letterIdentifier = scanner.nextLine();
        System.out.println("Unique number identifier: (10000<= x <= 99999)");
        int uniqueNumberIdentifier = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Last shearing: (dd/MM/yyyy)");
        String lastShearingString = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date lastShearing = formatter.parse(lastShearingString);
        return new Sheep(name, species, weight, age, healthStatus, woolBreed, letterIdentifier, uniqueNumberIdentifier, lastShearing);
    };
}
