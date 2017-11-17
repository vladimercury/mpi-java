package com.jacobi.model.immutable;

import com.jacobi.model.Vector;

public class ImmutableMatrix {
    protected double[][] data;
    private int colsNumber;

    public ImmutableMatrix(int rows, int cols){
        this.data = new double[rows][cols];
        this.colsNumber = cols;
    }

    public ImmutableMatrix(ImmutableMatrix matrix) {
        this.data = matrix.data.clone();
        this.colsNumber = matrix.colsNumber;
    }

    public int getRowsNumber() {
        return this.data.length;
    }

    public int getColsNumber() {
        return colsNumber;
    }

    public double getCell(int row, int col) {
        return this.data[row][col];
    }

    public ImmutableVector getRow(int row) {
        return new ImmutableVector(this.data[row]);
    }

    public ImmutableVector getCol(int col) {
        Vector vector = new Vector(this.getRowsNumber());
        for (int row = 0; row < vector.getLength(); row++) {
            vector.setCell(row, this.data[row][col]);
        }
        return vector.toImmutable();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int rows = this.getRowsNumber();
        for (int index = 0; index < rows; index++) {
            builder.append(this.getRow(index).toString());
            if (index < rows - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
