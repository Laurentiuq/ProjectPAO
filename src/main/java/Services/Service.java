package Services;

import Model.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

public class Service {
    public CowService cowService = new CowService();
    public FarmService farmService = new FarmService();
    public void Menu() throws ParseException {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an option: ");
            System.out.println("0. Exit");
            System.out.println("1. Get food needed for a cow");
            System.out.println("2. Add a new cow (*hardcoded*)");
            System.out.println("3. Add a new chicken (*hardcoded*)");
            System.out.println("4. Add a new sheep (*hardcoded*)");
            System.out.println("5. Delete an animal");
            System.out.println("6. Get the value of a cow");
            System.out.println("7. Add a new beehive (*user data*)");
            System.out.println("8. Get the beehives in alphabetical order");
            System.out.println("9. Print all animals");
//            System.out.println("3. Delete a cow");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("You chose: " + choice);
            if (choice == 1) {
                System.out.println("Enter the animal's identifier: ");
                String id = scanner.nextLine();
                Animal animal = farmService.findAnimal(id);
                cowService.computeFoodNeeded(animal);
                System.out.println();
                System.out.println("Press enter to continue...");
                scanner.nextLine();
            }
            if (choice == 2) {
                Cow c1 = new Cow("C1", "Bos taurus", 100, 10, "Healthy", Size.Small, "Belgian Blue", "G", 1023);
                //TODO read the data from the user
                farmService.addAnimal(c1);
            }
            if (choice == 3) {
                Chicken ch1 = new Chicken("Ch1", "Gallus gallus domesticus", 20, 2, "Healthy", true, 9888);
                //TODO read the data from the user
                farmService.addAnimal(ch1);
            }
            if (choice == 4){
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Sheep s = new Sheep("S1", "Ovis aries", 49, 10, "Leg injury", "Blue Faced Leicester", "O", 50111, df.parse("19-8-2022"));
                //TODO read the data from the user
                farmService.addAnimal(s);
            }
            if (choice == 5) {
                System.out.println("Enter the animal's identifier: ");
                String id = scanner.nextLine();
                farmService.removeAnimal(id);
            }
            if (choice == 6) {
                System.out.println("Enter the cow's identifier: ");
                String id = scanner.nextLine();
                Animal animal = farmService.findAnimal(id);
                System.out.println("The value of the animal is: " + cowService.computeValue(animal));
            }
            if (choice == 7) {
                System.out.println("Enter the beehive's identifier: ");
                String id = scanner.nextLine();
                System.out.println("Enter the number of supers: ");
                int nrSupers = scanner.nextInt();
                System.out.println("Does it has a queen excluder: ");
                boolean queenExcluder = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("Enter the date of the last extraction (dd-MM-yyyy): ");
                String date = scanner.nextLine();
                System.out.println("Enter the last extraction quantity of honey: ");
//                scanner.nextLine();
                double extractionQunaity = scanner.nextDouble();
                Beehive b = new Beehive(id, nrSupers, queenExcluder, date, extractionQunaity);
                farmService.addBeehive(b);
            }
            if (choice == 8) {
                farmService.sortBeehives();
                System.out.println();
                System.out.println("Press enter to continue...");
                scanner.nextLine();
            }
            // output all the animals
            if (choice == 9) {
//                for (Animal animal : farmService.getFarm().getAnimals()) {
//                    System.out.println(animal);
//                }
                farmService.printAnimals();
                System.out.println();
                System.out.println("Press enter to continue...");
                scanner.nextLine();
            }
            else if (choice == 0){
                break;
            }
        }
    }
}
