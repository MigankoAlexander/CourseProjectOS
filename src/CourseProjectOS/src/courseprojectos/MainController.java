/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.chart.LineChart;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

    @FXML
    private MenuItem menuItemTutorial;
    @FXML
    private MenuItem menuItemHelp;
    @FXML
    private AnchorPane anchorPaneHelp;
    @FXML
    private AnchorPane anchorPaneTutorial;
    @FXML
    private AnchorPane anchorPaneChart;
    @FXML
    private ScrollPane paneChartContainer;
    @FXML
    private LineChart lineChart;
    private AnchorPane currentPane;
    Map<String, AnchorPane> panes = new HashMap<>();

    @FXML
    private void handleMenuItemTutorial(ActionEvent event) {
        setCurrentPane(anchorPaneTutorial);
    }

    @FXML
    private void handleMenuItemHelp(ActionEvent event) {
        setCurrentPane(anchorPaneHelp);
    }
    
    @FXML 
    private void handleMenuItemExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleButtonToMain(ActionEvent event) {
        setCurrentPane(anchorPaneChart);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panes.put(anchorPaneHelp.getId(), anchorPaneHelp);
        panes.put(anchorPaneTutorial.getId(), anchorPaneTutorial);
        panes.put(anchorPaneChart.getId(), anchorPaneChart);

        paneChartContainer.viewportBoundsProperty().addListener(
                new ChangeListener<Bounds>() {
                    @Override
                    public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
                        lineChart.setMinSize(
                                Math.max(lineChart.getPrefWidth(), newBounds.getWidth()),
                                Math.max(lineChart.getPrefHeight(), newBounds.getHeight()));
                        paneChartContainer.setPannable(
                                (lineChart.getPrefWidth() > newBounds.getWidth())
                                || (lineChart.getPrefHeight() > newBounds.getHeight()));
                    }
                });

        setAllInvisible();
        setCurrentPane(anchorPaneChart);
    }

    private void setAllInvisible() {
        for (AnchorPane pane : panes.values()) {
            pane.setVisible(false);
        }
    }

    private void setCurrentPane(AnchorPane newCurrentPane) {
        if (currentPane != null) {
            currentPane.setVisible(false);
        }

        currentPane = newCurrentPane;
        currentPane.setVisible(true);
    }
}
