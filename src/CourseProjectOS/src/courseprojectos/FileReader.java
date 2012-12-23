/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javax.crypto.NullCipher;

/**
 *
 * @author Miganko
 */
public class FileReader {

    public static ObservableList readFile(File file) throws FileNotFoundException, IOException {
        ObservableList<XYChart.Data> readedList = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> errorList = FXCollections.observableArrayList(
                new XYChart.Data(Double.MAX_VALUE, Double.MIN_VALUE),
                new XYChart.Data(Double.MAX_VALUE, Double.MIN_VALUE)
                );
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[\t\n]");
        String string = "";
        while (scanner.hasNext()) {
            string = scanner.next();
            if (string.contains(",")) {
                string = string.replace(",", ".");
            }
            if (string.contains(";")) {
                string = string.replace(";", ".");
            }
            if (string.contains(" ")) {
                string = string.replace(" ", ".");
            }
            try {
                double x = Double.parseDouble(string);

                if (scanner.hasNext()) {
                    string = scanner.next();
                    if (string.contains(",")) {
                        string = string.replace(",", ".");
                    }
                    if (string.contains(";")) {
                        string = string.replace(";", ".");
                    }
                    if (string.contains(" ")) {
                        string = string.replace(" ", ".");
                    }
                    try {
                        double y = Double.parseDouble(string);
                        XYChart.Data xy = new XYChart.Data(x, y);
                        readedList.add(xy);
                    } catch (NumberFormatException | NullPointerException ex) {
                        return errorList;
                    }
                }
            } catch (NumberFormatException | NullPointerException ex) {
                return errorList;
            }
        }

        return readedList;
    }
}
