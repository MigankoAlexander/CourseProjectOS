/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 *
 * @author Miganko
 */
public class FileReader {

    public ObservableList readFile(File file) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new java.io.FileReader(file));

        String line = in.readLine();
        while (line != null) {
            //
        }
        in.close();
        return null;
    }
}
