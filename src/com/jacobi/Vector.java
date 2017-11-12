package com.jacobi;

public class Vector {
    private double[] data;
    private int length;

    public Vector(int length) {
        this.data = new double[length];
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public double getCell(int index) {
        return this.data[index];
    }

    public void setCell(double value, int index) {
        this.data[index] = value;
    }
}
