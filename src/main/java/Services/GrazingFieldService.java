package Services;
import Model.GrazingField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GrazingFieldService {
    GrazingField readGrazingField() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Size: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Fertility: ");
        double fertility = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Last Grazing Date: ");
        String lastGrazingDateString = scanner.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date lastGrazingDate = df.parse(lastGrazingDateString);
        return new GrazingField(name, size, type, fertility, lastGrazingDate);
    }
    void updateGrazingField(GrazingField grazingField) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: " + grazingField.getName());
        System.out.println("New name: ");
        String name = scanner.nextLine();
        if (!name.equals("")) {
            grazingField.setName(name);
        }
        System.out.println("Size: " + grazingField.getSize());
        System.out.println("New size: ");
        String sizeString = scanner.nextLine();
        if (!sizeString.equals("")) {
            int size = Integer.parseInt(sizeString);
            grazingField.setSize(size);
        }
        System.out.println("Type: " + grazingField.getType());
        System.out.println("New type: ");
        String typeString = scanner.nextLine();
        if (!typeString.equals("")) {
            int type = Integer.parseInt(typeString);
            grazingField.setType(type);
        }
        System.out.println("Fertility: " + grazingField.getFertility());
        System.out.println("New fertility: ");
        String fertilityString = scanner.nextLine();
        if (!fertilityString.equals("")) {
            double fertility = Double.parseDouble(fertilityString);
            grazingField.setFertility(fertility);
        }
        System.out.println("Last Grazing Date: " + grazingField.getLastGrazingDate());
        System.out.println("New last grazing date: ");
        String lastGrazingDateString = scanner.nextLine();
        if (!lastGrazingDateString.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date lastGrazingDate = df.parse(lastGrazingDateString);
            grazingField.setLastGrazingDate(lastGrazingDate);
        }


    }

}
