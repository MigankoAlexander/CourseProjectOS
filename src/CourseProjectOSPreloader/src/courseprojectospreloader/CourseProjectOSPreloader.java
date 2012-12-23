/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectospreloader;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CourseProjectOSPreloader extends Preloader {

    private Stage stage;
    private ProgressIndicator progress;

    @Override
    public void start(Stage falseStage) throws Exception {
        Stage stage = new Stage(StageStyle.UNDECORATED);

        this.stage = stage;
        Group root = new Group();
        root.setTranslateX(0);
        root.setTranslateY(0);
        String userName = System.getProperty("user.name");
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        String st = dateFormat.format(date);
        //System.out.println(userName+"\n"+st);
        String part = getPartOfDay(Integer.parseInt(st));
        Text text = new Text(part + ", " + userName + "!");
        text.setStyle("-fx-font: 32pt Georgia;-fx-fill:darkblue;");
        text.setTranslateX(130);
        text.setTranslateY(50);
        Text name = new Text("Миганько Александр");
        name.setStyle("-fx-font: 16pt Arial;-fx-fill:darkblue;");
        name.setTranslateX(460);
        name.setTranslateY(460);
        Scene scene = new Scene(root, 640, 480, Color.LIGHTSTEELBLUE);
        BorderPane pane = new BorderPane();
        pane.setPrefSize(100, 100);
        pane.setTranslateX(270);
        pane.setTranslateY(190);
        progress = new ProgressIndicator();
        progress.setStyle("-fx-backgroung-color:black;");
        pane.setCenter(progress);
        root.getChildren().addAll(text, pane, name);
        stage.setScene(scene);
        stage.show();
        stage.setOpacity(0.96);
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        /*if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
         stage.hide();
         }  */
    }

    private String getPartOfDay(int time) {
        if (time == 23 || (time >= 0 && time <= 7)) {
            return "Доброй ночи";
        }
        if (time > 7 && time <= 11) {
            return "Доброе утро";
        }
        if (time > 11 && time <= 18) {
            return "Добрый день";
        }
        if (time > 18 && time < 23) {
            return "Добрый вечер";
        }
        return "";
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        progress.setProgress(pn.getProgress());
    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
        Preloader.ProgressNotification ntf = (Preloader.ProgressNotification) info;
        if (ntf.getProgress() == 1.0) {
            stage.hide();
        } else {
            progress.setProgress(-1);
        }
    }
}
