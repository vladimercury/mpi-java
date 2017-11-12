package com.jacobi;

public class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.data = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public double getCell(int row, int col) {
        return this.data[row][col];
    }

    public void setCell(double value, int row, int col) {
        this.data[row][col] = value;
    }
}
