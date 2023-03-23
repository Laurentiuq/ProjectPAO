package org.example;

import static org.example.Size.Small;

public class Main {
    public static void main(String[] args) {
        Cow c1 = new Cow(Small, "Belgian Blue", "G", 1455, 10);
        System.out.println(c1);
    }
}