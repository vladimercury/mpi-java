package com.jacobi.model;

import com.jacobi.model.immutable.ImmutableMatrix;

public class Matrix extends ImmutableMatrix {
    public Matrix(int rows, int cols) {
        super(rows, cols);
    }

    public Matrix(ImmutableMatrix matrix) {
        super(matrix);
    }

    public ImmutableMatrix toImmutable() {
        return new ImmutableMatrix(this);
    }

    public void setCell(int row, int col, double value) {
        this.data[row][col] = value;
    }
}
