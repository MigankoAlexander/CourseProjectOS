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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ParallelTransitionBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
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
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChartBuilder;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
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
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import methodsforschedules.MethodsForSchedules;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.ParallelTransitionBuilder;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

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
    private CheckMenuItem menuItemCurve;
    @FXML
    private CheckMenuItem menuItemMNK;
    @FXML
    private MenuItem menuItemMedia;
    @FXML
    private MenuItem menuItemImages;
    @FXML
    private MenuItem menuItemHelp;
    @FXML
    private MenuItem menuItemInformation;
    @FXML
    private AnchorPane anchorPaneHelp;
    @FXML
    private AnchorPane anchorPaneMedia;
    private MediaPlayer mediaPlayer;
    final double width = 1000;
    final double height = 650;
    @FXML
    private TreeView treeView;
    @FXML
    private AnchorPane anchorPaneMap;
    @FXML
    private AnchorPane anchorPaneImages;
    @FXML
    private AnchorPane anchorPaneChart;
    @FXML
    private AnchorPane anchorProject;
    @FXML
    private TabPane tabPane;
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
    private AnchorPane previousMainPane;
    List<Popup> popups = new ArrayList<>();
    @FXML
    private TableView<XYChart.Data> list;
    private File file;
    Map<String, AnchorPane> panes = new HashMap<>();
    ObservableList<XYChart.Data> obsDataList = FXCollections.observableArrayList();
    ObservableList<XYChart.Data> listForBuilding = FXCollections.observableArrayList();
    List<Point2D.Double> dataList = new ArrayList<>();
    boolean tableInit = false;
    boolean curve = false;

    @FXML
    private void handleMenuItemMedia() {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }
        setCurrentPane(anchorPaneMedia);

        Group root = new Group();
        Media media = new Media(this.getClass().getResource("video.mp4").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        PlayerPane playerPane = new PlayerPane(mediaPlayer);
        playerPane.setMinSize(width, height);
        playerPane.setPrefSize(width, height);
        playerPane.setMaxSize(width, height);
        playerPane.setTranslateY(20);
        Text title = new Text("Технологический процесс" + "\n");
        title.setStyle("-fx-font: 36pt Georgia;-fx-fill: grey;");
        //title.setStyle("-fx-text-fill:white;");
        title.setTranslateX(230);
        title.setTranslateY(5);
        root.getChildren().setAll(title, playerPane);
        root.maxHeight(height);
        root.minWidth(width);
        root.setTranslateX(14);
        root.setTranslateY(100);
        anchorPaneMedia.getChildren().add(root);
    }

    public void stop() {
        mediaPlayer.stop();
    }

    @FXML
    private void handleMenuItemCurve() {
        if (menuItemCurve.isSelected()) {
            curve = true;
            menuItemMNK.setSelected(false);

        } else {

            curve = false;
            menuItemMNK.setSelected(true);
        }
    }

    @FXML
    private void handleMenuItemMNK() {
        if (menuItemMNK.isSelected()) {
            curve = false;
            menuItemCurve.setSelected(false);

        } else {
            curve = true;
            menuItemCurve.setSelected(true);
        }
    }

    @FXML
    private void handleMenuItemImages() {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }
        setCurrentPane(anchorPaneImages);

        Group root = new Group();
        // load images
        Image[] images = new Image[12];
        for (int i = 0; i < 12; i++) {
            images[i] = new Image(MainController.class.getResource("pic" + (i+1) + ".jpg").toExternalForm(), false);
        }
        // create display shelf
        DisplayShelf displayShelf = new DisplayShelf(images);
        displayShelf.setPrefSize(width, height);
        root.getChildren().add(displayShelf);
        root.setTranslateX(15);
        root.setTranslateY(80);
        anchorPaneImages.getChildren().addAll(root);

    }

    @FXML
    private void handleMenuItemMap(ActionEvent event) {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }
        setCurrentPane(anchorPaneMap);

        TreeItem<String> treeRoot = new TreeItem<>("Главное меню");
        treeRoot.getChildren().addAll(Arrays.asList(
                new TreeItem<>("Файл"),
                new TreeItem<>("Дополнительно"),
                new TreeItem<>("Помощь"),
                new TreeItem<>("О проекте")));

        treeRoot.getChildren().get(0).getChildren().addAll(Arrays.asList(
                new TreeItem<>("Новый набор"),
                new TreeItem<>("Открыть..."),
                new TreeItem<>("Сохранить"),
                new TreeItem<>("Выход")));
        treeRoot.getChildren().get(1).getChildren().addAll(Arrays.asList(
                new TreeItem<>("Медиа плеер"),
                new TreeItem<>("Изображения")));
        treeRoot.getChildren().get(2).getChildren().addAll(Arrays.asList(
                new TreeItem<>("Карта меню"),
                new TreeItem<>("Справка")));
        treeRoot.getChildren().get(3).getChildren().addAll(Arrays.asList(
                new TreeItem<>("Информация")));

        //treeView = new TreeView();
        treeView.setShowRoot(true);
        treeView.setRoot(treeRoot);
        treeRoot.setExpanded(true);


    }

    @FXML
    private void handleMenuItemHelp() {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }
        setCurrentPane(anchorPaneHelp);
        WebEngine webEngine = webViewHelp.getEngine();
        URL urlHelp = getClass().getResource("help.html");
        webEngine.load(urlHelp.toExternalForm());
    }

    @FXML
    private void handleBuild() {

        listForBuilding = FXCollections.observableArrayList();
        dataList = new ArrayList<>();
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

            if (!curve) {
                lineChart.getData().clear();
                List<Point2D.Double> interpList = MethodsForSchedules.ordinaryLeastSquares(dataList);
                for (int i = 0; i < interpList.size(); i++) {
                    listForBuilding.add(new XYChart.Data(interpList.get(i).getX(), interpList.get(i).getY()));
                }
//            
//            
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
                    showErrorDialog("Ошибка", "Метод кривой Безье \nв стадии разработки");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //            CubicCurve cubic = new CubicCurve();
                //            cubic.setFill(Color.KHAKI);
                //            cubic.setStroke(Color.OLIVE);
                //            cubic.setStrokeWidth(3);
                //            cubic.setStrokeLineCap(StrokeLineCap.ROUND);
                //            cubic.setStrokeType(StrokeType.CENTERED);
                //            cubic.setStartX((double)readedList.get(0).getXValue());
                //            cubic.setStartY((double)readedList.get(0).getYValue());
                //            cubic.setEndX((double)readedList.get(readedList.size()-1).getXValue());
                //            cubic.setEndY((double)readedList.get(readedList.size()-1).getYValue());
                //            cubic.setControlX1((double)readedList.get((int)readedList.size()/3).getXValue());
                //            cubic.setControlY1((double)readedList.get((int)readedList.size()/3).getYValue());
                //            cubic.setControlX2((double)readedList.get((int)2*readedList.size()/3).getXValue());
                //            cubic.setControlY2((double)readedList.get((int)2*readedList.size()/3).getYValue());CubicCurve cubic = new CubicCurve();
                //            cubic.setFill(Color.KHAKI);
                //            cubic.setStroke(Color.OLIVE);
                //            cubic.setStrokeWidth(3);
                //            cubic.setStrokeLineCap(StrokeLineCap.ROUND);
                //            cubic.setStrokeType(StrokeType.CENTERED);
                //            cubic.setStartX((double)readedList.get(0).getXValue());
                //            cubic.setStartY((double)readedList.get(0).getYValue());
                //            cubic.setEndX((double)readedList.get(readedList.size()-1).getXValue());
                //            cubic.setEndY((double)readedList.get(readedList.size()-1).getYValue());
                //            cubic.setControlX1((double)readedList.get((int)readedList.size()/3).getXValue());
                //            cubic.setControlY1((double)readedList.get((int)readedList.size()/3).getYValue());
                //            cubic.setControlY2((double)readedList.get((int)2*readedList.size()/3).getYValue());
                //            cubic.setControlY2((double)readedList.get((int)2*readedList.size()/3).getYValue());

            }
        } else {
            try {
                showErrorDialog("Ошибка", "Набор не задан");
            } catch (IOException ex) {
                Logger.getLogger(MainController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handleMenuItemExit() {
        System.exit(0);
    }

    @FXML
    private void handleMenuItemSave() {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }

        ObservableList<XYChart.Data> readedList = FXCollections.observableArrayList();
        if (tableInit) {
            int cellNumber = 0;
            while (list.getColumns().get(0).getCellData(cellNumber) != null) {
                double x = (Double) list.getColumns().get(0).getCellData(cellNumber);
                double y = (Double) list.getColumns().get(1).getCellData(cellNumber);
                readedList.add(cellNumber, (new XYChart.Data(x, y)));
                cellNumber++;
            }
            if (readedList.size() != 0) {
                final FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new java.io.File("C:\\"));
                fileChooser.setTitle("Сохраниние файла");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt", "*.txt"));
                Stage saveStage = new Stage(StageStyle.UTILITY);
                saveStage.setX(300);
                saveStage.setY(300);

                file = fileChooser.showSaveDialog(saveStage);
                boolean saved = false;
                try {
                    FileWriter.writeFile(readedList, file.getPath());
                    saved = true;
                } catch (FileNotFoundException ex) {
                    try {
                        showErrorDialog("Ошика сохранения", "Не удвлось сохранить файл");
                    } catch (IOException | NullPointerException ex1) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);

                }
                if (saved != true) {
                    try {
                        showErrorDialog("Ошика сохранения", "Не удвлось сохранить файл");
                    } catch (IOException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                try {
                    showErrorDialog("Ошибка сохранения", "Набор не задан");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            try {
                showErrorDialog("Ошибка сохранения", "Набор не задан");
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handleButtonToMain(ActionEvent event) {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }
        setCurrentPane(previousMainPane);
    }

    @FXML
    private void handleMenuItemOpen() throws FileNotFoundException, IOException {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }

//        if ((obsDataList != null) && (!obsDataList.equals(FXCollections.observableArrayList()))) {
//            try {
//                showSaveDialog(true);
//            } catch (IOException ex) {
//                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        setCurrentPane(anchorDataPane);
        previousMainPane = anchorDataPane;
        list.setEditable(true);
        if (tableInit == false) {
            initTable();
            setCurrentPane(anchorDataPane);
            handleMenuItemDock(dockPane);
        }
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new java.io.File("C:\\"));
        fileChooser.setTitle("Выберете набор для построения");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt", "*.txt"));
        Stage openStage = new Stage(StageStyle.UTILITY);
        openStage.setX(300);
        openStage.setY(300);
        file = fileChooser.showOpenDialog(openStage);
//        JFileChooser fc = new JFileChooser();
//        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
//            file = fc.getSelectedFile();
//        }
        if (file != null) {
            obsDataList = FXCollections.observableArrayList();
            obsDataList = FileReader.readFile(file);
            if (obsDataList.size() == 0 || ((double) obsDataList.get(0).getXValue() == Double.MAX_VALUE
                    && (double) obsDataList.get(0).getYValue() == Double.MIN_VALUE)) {
                showErrorDialog("Ошибка чтения файла", "Данные в файле хранятся в\n некорректном формате ");
            } else {

                list.setItems(obsDataList);
            }
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
        String toollips[] = {
            "Новый набор",
            "Открыть",
            "Построить график",
            "Сохранить",
            "Медиа плеер",
            "Настройки",
            "Учетные записи",
            "Справка",
            "Об авторе",
            "Выход"
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
            String stringOne = "";
            String stringTwo = "";
            double doubleOne = 0.0;
            double doubleTwo = 0.0;

            @Override
            public void handle(ActionEvent e) {
                stringOne = addPressure.getText();
                if (stringOne.contains(",")) {
                    stringOne = stringOne.replace(",", ".");
                }
                if (stringOne.contains(";")) {
                    stringOne = stringOne.replace(";", ".");
                }
                if (stringOne.contains(" ")) {
                    stringOne = stringOne.replace(" ", ".");
                }
                if (stringOne.isEmpty()) {
                    try {
                        showErrorDialog("Ошибка ввода", "Пустая ячейка");
                    } catch (IOException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                stringTwo = addConcentration.getText();
                if (stringTwo.contains(",")) {
                    stringTwo = stringTwo.replace(",", ".");
                }
                if (stringTwo.contains(";")) {
                    stringTwo = stringTwo.replace(";", ".");
                }
                if (stringTwo.contains(" ")) {
                    stringTwo = stringTwo.replace(" ", ".");
                }
                if (stringTwo.isEmpty()) {
                    try {
                        showErrorDialog("Ошибка ввода", "Пустая ячейка");
                    } catch (IOException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    doubleOne = Double.parseDouble(stringOne);
                    doubleTwo = Double.parseDouble(stringTwo);
                    obsDataList.add(new XYChart.Data(doubleOne,
                            doubleTwo));
                } catch (NumberFormatException ex) {
                    try {
                        showErrorDialog("Ошибка ввода", "       Попытка ввода \nнекорректного значения");
                    } catch (IOException ex1) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } catch (NullPointerException ex) {
                    try {
                        showErrorDialog("Ошибка ввода", "       Попытка ввода \nнекорректного значения");
                    } catch (IOException ex1) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }

                stringOne = "";
                stringTwo = "";
                doubleOne = 0.0;
                doubleTwo = 0.0;
                addConcentration.clear();
                addPressure.clear();
            }
        });
    }

    @FXML
    private void handleMenuItemNew() {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }
        if ((obsDataList != null) && (!obsDataList.equals(FXCollections.observableArrayList()))) {
            try {
                showSaveDialog(false);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        setCurrentPane(anchorDataPane);
        previousMainPane = anchorDataPane;
        list.setEditable(true);
        obsDataList = FXCollections.observableArrayList();

        if (tableInit == false) {
            initTable();
            setCurrentPane(anchorDataPane);
        }
        list.setItems(obsDataList);


        handleMenuItemDock(dockPane);

    }

    @FXML
    private void handleMenuItemInfo() {
        if (currentPane == anchorPaneMedia) {
            mediaPlayer.stop();
        }
        setCurrentPane(anchorProject);

        tabPane.setCursor(Cursor.HAND);
        DropShadow effect = new DropShadow();
        effect.setOffsetX(8);
        effect.setOffsetY(8);
        tabPane.setEffect(effect);
        tabPane.setSide(Side.TOP);
        tabPane.setTabMinHeight(30);
        tabPane.setTabMinWidth(100);

        Tab tabP = new Tab("Описание");
        tabP.setClosable(false);
        Group rootP = new Group();
        Text text = new Text("  Данная программа предсталяет собой JavaFX приложение, предназначенное "
                + "для обработки\n экспериментальных данных технологического процесса и построения по этим "
                + "данным графиков\n зависимости физических величин");
        text.setStyle("-fx-font: 20pt Georgia;");
        text.setTranslateY(100);
        text.setTranslateX(40);
        rootP.getChildren().add(text);
        tabP.setContent(rootP);

        Tab tabN = new Tab("Кривая Безье");
        //tabN.setDisable(true);
        tabN.setClosable(false);


        CubicCurve curve = new CubicCurve();
        curve.setStartX(100);
        curve.setStartY(100);
        curve.setControlX1(100);
        curve.setControlY1(500);
        curve.setControlX2(500);
        curve.setControlY2(100);
        curve.setEndX(500);
        curve.setEndY(500);
        curve.setStroke(Color.FORESTGREEN);
        curve.setStrokeWidth(4);
        curve.setStrokeLineCap(StrokeLineCap.ROUND);
        curve.setFill(Color.LIGHTBLUE.deriveColor(0, 1.2, 1, 0.6));


        Line controlLine1 = new BoundLine(curve.controlX1Property(), curve.controlY1Property(), curve.startXProperty(), curve.startYProperty());
        Line controlLine2 = new BoundLine(curve.controlX2Property(), curve.controlY2Property(), curve.endXProperty(), curve.endYProperty());

        Anchor start = new Anchor(Color.PALEGREEN, curve.startXProperty(), curve.startYProperty());
        Anchor control1 = new Anchor(Color.GOLD, curve.controlX1Property(), curve.controlY1Property());
        Anchor control2 = new Anchor(Color.GOLDENROD, curve.controlX2Property(), curve.controlY2Property());
        Anchor end = new Anchor(Color.TOMATO, curve.endXProperty(), curve.endYProperty());

        //Stage stage = new Stage();
        //stage.setTitle("Cubic Curve Manipulation Sample");
        //new Scene(new Group(controlLine1, controlLine2, curve, start, control1, control2, end), 400, 400, Color.ALICEBLUE));
        //stage.show();
        Text title = new Text("Демонстрация построения графика кривой Безье");
        title.setStyle("-fx-font: bold 18pt Georgia;");
        title.setTranslateX(0);
        title.setTranslateY(0);
        Group rootN = new Group();
        rootN.prefWidth(400);
        rootN.prefWidth(400);
        rootN.getChildren().addAll(title, controlLine1, controlLine2, curve, start, control1, control2, end);
        //maxHeight(500);
        //rootN.setLayoutY(500);
        //rootN.getChildren().setAll((controlLine1, controlLine2, curve, start, control1, control2, end), 400, 400, Color.ALICEBLUE);
        tabN.setContent(rootN);

        tabPane.getTabs().setAll(tabP, tabN);
        //anchorProject.getChildren().add(tabPane);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panes.put(anchorPaneHelp.getId(), anchorPaneHelp);
        panes.put(anchorPaneMedia.getId(), anchorPaneMedia);
        panes.put(anchorPaneImages.getId(), anchorPaneImages);
        panes.put(anchorPaneMap.getId(), anchorPaneMap);
        panes.put(anchorProject.getId(), anchorProject);
        panes.put(anchorPaneChart.getId(), anchorPaneChart);
        menuItemCurve.setSelected(true);
        curve = true;
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
        previousMainPane = anchorPaneChart;
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
            case "icon4.png": {
                handleMenuItemSave();
            }
            break;
            case "icon5.png":
                handleMenuItemMedia();
                break;
            case "icon6.png": {
                try {
                    showErrorDialog("Ремонт", "YOU SHALL NOT PASS!!");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case "icon7.png": {
                try {
                    showErrorDialog("Ремонт", "Разработка продолжается...");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "icon8.png":
                handleMenuItemHelp();
                break;
            case "icon9.png":
                try {
                    showErrorDialog("Ремонт", "Разработка продолжается...");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "icon10.png":
                //showChoiceDialog("Выход из программы", "Вы уверены?");
                handleMenuItemExit();
                break;
        }
    }

    private void showErrorDialog(String title, String message) throws IOException {

        final Stage dialogStage = new Stage(StageStyle.UTILITY);
        dialogStage.setResizable(false);
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

    private void showSaveDialog(final boolean open) throws IOException {

        final Stage dialogStage = new Stage(StageStyle.UTILITY);
        dialogStage.setResizable(false);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Button yes = new Button("Да");
        Button no = new Button("Нет");
        Button cancel = new Button("Отмена");
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                handleMenuItemSave();
                dialogStage.close();
            }
        });
        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (open) {
                    try {
                        handleMenuItemOpen();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    handleMenuItemNew();
                }
                dialogStage.close();
            }
        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //Action
                dialogStage.close();
            }
        });

        dialogStage.setTitle("  Сохранение");
        Text text = new Text("Сохранить набор?");
        text.setTranslateY(5);
        text.setScaleX(1.2);
        text.setScaleY(1.2);
        yes.setTranslateY(30);
        yes.setTranslateX(-60);
        no.setTranslateY(10);
        no.setTranslateX(-10);
        cancel.setTranslateY(-10);
        cancel.setTranslateX(50);
        dialogStage.setScene(new Scene(VBoxBuilder.create().
                prefHeight(100).prefWidth(200).
                children(text, yes, no, cancel).
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
        columnСoncentration.setMinWidth(115);
        columnСoncentration.setSortable(false);

        columnPressure.setCellFactory(cellFactory);
        columnPressure.setResizable(false);

        columnСoncentration.setCellFactory(cellFactory);
        columnСoncentration.setResizable(false);

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
        list.getColumns().get(0).setStyle("-fx-background-color:gray;");
        list.getColumns().get(1).setStyle("-fx-background-color:gray;");
        lineChart.setLegendVisible(false);

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

class BoundLine extends Line {

    BoundLine(DoubleProperty startX, DoubleProperty startY, DoubleProperty endX, DoubleProperty endY) {
        startXProperty().bind(startX);
        startYProperty().bind(startY);
        endXProperty().bind(endX);
        endYProperty().bind(endY);
        setStrokeWidth(2);
        setStroke(Color.GRAY.deriveColor(0, 1, 1, 0.5));
        setStrokeLineCap(StrokeLineCap.BUTT);
        getStrokeDashArray().setAll(10.0, 5.0);
    }
}

// a draggable anchor displayed around a point.
class Anchor extends Circle {

    Anchor(Color color, DoubleProperty x, DoubleProperty y) {
        super(x.get(), y.get(), 10);
        setFill(color.deriveColor(1, 1, 1, 0.5));
        setStroke(color);
        setStrokeWidth(2);
        setStrokeType(StrokeType.OUTSIDE);

        x.bind(centerXProperty());
        y.bind(centerYProperty());
        enableDrag();
    }

    // make a node movable by dragging it around with the mouse.
    private void enableDrag() {
        final Delta dragDelta = new Delta();
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = getCenterX() - mouseEvent.getX();
                dragDelta.y = getCenterY() - mouseEvent.getY();
                getScene().setCursor(Cursor.MOVE);
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getScene().setCursor(Cursor.HAND);
            }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double newX = mouseEvent.getX() + dragDelta.x;
                if (newX > 0 && newX < getScene().getWidth()) {
                    setCenterX(newX);
                }
                double newY = mouseEvent.getY() + dragDelta.y;
                if (newY > 0 && newY < getScene().getHeight()) {
                    setCenterY(newY);
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.HAND);
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.DEFAULT);
                }
            }
        });
    }

    // records relative x and y co-ordinates.
    private class Delta {

        double x, y;
    }
}

class PlayerPane extends Region {

    private MediaPlayer mp;
    private MediaView mediaView;
    private final boolean repeat = false;
    private boolean stopRequested = false;
    private boolean atEndOfMedia = false;
    private Duration duration;
    private Slider timeSlider;
    private Label playTime;
    private Slider volumeSlider;
    private ToolBar topBar = new ToolBar();
    private ToolBar bottomBar = new ToolBar();
    private HBox mediaTopBar;
    private HBox mediaBottomBar;
    private ParallelTransition transition = null;
    final double mediaWidth = 1000;
    final double mediaHeight = 565;
    private ChangeListener layoutListener = new ChangeListener() {
        @Override
        public void changed(ObservableValue ov, Object t, Object t1) {
            requestLayout();
        }
    };

    @Override
    protected void layoutChildren() {
        final double controlHeight = 50;//520;
        final double controlOffset = 265;
        mediaView.relocate(0, 0);
        mediaView.setFitWidth(mediaWidth);
        mediaView.setFitHeight(mediaHeight);
        topBar.resizeRelocate(0, 0, mediaWidth, controlHeight);
        bottomBar.resizeRelocate(controlOffset, mediaHeight - controlHeight, mediaWidth, controlHeight);
    }

    @Override
    protected double computeMinWidth(double height) {
        return mediaBottomBar.prefWidth(-1);
    }

    @Override
    protected double computeMinHeight(double width) {
        return 200;
    }

    @Override
    protected double computePrefWidth(double height) {
        return Math.max(mp.getMedia().getWidth(), mediaBottomBar.prefWidth(height));
    }

    @Override
    protected double computePrefHeight(double width) {
        return mp.getMedia().getHeight() + mediaBottomBar.prefHeight(width);
    }

    @Override
    protected double computeMaxWidth(double height) {
        return Double.MAX_VALUE;
    }

    @Override
    protected double computeMaxHeight(double width) {
        return Double.MAX_VALUE;
    }

    public PlayerPane(final MediaPlayer mp) {
        this.mp = mp;
        setId("player-pane");

        mediaView = new MediaView(mp);

        mediaTopBar = HBoxBuilder.create()
                .padding(new Insets(5, 10, 5, 10))
                .alignment(Pos.CENTER)
                .opacity(1.0)
                .build();

        mediaBottomBar = HBoxBuilder.create()
                .padding(new Insets(5, 10, 5, 10))
                .alignment(Pos.CENTER)
                .opacity(1.0)
                .build();

        topBar.setStyle("-fx-background-color: rgb(0,0,0.0,0.0);");
        bottomBar.setStyle("-fx-background-color: rgb(0,0,0.0,0.0);");

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (transition != null) {
                    transition.stop();
                }
                transition = ParallelTransitionBuilder.create()
                        .children(
                        FadeTransitionBuilder.create()
                        .node(topBar)
                        .toValue(1.0)
                        .duration(Duration.millis(200))
                        .interpolator(Interpolator.EASE_OUT)
                        .build(),
                        FadeTransitionBuilder.create()
                        .node(bottomBar)
                        .toValue(1.0)
                        .duration(Duration.millis(200))
                        .interpolator(Interpolator.EASE_OUT)
                        .build())
                        .build();
                transition.play();
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (transition != null) {
                    transition.stop();
                }
                transition = ParallelTransitionBuilder.create()
                        .children(
                        FadeTransitionBuilder.create()
                        .node(topBar)
                        .toValue(0.0)
                        .duration(Duration.millis(800))
                        .interpolator(Interpolator.EASE_OUT)
                        .build(),
                        FadeTransitionBuilder.create()
                        .node(bottomBar)
                        .toValue(0.0)
                        .duration(Duration.millis(800))
                        .interpolator(Interpolator.EASE_OUT)
                        .build())
                        .build();
                transition.play();
            }
        });

        mp.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                updateValues();
            }
        });
        mp.setOnPlaying(new Runnable() {
            public void run() {
                if (stopRequested) {
                    mp.pause();
                    stopRequested = false;
                }
            }
        });
        mp.setOnReady(new Runnable() {
            public void run() {
                duration = mp.getMedia().getDuration();
                updateValues();
            }
        });
        mp.setOnEndOfMedia(new Runnable() {
            public void run() {
                if (!repeat) {
                    stopRequested = true;
                    atEndOfMedia = true;
                }
            }
        });
        mp.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);

        // Time label
        Label timeLabel = LabelBuilder.create()
                .text("Time")
                .minWidth(Control.USE_PREF_SIZE)
                .textFill(Color.WHITE)
                .build();
        mediaTopBar.getChildren().add(timeLabel);

        // Time slider
        timeSlider = SliderBuilder.create()
                .id("media-slider")
                .minWidth(200)
                .maxWidth(Double.MAX_VALUE)
                .build();
        timeSlider.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (timeSlider.isValueChanging()) {
                    // multiply duration by percentage calculated by slider position
                    if (duration != null) {
                        mp.seek(duration.multiply(timeSlider.getValue() / 100.0));
                    }
                    updateValues();

                }
            }
        });
        mediaTopBar.getChildren().add(timeSlider);

        // Play label
        playTime = LabelBuilder.create()
                .prefWidth(75)
                .minWidth(75)
                .textFill(Color.WHITE)
                .build();
        mediaTopBar.getChildren().add(playTime);

        // Volume label
        Label volumeLabel = LabelBuilder.create()
                .text("Vol")
                .textFill(Color.WHITE)
                .minWidth(Control.USE_PREF_SIZE)
                .build();
        mediaTopBar.getChildren().add(volumeLabel);

        // Volume slider
        volumeSlider = SliderBuilder.create()
                .id("media-slider")
                .prefWidth(120)
                .minWidth(30)
                .maxWidth(Region.USE_PREF_SIZE)
                .build();
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
            }
        });
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (volumeSlider.isValueChanging()) {
                    mp.setVolume(volumeSlider.getValue() / 100.0);
                }
            }
        });
        mediaTopBar.getChildren().add(volumeSlider);

        final EventHandler<ActionEvent> backAction = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mp.seek(Duration.ZERO);
            }
        };
        final EventHandler<ActionEvent> stopAction = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mp.stop();
            }
        };
        final EventHandler<ActionEvent> playAction = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mp.play();
            }
        };
        final EventHandler<ActionEvent> pauseAction = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mp.pause();
            }
        };
        final EventHandler<ActionEvent> forwardAction = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Duration currentTime = mp.getCurrentTime();
                mp.seek(Duration.seconds(currentTime.toSeconds() + 5.0));
            }
        };

        mediaBottomBar = HBoxBuilder.create()
                .id("bottom")
                .spacing(0)
                .alignment(Pos.CENTER)
                .children(
                ButtonBuilder.create()
                .id("back-button")
                .text("Back")
                .onAction(backAction)
                .translateX(0)
                .build(),
                ButtonBuilder.create()
                .id("stop-button")
                .text("Stop")
                .onAction(stopAction)
                .translateX(10)
                .build(),
                ButtonBuilder.create()
                .id("play-button")
                .text("Play")
                .onAction(playAction)
                .translateX(20)
                .build(),
                ButtonBuilder.create()
                .id("pause-button")
                .text("Pause")
                .onAction(pauseAction)
                .translateX(30)
                .build(),
                ButtonBuilder.create()
                .id("forward-button")
                .text("Forward")
                .onAction(forwardAction)
                .translateX(40)
                .build())
                .build();

        topBar.getItems().add(mediaTopBar);
        bottomBar.getItems().add(mediaBottomBar);

        getChildren().addAll(mediaView, topBar, bottomBar);

        topBar.setOpacity(0.0);
        bottomBar.setOpacity(0.0);
    }

    protected void updateValues() {
        if (playTime != null && timeSlider != null && volumeSlider != null && duration != null) {
            Platform.runLater(new Runnable() {
                public void run() {
                    Duration currentTime = mp.getCurrentTime();
                    playTime.setText(formatTime(currentTime, duration));
                    timeSlider.setDisable(duration.isUnknown());
                    if (!timeSlider.isDisabled() && duration.greaterThan(Duration.ZERO) && !timeSlider.isValueChanging()) {
                        timeSlider.setValue(currentTime.divide(duration).toMillis() * 100.0);
                    }
                    if (!volumeSlider.isValueChanging()) {
                        volumeSlider.setValue((int) Math.round(mp.getVolume() * 100));
                    }
                }
            });
        }
    }

    private static String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60 - durationMinutes * 60;

            if (durationHours > 0) {
                return String.format("%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d",
                        elapsedMinutes, elapsedSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return String.format("%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d",
                        elapsedMinutes, elapsedSeconds);
            }
        }
    }
}

