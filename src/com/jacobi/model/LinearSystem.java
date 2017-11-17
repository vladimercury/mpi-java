package com.jacobi.model;

import com.jacobi.model.immutable.ImmutableMatrix;
import com.jacobi.model.immutable.ImmutableVector;

public class LinearSystem {
    private ImmutableMatrix coefficientMatrix;
    private ImmutableVector termsVector;

    public LinearSystem(ImmutableMatrix systemCoefficients, ImmutableVector constantTerms)
            throws IllegalArgumentException{
        if (systemCoefficients.getRowsNumber() != constantTerms.getLength()) {
            throw new IllegalArgumentException("Vector size doesn't fit matrix size");
        }
        this.coefficientMatrix = systemCoefficients;
        this.termsVector = constantTerms;
    }

    public ImmutableMatrix getCoefficientMatrix() {
        return coefficientMatrix;
    }

    public ImmutableVector getTermsVector() {
        return termsVector;
    }

    /**
     * Checks if solution is suitable
     * @param solution vector with solution of linear system
     * @param maxError maximum computation error
     * @return true if given vector is a suitable solution of linear system
     * @throws IllegalArgumentException if vector length doesn't fit matrix columns number
     */
    public boolean isSuitableSolution(ImmutableVector solution, double maxError) throws IllegalArgumentException {
        if (solution.getLength() != coefficientMatrix.getColsNumber()) {
            throw new IllegalArgumentException("Vector size doesn't fit matrix size");
        }
        for (int row = 0; row < coefficientMatrix.getRowsNumber(); row++) {
            double rowResult = 0.0;
            for (int col = 0; col < coefficientMatrix.getColsNumber(); col++) {
                rowResult += coefficientMatrix.getCell(row, col) * solution.getCell(col);
            }
            if (Math.abs(rowResult - termsVector.getCell(row)) > Math.abs(maxError)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if solution is suitable
     * @param solution vector with solution of linear system
     * @return true if given vector is a suitable solution of linear system
     * @throws IllegalArgumentException if vector length doesn't fit matrix columns number
     */
    public boolean isSuitableSolution(ImmutableVector solution) throws IllegalArgumentException {
        return this.isSuitableSolution(solution, 1e-14);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < coefficientMatrix.getRowsNumber(); row++) {
            builder.append(coefficientMatrix.getRow(row).toString()).append("[")
                    .append(termsVector.getCell(row)).append("]");
            if (row < coefficientMatrix.getRowsNumber() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
