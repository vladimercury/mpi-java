package com.jacobi.io;

import com.jacobi.model.LinearSystem;
import com.jacobi.model.Matrix;
import com.jacobi.model.Vector;

import java.io.IOException;

public class LinearSystemReader {
    private FileReader reader;

    public LinearSystemReader(String filename) throws IOException {
        this.reader = new FileReader(filename);
    }

    public LinearSystem readSystem() throws IOException {
        int rows = reader.nextInt();
        int cols = reader.nextInt();
        Matrix matrix = new Matrix(rows, cols - 1);
        Vector vector = new Vector(rows);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 1; col++) {
                matrix.set(row, col, reader.nextDouble());
            }
            vector.set(row, reader.nextDouble());
        }
        return new LinearSystem(matrix, vector);
    }

    public void close() throws IOException {
        this.reader.close();
    }
}
