/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_sem1_project.data_access;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public interface Storage {

    /**
     * Save the result of playthrough.
     *
     * @param result The playthrough result in the form of "Score|Player".
     * @throws FileNotFoundException Exception is thrown if it wasn't possible
     * to save the result.
     * @throws IOException Thrown if the file can't be opened.
     */
    void save(String result) throws FileNotFoundException, IOException;

    /**
     * Retrieve all stored results.
     *
     * @return A list of all stored results.
     * @throws FileNotFoundException Exception is thrown if it wasn't possible
     * to read the stored results.
     */
    List<String> load() throws FileNotFoundException;
}