class DisplayShelf extends Region {

    private static final Duration DURATION = Duration.millis(500);
    private static final Interpolator INTERPOLATOR = Interpolator.EASE_BOTH;
    private static final double SPACING = 200;
    private static final double LEFT_OFFSET = -310;
    private static final double RIGHT_OFFSET = 310;
    private static final double SCALE_SMALL = 0.7;
    private PerspectiveImage[] items;
    private Group centered = new Group();
    private Group left = new Group();
    private Group center = new Group();
    private Group right = new Group();
    private int centerIndex = 0;
    private Timeline timeline;
    private ScrollBar scrollBar = new ScrollBar();
    private boolean localChange = false;
    private Rectangle clip = new Rectangle();

    public DisplayShelf(Image[] images) {
        // set clip
        setClip(clip);
        // set background gradient using css
        setStyle("-fx-background-color: linear-gradient(to bottom,"
                + " black 60, #141414 60.1%, black 100%);");
        // style scroll bar color
        scrollBar.setStyle("-fx-base: #202020; -fx-background: #202020;");
        // create items
        items = new PerspectiveImage[images.length];
        for (int i = 0; i < images.length; i++) {
            final PerspectiveImage item =
                    items[i] = new PerspectiveImage(images[i]);
            final double index = i;
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    localChange = true;
                    scrollBar.setValue(index);
                    localChange = false;
                    shiftToCenter(item);
                }
            });
        }
        // setup scroll bar
        scrollBar.setMax(items.length - 1);
        scrollBar.setVisibleAmount(1);
        scrollBar.setUnitIncrement(1);
        scrollBar.setBlockIncrement(1);
        scrollBar.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (!localChange) {
                    shiftToCenter(items[(int) scrollBar.getValue()]);
                }
            }
        });
        // create content
        centered.getChildren().addAll(left, right, center);
        getChildren().addAll(centered, scrollBar);
        // listen for keyboard events
        setFocusTraversable(true);
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.LEFT) {
                    shift(1);
                    localChange = true;
                    scrollBar.setValue(centerIndex);
                    localChange = false;
                } else if (ke.getCode() == KeyCode.RIGHT) {
                    shift(-1);
                    localChange = true;
                    scrollBar.setValue(centerIndex);
                    localChange = false;
                }
            }
        });
        // update
        update();
    }

    @Override
    protected void layoutChildren() {
        // update clip to our size
        clip.setWidth(getWidth());
        clip.setHeight(getHeight());
        // keep centered centered
        centered.setLayoutY((getHeight() - PerspectiveImage.HEIGHT) / 2);
        centered.setLayoutX((getWidth() - PerspectiveImage.WIDTH) / 2);
        // position scroll bar at bottom
        scrollBar.setLayoutX(10);
        scrollBar.setLayoutY(getHeight() - 25);
        scrollBar.resize(getWidth() - 20, 15);
    }

    private void update() {
        // move items to new homes in groups
        left.getChildren().clear();
        center.getChildren().clear();
        right.getChildren().clear();
        for (int i = 0; i < centerIndex; i++) {
            left.getChildren().add(items[i]);
        }
        center.getChildren().add(items[centerIndex]);
        for (int i = items.length - 1; i > centerIndex; i--) {
            right.getChildren().add(items[i]);
        }
        // stop old timeline if there is one running
        if (timeline != null) {
            timeline.stop();
        }
        // create timeline to animate to new positions
        timeline = new Timeline();
        // add keyframes for left items
        final ObservableList<KeyFrame> keyFrames = timeline.getKeyFrames();
        for (int i = 0; i < left.getChildren().size(); i++) {
            final PerspectiveImage it = items[i];
            double newX = -left.getChildren().size()
                    * SPACING + SPACING * i + LEFT_OFFSET;
            keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angle, 45.0, INTERPOLATOR)));
        }
        // add keyframe for center item
        final PerspectiveImage centerItem = items[centerIndex];
        keyFrames.add(new KeyFrame(DURATION,
                new KeyValue(centerItem.translateXProperty(), 0, INTERPOLATOR),
                new KeyValue(centerItem.scaleXProperty(), 1.0, INTERPOLATOR),
                new KeyValue(centerItem.scaleYProperty(), 1.0, INTERPOLATOR),
                new KeyValue(centerItem.angle, 90.0, INTERPOLATOR)));
        // add keyframes for right items
        for (int i = 0; i < right.getChildren().size(); i++) {
            final PerspectiveImage it = items[items.length - i - 1];
            final double newX = right.getChildren().size()
                    * SPACING - SPACING * i + RIGHT_OFFSET;
            keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angle, 135.0, INTERPOLATOR)));
        }
        // play animation
        timeline.play();
    }

    private void shiftToCenter(PerspectiveImage item) {
        for (int i = 0; i < left.getChildren().size(); i++) {
            if (left.getChildren().get(i) == item) {
                int shiftAmount = left.getChildren().size() - i;
                shift(shiftAmount);
                return;
            }
        }
        if (center.getChildren().get(0) == item) {
            return;
        }
        for (int i = 0; i < right.getChildren().size(); i++) {
            if (right.getChildren().get(i) == item) {
                int shiftAmount = -(right.getChildren().size() - i);
                shift(shiftAmount);
                return;
            }
        }
    }

    public void shift(int shiftAmount) {
        if (centerIndex <= 0 && shiftAmount > 0) {
            return;
        }
        if (centerIndex >= items.length - 1 && shiftAmount < 0) {
            return;
        }
        centerIndex -= shiftAmount;
        update();
    }
}

