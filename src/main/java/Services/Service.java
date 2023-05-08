package Services;

import Model.*;
import Persistence.DBConnection;
import Persistence.Repos.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Service {
    Connection connection = DBConnection.getConnection();
    public CowService cowService = new CowService();
    public SheepService sheepService = new SheepService();
    public ChickenService chickenService = new ChickenService();
    public FarmService farmService = new FarmService();
    public BeehiveService beehiveService = new BeehiveService();
    public CropFieldService cropFieldService = new CropFieldService();
    public GrazingFieldService grazingFieldService = new GrazingFieldService();
    public CowRepository cowRepository = CowRepository.getInstance();
    public CropFieldRepository cropFieldRepository = CropFieldRepository.getInstance();
    GrazingFieldRepository grazingFieldRepository = GrazingFieldRepository.getInstance();


    public Service() throws SQLException {
    }

    public void Menu() throws ParseException, SQLException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an option: ");
            System.out.println("0. Exit");
            System.out.println("1. Do operations on a Crop field");
            System.out.println("2. Do operations on a cow");
            System.out.println("3. Do operations on a chicken");
            System.out.println("4. Do operations on a sheep");
            System.out.println("5. Do operations on a Grazing field");
            System.out.println("6. Get the value of a cow");
            System.out.println("7. Do operations on a beehive");
            System.out.println("8. Get the beehives in alphabetical order");
            System.out.println("9. Print all animals");
//            System.out.println("3. Delete a cow");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("You chose: " + choice);
            // operations on fields
            if (choice == 1) {
                while(true){
                    System.out.println("    --0. Exit");
                    System.out.println("    --1. Add a new field");
                    System.out.println("    --2. Find a field");
                    System.out.println("    --3. Delete a field");
                    System.out.println("    --4. Find all fields");
                    System.out.println("    --5. Update a field");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2){
                        case 1:
                            // add a new field
                            CropField cropField = cropFieldService.readCropField();
                            cropFieldRepository.save(cropField);
                            break;
                            // find a field
                        case 2:
                            System.out.println("Enter the field's identifier: ");
                            String id = scanner.nextLine();
                            if(cropFieldRepository.findById(id).isPresent()){
                                CropField cropField1 = cropFieldRepository.findById(id).get();
                                System.out.println(cropField1);
                            }
                            else{
                                System.out.println("Field not found");
                            }
                            break;
                        case 3:
                            // delete a field
                            System.out.println("Enter the field's identifier: ");
                            id = scanner.nextLine();
                            if(cropFieldRepository.findById(id).isPresent()){
                                CropField cropField1 = cropFieldRepository.findById(id).get();
                                cropFieldRepository.delete(cropField1);
                            }
                            else{
                                System.out.println("Field not found");
                            }
                            break;
                        case 4:
                            cropFieldRepository.findAll().forEach(System.out::println);
                            break;
                        case 5:
                            // update a field
                            System.out.println("Enter the field's identifier: ");
                            id = scanner.nextLine();
                            if(cropFieldRepository.findById(id).isPresent()){
                                CropField cropField1 = cropFieldRepository.findById(id).get();
                                cropFieldService.updateCropField(cropField1);
                                cropFieldRepository.update(cropField1);
                            }
                            else{
                                System.out.println("Field not found");
                            }
                            break;

                    }
                    if (choice2 == 0) {
                        break;
                    }
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                }
            }
            // add a new cow
            if (choice == 2) {
                while (true) {
                    System.out.println("    --0. Exit");
                    System.out.println("    --1. Add a new cow");
                    System.out.println("    --2. Find a cow");
                    System.out.println("    --3. Delete a cow");
                    System.out.println("    --4. Find all cows");
                    System.out.println("    --5. Get food needed for a cow");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2) {
                        case 1:
                            // add a new cow
                            Cow cow = cowService.readAnimal();
                            farmService.addAnimal(cow);
                            cowRepository.save(cow);
                            break;
                        case 2:
                            // find a cow
                            System.out.println("Enter the cow's identifier: ");
                            String id = scanner.nextLine();
                            if (cowRepository.findById(id).isPresent()) {
                                Cow cow1 = cowRepository.findById(id).get();
                                System.out.println(cow1);
                            } else {
                                System.out.println("Cow not found");
                            }
                            break;
                        case 3:
                            // delete a cow
                            System.out.println("Enter the cow's identifier: ");
                            id = scanner.nextLine();
                            farmService.removeAnimal(id);
                            if (cowRepository.findById(id).isPresent()) {
                                Cow cow1 = cowRepository.findById(id).get();
                                cowRepository.delete(cow1);
                            } else {
                                System.out.println("Cow not found");
                            }
                            break;
                        case 4:
                            cowRepository.findAll().forEach(System.out::println);
                            break;
                        case 5:
                            System.out.println("Enter the cow's identifier: ");
                            id = scanner.nextLine();
                            Animal animal = cowRepository.findById(id).get();
                            cowService.computeFoodNeeded(animal);
                            break;

                    }
                    if (choice2 == 0) {
                        break;
                    }
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                }
                // add the cow to the database
