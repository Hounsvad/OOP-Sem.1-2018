/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.data_access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class StorageImpl implements Storage {

    /**
     * The file to be written to and read from.
     */
    private final File file;

    /**
     * Constructs a new Storage Implementation Object. This constructor ensures
     * that the File is created if non-existent.
     *
     * @param path The path of the File.
     * @param fileName The name of the storage File.
     * @throws IOException This is thrown if the file couldn't be created or if
     * the File is a directory.
     */
    public StorageImpl(String path, String fileName) throws IOException {
        this.file = new File(path, fileName + ".csv");
        if (!file.exists()) {
            file.createNewFile();
        } else if (file.isDirectory()) {
            throw new IOException("The file(" + fileName + ") currently exists as a directory!");
        }
    }

    /**
     * Append a result String to the currently stored results in the File.
     *
     * @param result The result String.
     * @throws FileNotFoundException Thrown if the File wasn't found.
     * @throws IOException Thrown if the file can't be opened.
     */
    @Override
    public void save(String result) throws FileNotFoundException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, true))) {
            writer.write((this.file.length() == 0 ? "" : ",") + result);
        }
    }

    /**
     * Loads all currently stored results.
     *
     * @return A List of unordered strings containing all of the stored results.
     * @throws FileNotFoundException Thrown if the file wasn't found.
     */
    @Override
    public List<String> load() throws FileNotFoundException {
        List<String> results = new ArrayList<>();
        Scanner scanner = new Scanner(this.file).useDelimiter(",");
        while (scanner.hasNext()) {
            results.add(scanner.next());
        }
        return results;
    }
}
