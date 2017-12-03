package com.jacobi.io;

import com.jacobi.model.Vector;

import java.io.IOException;

public class VectorReader {
    private FileReader reader;

    public VectorReader(String filename) throws IOException{
        this.reader = new FileReader(filename);
    }

    public Vector readVector() throws IOException{
        int length = reader.nextInt();
        Vector vector = new Vector(length);
        for (int index = 0; index < length; index++) {
            vector.set(index, reader.nextDouble());
        }
        return vector;
    }
}
