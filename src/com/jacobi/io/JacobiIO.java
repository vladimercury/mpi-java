package com.jacobi.io;

import com.jacobi.Matrix;
import com.jacobi.Vector;

import java.io.IOException;

public class JacobiIO {
    public static Matrix readMatrix(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        int rows = reader.getInt();
        int cols = reader.getInt();
        Matrix matrix = new Matrix(rows, cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix.setCell(reader.getDouble(), row, col);
            }
        }
        return matrix;
    }

    public static Vector readVector(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        int length = reader.getInt();
        Vector vector = new Vector(length);
        for (int index = 0; index < length; index++) {
            vector.setCell(reader.getDouble(), index);
        }
        return vector;
    }
}
