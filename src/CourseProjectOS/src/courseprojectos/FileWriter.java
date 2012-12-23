/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Miganko
 */
public class FileWriter {

    public static boolean writeFile(ObservableList<XYChart.Data> list, String path) throws FileNotFoundException {
        try {
            boolean newFile = false;
            File file = new File(path);
            System.out.println(file.exists());
            newFile = file.createNewFile();
            System.out.println(newFile);
            System.out.println(file.exists());
            PrintWriter printWriter;
            try {
                printWriter = new PrintWriter(new FileOutputStream(file));

                for (int i = 0; i < list.size(); i++) {
                    String x = list.get(i).getXValue().toString();
                    String y = list.get(i).getYValue().toString();
                    String line = x + "\t" + y;
                    printWriter.println(line);
                }
                printWriter.close();
            } catch (Exception ex) {
                return false;
            }
        } catch (IOException ex) {
            return false;
        }

        return true;
    }
}
