package Services;

import Model.Animal;
import Model.Cow;
import Model.Size;

import java.util.Random;
import java.util.Scanner;

public class Service {
    public CowService cowService = new CowService();
    public FarmService farmService = new FarmService();
    public void Menu(){
        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Get food needed for a cow");
            System.out.println("2. Add a new cow");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("You chose: " + choice);
            if (choice == 1) {
                System.out.println("Enter the animal's identifier: ");
                String id = scanner.nextLine();
                Animal animal = farmService.findAnimal(id);
                cowService.computeFoodNeeded(animal);
            }
            if (choice == 2) {
                Cow c1 = new Cow("C1", "Bos taurus", 100, 10, "Healthy", Size.Small, "Belgian Blue", "G", 1023);
                //TODO read the data from the user
                farmService.addAnimal(c1);
            }
            else
                break;
        }
    }
}
