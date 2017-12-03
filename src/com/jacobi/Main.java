package com.jacobi;

import com.jacobi.io.LinearSystemReader;
import com.jacobi.io.VectorReader;
import com.jacobi.jacobi.SimpleJacobiSolver;
import com.jacobi.model.LinearSystem;
import com.jacobi.model.Vector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            LinearSystemReader systemReader = new LinearSystemReader("data/A300.txt");
            VectorReader vectorReader = new VectorReader("data/B300.txt");
            LinearSystem system = systemReader.readSystem();
            Vector estimation = vectorReader.readVector();
            SimpleJacobiSolver solver = new SimpleJacobiSolver(1e-10);
            System.out.println(solver.solve(system, estimation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
