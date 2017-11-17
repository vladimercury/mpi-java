package com.jacobi.model.immutable;

public class ImmutableVector {
    protected double[] data;

    public ImmutableVector(int length) {
        this.data = new double[length];
    }

    public ImmutableVector(double[] data) {
        this.data = data.clone();
    }

    public ImmutableVector(ImmutableVector vector) {
        this.data = vector.data.clone();
    }

    public int getLength() {
        return data.length;
    }

    public double getCell(int index) {
        return data[index];
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
