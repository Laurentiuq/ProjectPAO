package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Cow c1 = new Cow("Steluta", "vacus marcus", 100, 10, "Sanatoasa", Size.Small, "Belgian Blue", "G",  1023);
        // Sheep takes a Date as a final argument
        Sheep s1 = new Sheep("Steluta", "oaia s", 49, 10, "Sanatoasa", "melinos", "O", 50111, df.parse("19-8-2022"));
        Chicken ch1 = new Chicken("GG", "gaius", 20, 2, "Sanatoasa", true, 9888);
        // In contrast to sheep beehibe takes the Date parameter as a String and transfrom it in Date inside the constructor
        Beehive b1 = new Beehive(2, true, "10-08-2022", 10);
        System.out.println(c1);
        System.out.println(s1);
        System.out.println(ch1);


    }
}