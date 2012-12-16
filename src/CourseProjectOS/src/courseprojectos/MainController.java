/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package courseprojectos;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChartBuilder;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.swing.JFileChooser;
import methodsforschedules.MethodsForSchedules;

public class MainController implements Initializable {

    @FXML
    private AnchorPane MessagePane;
    @FXML
    private TextField addConcentration;
    @FXML
    private TextField addPressure;
    @FXML
    private Button addButton;
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
    ObservableList<XYChart.Data> obsDataList = FXCollections.observableArrayList();
    ObservableList<XYChart.Data> listForBuilding = FXCollections.observableArrayList();
    List<Point2D.Double> dataList = new ArrayList<>();
    boolean tableInit = false;

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
        lineChart.getData().clear();
        listForBuilding = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> readedList = FXCollections.observableArrayList();
        if (tableInit) {
            int cellNumber = 0;
            while (list.getColumns().get(0).getCellData(cellNumber) != null) {
                double x = (Double) list.getColumns().get(0).getCellData(cellNumber);
                double y = (Double) list.getColumns().get(1).getCellData(cellNumber);
                readedList.add(cellNumber, (new XYChart.Data(x, y)));
                cellNumber++;
            }
        }
        if (readedList.size() != 0) {
            for (int index = 0; index < readedList.size(); index++) {
                Double x = (Double) readedList.get(index).getXValue();
                Double y = (Double) readedList.get(index).getYValue();
                Point2D.Double xy = new Point2D.Double(x, y);
                dataList.add(xy);
            }

            List<Point2D.Double> interpList = MethodsForSchedules.ordinaryLeastSquares(dataList);
            for (int i = 0; i < interpList.size(); i++) {
                listForBuilding.add(new XYChart.Data(interpList.get(i).getX(), interpList.get(i).getY()));
            }


            lineChart.setAnimated(false);

            lineChart.setLegendVisible(false);
            lineChart.setCreateSymbols(false);
            xAxis.setLabel("Pressure");
            yAxis.setLabel("Concentration");
            lineChart.setTitle("Monitoring of technological process");
            XYChart.Series series = new XYChart.Series(listForBuilding);
            series.setName("Schedule");
            lineChart.getData().setAll(series);

        } else {
            try {
                showErrorDialog("Ошибка", "Набор не задан");
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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
        list.setEditable(true);

        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        if (file != null) {
            obsDataList = FXCollections.observableArrayList();
            obsDataList = FileReader.readFile(file);
            if (tableInit == false) {
                initTable();
                setCurrentPane(anchorDataPane);
            }

            list.setItems(obsDataList);
            handleMenuItemDock(dockPane);
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
    private void handleAdd() {
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                obsDataList.add(new XYChart.Data(Double.parseDouble(addPressure.getText()),
                        Double.parseDouble(addConcentration.getText())));
                addConcentration.clear();
                addPressure.clear();
            }
        });
    }

    @FXML
    private void handleMenuItemNew() {
        list.setEditable(true);
        obsDataList = FXCollections.observableArrayList();

        if (tableInit == false) {
            initTable();
            setCurrentPane(anchorDataPane);
        }
        list.setItems(obsDataList);


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
                imageView.setCursor(Cursor.HAND);
                imageView.setEffect(new Glow(0.7));
                imageView.setScaleX(1.1);
                imageView.setScaleY(1.1);
            }
        });
        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                imageView.setCursor(Cursor.DEFAULT);
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
                    Logger.getLogger(MainController.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class
                            .getName()).log(Level.SEVERE, null, ex);
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
            case "icon9.png":
                try {
                    showErrorDialog("Ремонт", "YOU SHALL NOT PASS!!");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "icon10.png":
                handleMenuItemExit();
                break;
        }
    }

    private void showErrorDialog(String title, String message) throws IOException {

        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Button ok = new Button("Ok");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                dialogStage.close();
            }
        });
        dialogStage.setTitle(title);
        Text text = new Text(message);
        text.setScaleX(1.2);
        text.setScaleY(1.2);
        ok.setTranslateY(20);
        dialogStage.setScene(new Scene(VBoxBuilder.create().
                prefHeight(100).prefWidth(200).
                children(text, ok).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
        dialogStage.show();
    }

    private void initTable() {
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

        addConcentration.setPromptText("Сoncentration");
        addConcentration.setMaxWidth(columnСoncentration.getPrefWidth());
        addPressure.setMaxWidth(columnPressure.getPrefWidth());
        addPressure.setPromptText("Pressure");
        list.getColumns().setAll(columnPressure, columnСoncentration);
        
        tableInit = true;
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
