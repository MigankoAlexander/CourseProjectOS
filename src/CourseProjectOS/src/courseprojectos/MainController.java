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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javax.swing.JFileChooser;
import methodsforschedules.MethodsForSchedules;

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
    private AnchorPane dockPane;
    @FXML
    private AnchorPane dockPane1;
    @FXML
    private ScrollPane paneChartContainer;
    @FXML
    private LineChart lineChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private WebView webViewHelp;
    private AnchorPane currentPane;
    private AnchorPane previousPane;
    @FXML
    private TableView<XYChart.Data> list;
    private File file;
    Map<String, AnchorPane> panes = new HashMap<>();
    private ObservableList<XYChart.Data> dataList = null;

    @FXML
    private void handleMenuItemTutorial() {
        previousPane = currentPane;
        setCurrentPane(anchorPaneTutorial);
    }

    @FXML
    private void handleMenuItemHelp() {
        previousPane = currentPane;
        setCurrentPane(anchorPaneHelp);
        WebEngine webEngine = webViewHelp.getEngine();
        URL urlHelp = getClass().getResource("help.html");
        webEngine.load(urlHelp.toExternalForm());
    }

    @FXML
    private void handleBuild() {
        xAxis.setLabel("Concentration");
        yAxis.setLabel("Pressure");

        lineChart.setTitle("Monitoring of technological process");
        XYChart.Series series = new XYChart.Series(dataList);
        series.setName("Schedule");
        lineChart.getData().setAll(series);
    }

    @FXML
    private void handleMenuItemExit() {
        System.exit(0);
    }

    @FXML
    private void handleButtonToMain(ActionEvent event) {
        setCurrentPane(previousPane);
    }

    @FXML
    private void handleMenuItemOpen() throws FileNotFoundException, IOException {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            //to be continued...
        }
    }

    @FXML
    private void handleMenuItemDock(AnchorPane anchorPane) {

        String images[] = {
            "icon1.png",
            "icon2.png",
            "icon3.png",
            "icon4.png",
            "icon5.png",
            "icon6.png",
            "icon7.png",
            "icon8.png",
            "icon9.png",
            "icon10.png"
        };

        for (int i = 0; i < 10; i++) {
            final ImageView node = new ImageView(new Image(getClass().getResource(images[i]).toString()));
            //node.setEffect(new Reflection(0, 0.5, 0.3, 0.1));
            mouseEv(node);
            final String action = images[i].split("-")[0].toLowerCase();
            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    mouseClicked(action);
                }
            });
            node.setTranslateX(5 + 50 * i);
            node.setTranslateY(15);
            anchorPane.getChildren().add(node);
        }

    }

    @FXML
    private void handleMenuItemNew() {
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

        columnPressure.setCellFactory(cellFactory);
        columnСoncentration.setCellFactory(cellFactory);

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

//        MethodsForSchedules.approximate(null, 0);

        dataList = FXCollections.observableArrayList(
                new XYChart.Data(0.269, 3.347900E-05),
                new XYChart.Data(6.520, 9.695830E-05),
                new XYChart.Data(12.379, 7.174140E-04),
                new XYChart.Data(20.176, 9.000000E-04),
                new XYChart.Data(30.427, 8.525310E-04),
                new XYChart.Data(41.669, 8.258400E-04),
                new XYChart.Data(56.125, 8.756500E-04),
                new XYChart.Data(72.375, 0.009),
                new XYChart.Data(90.629, 0.035),
                new XYChart.Data(109.879, 0.073),
                new XYChart.Data(132.234, 0.138),
                new XYChart.Data(153.388, 0.236),
                new XYChart.Data(175.629, 0.361),
                new XYChart.Data(201.329, 0.530),
                new XYChart.Data(220.127, 0.853),
                new XYChart.Data(253.177, 1.269),
                new XYChart.Data(280.125, 1.447),
                new XYChart.Data(319.246, 1.565),
                new XYChart.Data(349.029, 1.579),
                new XYChart.Data(389.149, 1.559),
                new XYChart.Data(426.621, 1.535),
                new XYChart.Data(477.666, 1.399),
                new XYChart.Data(526.269, 1.287),
                new XYChart.Data(559.875, 1.106),
                new XYChart.Data(586.125, 0.863));

        list.setItems(dataList);
        list.getColumns().setAll(columnPressure, columnСoncentration);

        setCurrentPane(anchorDataPane);
        handleMenuItemDock(dockPane);
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

        handleMenuItemDock(dockPane1);
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

    private void mouseEv(final ImageView imageView) {
        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                imageView.setEffect(new Glow(0.7));
                imageView.setScaleX(1.1);
                imageView.setScaleY(1.1);
            }
        });
        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                imageView.setEffect(null);
                imageView.setScaleX(1.0);
                imageView.setScaleY(1.0);
            }
        });
        imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                imageView.setScaleX(1.0);
                imageView.setScaleY(1.0);
            }
        });
        imageView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                imageView.setScaleX(1.1);
                imageView.setScaleY(1.1);
            }
        });
    }

    public void mouseClicked(String action) {
        switch (action) {
            case "icon1.png":
                handleMenuItemNew();
                break;
            case "icon2.png":
                try {
                    handleMenuItemOpen();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "icon3.png": {
                handleBuild();
            }
            break;
            case "icon5.png":
                handleMenuItemTutorial();
                break;
            case "icon8.png":
                handleMenuItemHelp();
                break;
            case "icon10.png":
                handleMenuItemExit();
//                break;
        }
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
