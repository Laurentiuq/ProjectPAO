package Services;

import Model.Beehive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BeehiveService {

    public Beehive readBeehive() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Identifier: ");
        String identifier = scanner.nextLine();
        System.out.println("Number of supers: ");
        int numberOfSupers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Queen excluder: ");
        boolean queenExcluder = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Last extraction date: (dd-MM-yyyy)");
        String lastExtractionDateString = scanner.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date lastExtractionDate = df.parse(lastExtractionDateString);
        System.out.println(lastExtractionDate);
        System.out.println("Last extraction quantity: ");
        double lastExtractionQuantity = scanner.nextDouble();
        scanner.nextLine();
        return new Beehive(identifier, numberOfSupers, queenExcluder, lastExtractionDate, lastExtractionQuantity);
    }
}
