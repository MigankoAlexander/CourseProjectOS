/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javax.swing.JFileChooser;

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
    private AnchorPane anchorDataPane;
    @FXML
    private ScrollPane paneChartContainer;
    @FXML
    private LineChart lineChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    private AnchorPane currentPane;
    @FXML
    private TableView<XYChart.Data> list;
    private File file;
    Map<String, AnchorPane> panes = new HashMap<>();
    private ObservableList<XYChart.Data> dataList = null;

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

    @FXML
    private void handleMenuItemOpen(ActionEvent event) throws FileNotFoundException, IOException {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //to be continued...
        }
    }

    @FXML
    private void handleMenuItemNew() {
                
        setCurrentPane(anchorDataPane);

        list.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditingCell();
                    }
                };

        TableColumn columnPressure = new TableColumn("Pressure");
        columnPressure.setCellValueFactory(
                new PropertyValueFactory<XYChart.Data, Number>("XValue"));
        columnPressure.setMinWidth(70);
        columnPressure.setSortable(false);

        TableColumn columnСoncentration = new TableColumn("Сoncentration");
        columnСoncentration.setCellValueFactory(
                new PropertyValueFactory<XYChart.Data, Number>("YValue"));
        columnСoncentration.setMinWidth(105);
        columnСoncentration.setSortable(false);

        columnСoncentration.setCellFactory(cellFactory);
        columnPressure.setCellFactory(cellFactory);

        columnСoncentration.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XYChart.Data, Number>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<XYChart.Data, Number> t) {
                        ((XYChart.Data) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setYValue(t.getNewValue());
                    }
                });
        columnPressure.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XYChart.Data, Number>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<XYChart.Data, Number> d) {
                        ((XYChart.Data) d.getTableView().getItems().get(
                                d.getTablePosition().getRow())).setXValue(d.getNewValue());
                    }
                });

        dataList = FXCollections.observableArrayList(
                new XYChart.Data(3.347900E-05, 0.269),
                new XYChart.Data(9.695830E-05, 6.520),
                new XYChart.Data(7.174140E-04, 12.379),
                new XYChart.Data(9.000000E-04, 20.176),
                new XYChart.Data(8.525310E-04, 30.427),
                new XYChart.Data(8.258400E-04, 41.669),
                new XYChart.Data(8.756500E-04, 56.125),
                new XYChart.Data(0.009, 72.375),
                new XYChart.Data(0.035, 90.629),
                new XYChart.Data(0.073, 109.879),
                new XYChart.Data(0.138, 132.234),
                new XYChart.Data(0.236, 153.388),
                new XYChart.Data(0.361, 175.629),
                new XYChart.Data(0.530, 201.329),
                new XYChart.Data(0.853, 220.127),
                new XYChart.Data(1.269, 253.177),
                new XYChart.Data(1.447, 280.125),
                new XYChart.Data(1.565, 319.246),
                new XYChart.Data(1.579, 349.029),
                new XYChart.Data(1.559, 389.149),
                new XYChart.Data(1.535, 426.621),
                new XYChart.Data(1.399, 477.666),
                new XYChart.Data(1.287, 526.269),
                new XYChart.Data(1.106, 559.875),
                new XYChart.Data(0.863, 586.125));

        xAxis.setLabel("Pressure");
        yAxis.setLabel("Concentration");

        lineChart.setTitle("Monitoring of technological process");
        XYChart.Series series = new XYChart.Series(dataList);
        series.setName("Schedule");
        lineChart.getData().add(series);

        list.setItems(dataList);
        list.getColumns().addAll(columnPressure, columnСoncentration);
        
      
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

class EditingCell extends TableCell<XYChart.Data, Number> {

    private TextField textField;

    public EditingCell() {
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }

        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void updateItem(Number item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(Double.parseDouble(textField.getText()));
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}
