package com.jacobi.model;

public class Vector {
    private double[] data;

    public Vector(int length) {
        this.data = new double[length];
    }

    public Vector(double[] data) {
        this.data = data.clone();
    }

    public Vector(Vector vector) {
        this.data = vector.data.clone();
    }

    public int getLength() {
        return data.length;
    }

    public double get(int index) {
        return data[index];
    }

    public void set(int index, double value){
        this.data[index] = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[ ");
        for (double cell: this.data) {
            builder.append(cell).append(" ");
        }
        return builder.append("]").toString();
    }

}
