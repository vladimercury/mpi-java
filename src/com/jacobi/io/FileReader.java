package com.jacobi.io;

import java.io.*;

public class FileReader {
    private String filename;
    private BufferedReader reader;
    private StreamTokenizer tokenizer;

    public FileReader(String filename) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        this.tokenizer = new StreamTokenizer(this.reader);
    }

    public int getInt() throws IOException {
        return (int)this.getDouble();
    }

    public double getDouble() throws IOException {
        this.tokenizer.nextToken();
        return this.tokenizer.nval;
    }

    public void close() throws IOException{
        this.reader.close();
    }

}
