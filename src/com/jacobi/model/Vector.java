package com.jacobi.model;

import com.jacobi.model.immutable.ImmutableVector;

public class Vector extends ImmutableVector {
    public Vector(int length) {
        super(length);
    }

    public Vector(double[] data) {
        super(data);
    }

    public Vector(ImmutableVector vector) {
        super(vector);
    }

    public ImmutableVector toImmutable() {
        return new ImmutableVector(this);
    }

    public void setCell(int index, double value){
        this.data[index] = value;
    }
}