/**
 * A Node that displays a image with some 2.5D perspective rotation around the Y
 * axis.
 */
class PerspectiveImage extends Parent {

    private static final double REFLECTION_SIZE = 0.25;
    protected static final double WIDTH = 650;
    protected static final double HEIGHT = WIDTH + (WIDTH * REFLECTION_SIZE) - 250;
    private static final double RADIUS_H = WIDTH / 2;
    private static final double BACK = WIDTH / 5;
    private PerspectiveTransform transform = new PerspectiveTransform();
    /**
     * Angle Property
     */
    protected final DoubleProperty angle = new SimpleDoubleProperty(45) {
        @Override
        protected void invalidated() {
            // when angle changes calculate new transform
            double lx = (RADIUS_H - Math.sin(Math.toRadians(angle.get())) * RADIUS_H - 1);
            double rx = (RADIUS_H + Math.sin(Math.toRadians(angle.get())) * RADIUS_H + 1);
            double uly = (-Math.cos(Math.toRadians(angle.get())) * BACK);
            double ury = -uly;
            transform.setUlx(lx);
            transform.setUly(uly);
            transform.setUrx(rx);
            transform.setUry(ury);
            transform.setLrx(rx);
            transform.setLry(HEIGHT + uly);
            transform.setLlx(lx);
            transform.setLly(HEIGHT + ury);
        }
    };

    public final double getAngle() {
        return angle.getValue();
    }

    public final void setAngle(double value) {
        angle.setValue(value);
    }

    public final DoubleProperty angleModel() {
        return angle;
    }

    public PerspectiveImage(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setEffect(ReflectionBuilder.create().fraction(REFLECTION_SIZE).build());
        setEffect(transform);
        getChildren().addAll(imageView);
    }
}