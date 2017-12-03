package com.jacobi.model;

public class Matrix {
    private double[][] data;
    private int colsNumber;

    public Matrix(int rows, int cols){
        this.data = new double[rows][cols];
        this.colsNumber = cols;
    }

    public Matrix(Matrix matrix) {
        this.data = matrix.data.clone();
        this.colsNumber = matrix.colsNumber;
    }

    public int getRowsNumber() {
        return this.data.length;
    }

    public int getColsNumber() {
        return colsNumber;
    }

    public double get(int row, int col) {
        return this.data[row][col];
    }

    public void set(int row, int col, double value) {
        this.data[row][col] = value;
    }

    public Vector getRow(int row) {
        return new Vector(this.data[row]);
    }

    public Vector getCol(int col) {
        Vector vector = new Vector(this.getRowsNumber());
        for (int row = 0; row < vector.getLength(); row++) {
            vector.set(row, this.data[row][col]);
        }
        return vector;
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
