package org.example;

import static org.example.Size.Small;

public class Main {
    public static void main(String[] args) {
        Cow c1 = new Cow("Steluta", "vacus marcus", 100, 10, "Sanatoasa", Small, "Belgian Blue", "G",  1023);
        System.out.println(c1);
        int a = Integer.valueOf(10);
        int b = 10;
        System.out.println(Math.max(a, b));

    }
}