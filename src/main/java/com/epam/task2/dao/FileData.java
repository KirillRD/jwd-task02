package com.epam.task2.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileData {
    private BufferedReader fileReader;

    public FileData(String pathToFile) {
        try {
            fileReader = new BufferedReader(new FileReader(pathToFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {
        String line = null;
        try {
            line = fileReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public boolean hasNext() {
        boolean bool = true;
        try {
            bool = fileReader.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bool;
    }
}
