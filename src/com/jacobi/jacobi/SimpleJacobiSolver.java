package com.jacobi.jacobi;

import com.jacobi.model.LinearSystem;
import com.jacobi.model.Matrix;
import com.jacobi.model.Vector;

public class SimpleJacobiSolver implements JacobiSolver{
    private double epsilon;

    public SimpleJacobiSolver(double epsilon) throws IllegalArgumentException {
        this.setEpsilon(epsilon);
    }

    @Override
    public Vector solve(LinearSystem system, Vector estimation) throws IllegalArgumentException {
        Matrix matrix = system.getCoefficientMatrix();
        Vector terms = system.getTermsVector();
        if (estimation.getLength() != matrix.getColsNumber()) {
            throw new IllegalArgumentException("Estimation vector size doesn't fit matrix size");
        }
        Vector result = new Vector(estimation);
        Vector temp = new Vector(estimation.getLength());
        double norm;
        int size = matrix.getRowsNumber();

        do {
            for (int row = 0; row < size; row++) {
                temp.set(row, terms.get(row));
                for (int col = 0; col < size; col++) {
                    if (row != col) {
                        temp.set(row, temp.get(row) - matrix.get(row, col) * result.get(col));
                    }
                }
                temp.set(row, temp.get(row) / matrix.get(row, row));
            }
            norm = Math.abs(result.get(0) - temp.get(0));
            for (int index = 0; index < size; index++) {
                double delta = Math.abs(result.get(index) - temp.get(index));
                if (delta > norm) {
                    norm = delta;
                }
                result.set(index, temp.get(index));
            }
        } while (norm > this.epsilon);
        return result;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) throws IllegalArgumentException{
        if (epsilon <= 0.0) {
            throw new IllegalArgumentException("Epsilon should be positive");
        }
        this.epsilon = epsilon;
    }
}
