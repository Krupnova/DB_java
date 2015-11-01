package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class TableViewExample {
    public Group root;
    private VBox box;
    public MySQLAccess db;
    private int width=500;
    private int height=400;

    public TableViewExample(Stage primaryStage) throws Exception{
        root = new Group();
        primaryStage.setTitle("University");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.setMinWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setMaxHeight(height);
        primaryStage.show();
        CreateForm();
    }

    private void CreateForm() throws SQLException {
        box = new VBox();
        HBox Hbox = new HBox();
        Hbox.setAlignment(Pos.CENTER);
        Hbox.getChildren().add(box);
        Hbox.setLayoutX(width / 2 - Hbox.getWidth() / 2);
        // Hbox.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().add(Hbox);
    }

    private void UpdateTable() throws SQLException {
        box=new VBox();

        final HBox hbox=new HBox();
        final Button add=new Button("Добавить");
        final Button delete=new Button("Удалить");
        final Button change=new Button("Изменить");
        hbox.getChildren().addAll(add,delete, change);
        hbox.setAlignment(Pos.BASELINE_CENTER);

        final LinkedList<String> tables = db.getTables();

        final TableView tableView=new TableView();

        final ChoiceBox cb = new ChoiceBox();
        cb.getItems().addAll(tables.get(0),tables.get(1),tables.get(3),tables.get(5),tables.get(7),tables.get(9),tables.get(11),tables.get(12));
        cb.getSelectionModel().selectFirst();
        cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                try {
                    LinkedList<String> columns = db.getColumns(cb.getItems().get((Integer) number2).toString());
                    ObservableList<Object> data = FXCollections.observableArrayList(db.SetBranchCollection(cb.getItems().get((Integer) number2).toString(), columns, db.objCollection, db.object));
                    tableView.getColumns().clear();

                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn tableColumn = new TableColumn();
                        tableColumn.setText(columns.get(i));
                        if (i==0) {
                            tableColumn.setMaxWidth(width / columns.size() / 2);
                            tableColumn.setMinWidth(width/columns.size()/2);
                        }else {
                            tableColumn.setMaxWidth((width - width/columns.size() / 2)/(columns.size()-1));
                            tableColumn.setMinWidth((width - width/columns.size() / 2)/(columns.size()-1));
                        }
                        tableColumn.setCellValueFactory(new PropertyValueFactory(columns.get(i)));
                        tableView.getColumns().add(tableColumn);
                    }
                    tableView.setItems(data);
                    db.objCollection=new LinkedList<Object>();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        box.getChildren().addAll(hbox, cb);




        final LinkedList<String> columns = db.getColumns(tables.get(0));
        db.objCollection=db.SetBranchCollection(tables.get(0), columns,db.objCollection,db.object);
        final ObservableList<Object> data = FXCollections.observableArrayList(
                db.objCollection
        );
        for (int i = 0; i < columns.size(); i++) {
            TableColumn tableColumn = new TableColumn();
            if (i==0) {
                tableColumn.setMaxWidth(width / columns.size() / 2);
                tableColumn.setMinWidth(width / columns.size() / 2);
            }else {
                tableColumn.setMaxWidth((width - width / columns.size() / 2) / (columns.size() - 1));
                tableColumn.setMinWidth((width - width / columns.size() / 2) / (columns.size() - 1));
            }
            tableColumn.setCellValueFactory(new PropertyValueFactory(columns.get(i)));
            tableColumn.setText(columns.get(i));
            tableView.getColumns().add(tableColumn);
        }
        tableView.setItems(data);
        db.objCollection=new LinkedList<Object>();
        box.getChildren().add(tableView);

        root.getChildren().add(box);
        db.getColumns(cb.getValue().toString());

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    AddRec(tables,cb,tableView);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeleteRec(cb, tableView);
            }
        });
        change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChangeRec(tables, cb, tableView);
            }
        });
    }
    private void AddRec(final LinkedList<String> tables, final ChoiceBox cb, final TableView tableView) throws SQLException {
        box.setVisible(false);
        box = new VBox();

        ClearScreen(0);
        final Label lbl = new Label("Введите данные.");
        final LinkedList<TextField> textFields = new LinkedList<TextField>();

        Object object;
        VBox AddForm=new VBox();
        object=cb.getValue().toString();
        AddForm.getChildren().add(lbl);

        LinkedList<String> columns = null;
        try {
            columns = db.getColumns(String.valueOf(object));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Label label;

        TextField txtField;
        for (int i = 0; i < columns.size(); i++) {
            label = new Label();
            label.setText(columns.get(i));
            txtField = new TextField();
            textFields.add(txtField);
            AddForm.getChildren().addAll(label, txtField);
        }
        box.getChildren().add(AddForm);

        final LinkedList<Object> insertData=new LinkedList<Object>();

        Button btn = new Button("Ок");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    for (int i=0;i<textFields.size();i++)
                        insertData.add(textFields.get(i).getText());
                    db.Adding(String.valueOf(cb.getValue()), insertData);
                    ClearScreen(15);
                    lbl.setText("Добавлено!");
                    UpdateTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        box.getChildren().addAll( btn, cb, tableView);
        root.getChildren().add(box);
    }
    private void DeleteRec(final ChoiceBox cb, final TableView tableView) {
        box.setVisible(false);
        ClearScreen(0);
        box=new VBox();
        HBox hbox=new HBox();
        final Label lbl=new Label("Укажите номер элемента, который вы хотите удалить.");
        final TextField num=new TextField();
        Button btndel=new Button("Ок");
        btndel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int number = Integer.parseInt(num.getText());
                    try {
                        db.Del(String.valueOf(cb.getValue()), number);
                        ClearScreen(15);
                        lbl.setText("Удалено!");
                        UpdateTable();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    lbl.setText("Проверьте правильность ввода и попробуйте еще раз");
                }
            }
        });
        hbox.getChildren().addAll(num,btndel);
        box.getChildren().addAll(lbl,hbox,cb,tableView);
        root.getChildren().add(box);
    }
    private void ChangeRec(final LinkedList<String> tables, final ChoiceBox cb, final TableView tableView) {
        box.setVisible(false);
        box = new VBox();

        ClearScreen(0);
        final Label lbl = new Label("Введите данные. Если поле не нужно изменять, оставьте его пустым.");
        final LinkedList<TextField> textFields = new LinkedList<TextField>();

        Object object;
        VBox AddForm=new VBox();
        object=cb.getValue().toString();
        AddForm.getChildren().add(lbl);

        LinkedList<String> columns = null;
        try {
            columns = db.getColumns(String.valueOf(object));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Label label;

        TextField txtField;
        for (int i = 0; i < columns.size(); i++) {
            label = new Label();
            label.setText(columns.get(i));
            txtField = new TextField();
            textFields.add(txtField);
            AddForm.getChildren().addAll(label, txtField);
        }
        box.getChildren().add(AddForm);

        final LinkedList<Object> updateData=new LinkedList<Object>();

        Button btn = new Button("Ок");
        final LinkedList<String> finalColumns = columns;
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    for (int i=0;i<textFields.size();i++)
                        updateData.add(textFields.get(i).getText());
                    db.Changing(String.valueOf(cb.getValue()), updateData, finalColumns);
                    ClearScreen(15);
                    lbl.setText("Изменено!");
                    UpdateTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        box.getChildren().addAll( btn, cb, tableView);
        root.getChildren().add(box);
    }

    private void OutputInformation() throws SQLException {

        UpdateTable();
    }

    private void ClearScreen(int dy) {
        javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle(800,400);
        rect.setLayoutX(0);
        rect.setLayoutY(dy);
        rect.setFill(javafx.scene.paint.Color.WHITE);
        rect.getStyleClass().add("my-rect");

        root.getChildren().addAll(rect);
    }

}
