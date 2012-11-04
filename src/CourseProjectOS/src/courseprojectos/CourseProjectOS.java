/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CourseProjectOS extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane mainView = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(mainView);


        stage.setTitle("Курсовой проект по дисциплине \"Операционные системы\"");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
