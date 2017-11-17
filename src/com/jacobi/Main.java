package com.jacobi;

import com.jacobi.io.LinearSystemReader;
import com.jacobi.model.LinearSystem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            LinearSystemReader reader = new LinearSystemReader("data/A10.txt");
            LinearSystem system = reader.readSystem();
            System.out.println(system);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
