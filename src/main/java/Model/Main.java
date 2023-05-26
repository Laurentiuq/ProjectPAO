package Model;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import Services.CowService;
import Services.FarmService;
import Services.Service;

public class Main {
    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Cow c1 = new Cow("C1", "Bos taurus", 100, 10, "Healthy", Size.Small, "Belgian Blue", "G",  1023);
        // Sheep takes a Date as a final argument
        Sheep s1 = new Sheep("S1", "Ovis aries", 49, 10, "Leg injury", "Blue Faced Leicester", "O", 50111, df.parse("19-8-2022"));
        Chicken ch1 = new Chicken("Ch1", "Gallus gallus domesticus", 20, 2, "Healthy", true, 9888);
        // In contrast to sheep beehive takes the Date parameter as a String and transfrom it in Date inside the constructor
        Beehive b1 = new Beehive("B1",2, true, df.parse("10-08-2022"), 10);

        // Has all details of the farm
        Service service = new Service();
        service.Menu();


    }


}