package com.jacobi.model;

public class LinearSystem {
    private Matrix coefficientMatrix;
    private Vector termsVector;

    public LinearSystem(Matrix systemCoefficients, Vector constantTerms)
            throws IllegalArgumentException{
        if (systemCoefficients.getRowsNumber() != constantTerms.getLength()) {
            throw new IllegalArgumentException("Vector size doesn't fit matrix size");
        }
        if (systemCoefficients.getRowsNumber() != systemCoefficients.getColsNumber()) {
            throw new IllegalArgumentException("Matrix is not square");
        }
        this.coefficientMatrix = systemCoefficients;
        this.termsVector = constantTerms;
    }

    public Matrix getCoefficientMatrix() {
        return coefficientMatrix;
    }

    public Vector getTermsVector() {
        return termsVector;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < coefficientMatrix.getRowsNumber(); row++) {
            builder.append(coefficientMatrix.getRow(row).toString()).append("[")
                    .append(termsVector.get(row)).append("]");
            if (row < coefficientMatrix.getRowsNumber() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
