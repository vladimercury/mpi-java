package com.jacobi;

import com.jacobi.io.JacobiIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String matrixFile;
        String estimationFile;
        try {
            matrixFile = args[0];
            estimationFile = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("CLI arguments not provided");
            return;
        }
        try {
            Matrix matrix = JacobiIO.readMatrix("data/" + matrixFile);
            Vector vector = JacobiIO.readVector("data/" + estimationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
