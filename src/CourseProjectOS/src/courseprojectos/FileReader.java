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

/**
 *
 * @author Miganko
 */
public class FileReader {

    public static ObservableList readFile(File file) throws FileNotFoundException, IOException {
        ObservableList <XYChart.Data> readedList = FXCollections.observableArrayList();
        
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[\t\n]");
        
        while(scanner.hasNext()){
            double x = Double.parseDouble(scanner.next());
            if(scanner.hasNext()){
                double y = Double.parseDouble(scanner.next());
                XYChart.Data xy = new XYChart.Data(x, y);
                readedList.add(xy);
            }
        }

        return readedList;
    }
}
