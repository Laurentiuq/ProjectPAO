package Services;
import Model.CropField;
import Model.Crop;
import java.util.Scanner;
public class CropFieldService {
    CropField readCropField() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Size: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Irrigated: (true/false)");
        boolean irrigated = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Crop type: (Wheat, Barley, Oats, Rye, Corn, Beans, Beets)");
        String cropTypeString = scanner.nextLine();
        Crop cropType = Crop.valueOf(cropTypeString);
        //        System.out.println(cropField);
        return new CropField(name, size, type, irrigated, cropType);
    }
    void updateCropField(CropField cropField){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: " + cropField.getName());
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        if(!name.equals("")){
            cropField.setName(name);
        }
        System.out.println("Size: " + cropField.getSize());
        System.out.println("Enter new size: ");
        String sizeString = scanner.nextLine();
        if(!sizeString.equals("")){
            int size = Integer.parseInt(sizeString);
            cropField.setSize(size);
        }
        System.out.println("Type: " + cropField.getType());
        System.out.println("Enter new type: ");
        String typeString = scanner.nextLine();
        if(!typeString.equals("")){
            int type = Integer.parseInt(typeString);
            cropField.setType(type);
        }
        System.out.println("Irrigated: " + cropField.isIrrigated());
        System.out.println("Enter new irrigated: ");
        String irrigatedString = scanner.nextLine();
        if(!irrigatedString.equals("")){
            boolean irrigated = Boolean.parseBoolean(irrigatedString);
            cropField.setIrrigated(irrigated);
        }
        System.out.println("Crop type: " + cropField.getCropType());
        System.out.println("Enter new crop type: ");
        String cropTypeString = scanner.nextLine();
        if(!cropTypeString.equals("")){
            Crop cropType = Crop.valueOf(cropTypeString);
            cropField.setCropType(cropType);
        }
//        System.out.println(cropField);

    }

}