//                farmService.addAnimalToDB(cow);


            }
            // add a new chicken
            if (choice == 3) {
//                Chicken ch1 = new Chicken("Ch1", "Gallus gallus domesticus", 20, 2, "Healthy", true, 9888);
                ChickenRepository chickenRepository = ChickenRepository.getInstance();
                while(true){
                    System.out.println("    --1. Add a new chicken");
                    System.out.println("    --2. Find a chicken");
                    System.out.println("    --3. Delete a chicken");
                    System.out.println("    --4. Find all chickens");
                    System.out.println("    --5. Exit");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2) {
                        case 1:
                            Chicken chicken = chickenService.readAnimal();
                            farmService.addAnimal(chicken);
                            chickenRepository.save(chicken);
                            break;
                        case 2:
                            System.out.println("Enter the chicken's identifier: ");
                            String id = scanner.nextLine();
                            if (chickenRepository.findById(id).isPresent()) {
                                Chicken chicken1 = chickenRepository.findById(id).get();
                                System.out.println(chicken1);
                            } else {
                                System.out.println("Chicken not found");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the chicken's identifier: ");
                            id = scanner.nextLine();
                            farmService.removeAnimal(id);
                            if (chickenRepository.findById(id).isPresent()) {
                                Chicken chicken1 = chickenRepository.findById(id).get();
                                chickenRepository.delete(chicken1);
                            } else {
                                System.out.println("Chicken not found");
                            }
                            break;
                        case 4:
                            chickenRepository.findAll().forEach(System.out::println);
                            break;
                    }
                    if(choice2 == 5){
                        break;
                    }
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                }

            }
            // add a new sheep
            if (choice == 4) {
//                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//                Sheep s = new Sheep("S1", "Ovis aries", 49, 10, "Leg injury", "Blue Faced Leicester", "O", 50111, df.parse("19-8-2022"));
                SheepRepository sheepRepository = SheepRepository.getInstance();
                while (true) {
                    System.out.println("    --0. Exit");
                    System.out.println("    --1. Add a new sheep");
                    System.out.println("    --2. Find a sheep");
                    System.out.println("    --3. Delete a sheep");
                    System.out.println("    --4. Find all sheep");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2) {
                        case 1:
                            Sheep sheep = sheepService.readAnimal();
                            farmService.addAnimal(sheep);
                            sheepRepository.save(sheep);
                            break;
                        case 2:
                            System.out.println("Enter the sheep's identifier: ");
                            String id = scanner.nextLine();
                            if (sheepRepository.findById(id).isPresent()) {
                                Sheep sheep1 = sheepRepository.findById(id).get();
                                System.out.println(sheep1);
                            } else {
                                System.out.println("Sheep not found");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the sheep's identifier: ");
                            id = scanner.nextLine();
                            farmService.removeAnimal(id);
                            if (sheepRepository.findById(id).isPresent()) {
                                Sheep sheep1 = sheepRepository.findById(id).get();
                                sheepRepository.delete(sheep1);
                            } else {
                                System.out.println("Sheep not found");
                            }
                            break;
                        case 4:
                            sheepRepository.findAll().forEach(System.out::println);
                            break;
                    }
                    if (choice2 == 0) {
                        break;
                    }
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                }

            }
            // do operations on a grazing field
            if (choice == 5) {
                while (true) {
                    System.out.println("    --0. Exit");
                    System.out.println("    --1. Add a new grazing field");
                    System.out.println("    --2. Find a grazing field");
                    System.out.println("    --3. Delete a grazing field");
                    System.out.println("    --4. Find all grazing fields");
                    System.out.println("    --5. Update a grazing field");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2) {
                        case 1:
                            GrazingField grazingField = grazingFieldService.readGrazingField();
                            grazingFieldRepository.save(grazingField);
                            break;
                        case 2:
                            System.out.println("Enter the grazing field's identifier: ");
                            String id = scanner.nextLine();
                            if (grazingFieldRepository.findById(id).isPresent()) {
                                GrazingField grazingField1 = grazingFieldRepository.findById(id).get();
                                System.out.println(grazingField1);
                            } else {
                                System.out.println("Grazing field not found");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the grazing field's identifier: ");
                            id = scanner.nextLine();
                            if (grazingFieldRepository.findById(id).isPresent()) {
                                GrazingField grazingField1 = grazingFieldRepository.findById(id).get();
                                grazingFieldRepository.delete(grazingField1);
                            } else {
                                System.out.println("Grazing field not found");
                            }
                            break;
                        case 4:
                            grazingFieldRepository.findAll().forEach(System.out::println);
                            break;
                        case 5:
                            System.out.println("Enter the grazing field's identifier: ");
                            id = scanner.nextLine();
                            if (grazingFieldRepository.findById(id).isPresent()) {
                                GrazingField grazingField1 = grazingFieldRepository.findById(id).get();
                                grazingFieldService.updateGrazingField(grazingField1);
                                grazingFieldRepository.update(grazingField1);
                            } else {
                                System.out.println("Grazing field not found");
                            }
                            break;
                    }
                    if (choice2 == 0) {
                        break;
                    }
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                }

            }
            // get the value of a cow
            if (choice == 6) {
                System.out.println("Enter the cow's identifier: ");
                String id = scanner.nextLine();
                Animal animal = farmService.findAnimal(id);
                System.out.println("The value of the animal is: " + cowService.computeValue(animal));
                System.out.println();
                System.out.println("Press enter to continue...");
                scanner.nextLine();
            }
            // add a new beehive
            if (choice == 7) {
                BeehiveRepository beehiveRepository = BeehiveRepository.getInstance();
                while (true){
                    System.out.println("    --1. Add a new beehive");
                    System.out.println("    --2. Find a beehive");
                    System.out.println("    --3. Delete a beehive");
                    System.out.println("    --4. Find all beehives");
                    System.out.println("    --5. Exit");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2) {
                        case 1:
                            Beehive beehive = beehiveService.readBeehive();
                            farmService.addBeehive(beehive);
                            beehiveRepository.save(beehive);
                            break;
                        case 2:
                            System.out.println("Enter the beehive's identifier: ");
                            String id = scanner.nextLine();
                            if (beehiveRepository.findById(id).isPresent()) {
                                Beehive beehive1 = beehiveRepository.findById(id).get();
                                System.out.println(beehive1);
                            } else {
                                System.out.println("Beehive not found");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the beehive's identifier: ");
                            id = scanner.nextLine();
                            farmService.removeBeehive(id);
                            if (beehiveRepository.findById(id).isPresent()) {
                                Beehive beehive1 = beehiveRepository.findById(id).get();
                                beehiveRepository.delete(beehive1);
                            } else {
                                System.out.println("Beehive not found");
                            }
                            break;
                        case 4:
                            beehiveRepository.findAll().forEach(System.out::println);
                            break;
                    }
                    if(choice2 == 5){
                        break;
                    }
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                }

            }
            // get the beehives in alphabetical order
            if (choice == 8) {
                farmService.sortBeehives();
                System.out.println();
                System.out.println("Press enter to continue...");
                scanner.nextLine();
            }
            // output all the animals
            if (choice == 9) {
                farmService.printAnimals();
                System.out.println();
                System.out.println("Press enter to continue...");
                scanner.nextLine();
            } else if (choice == 0) {
                break;
            }
        }
    }
}
