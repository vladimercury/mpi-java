package com.jacobi.io;

import java.io.*;

public class FileReader {
    private BufferedReader reader;
    private StreamTokenizer tokenizer;

    public FileReader(String filename) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        this.tokenizer = new StreamTokenizer(this.reader);
        this.tokenizer.nextToken();
    }

    public boolean hasNextToken() {
        return this.tokenizer.ttype != StreamTokenizer.TT_EOF;
    }

    public double nextDouble() throws IOException, NumberFormatException {
        if (!this.hasNextToken()) {
            throw new EOFException("End of file reached");
        }
        if (this.tokenizer.ttype != StreamTokenizer.TT_NUMBER) {
            throw new NumberFormatException(this.tokenizer.sval + " is not a number");
        }
        double value = this.tokenizer.nval;
        tokenizer.nextToken();
        return value;
    }

    public int nextInt() throws IOException, NumberFormatException {
        return (int)this.nextDouble();
    }

    public void close() throws IOException{
        this.reader.close();
    }
}
