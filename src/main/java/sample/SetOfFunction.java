package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class SetOfFunction {
    Group root;
    MySQLAccess db;
    int width=500;
    int height=400;
    VBox box;
    boolean doctorRequest,registryRequest;
    Button request,makeRecord;
    LinkedList<String> tables;

    /*SetOfFunctions(Group root, MySQLAccess db, LinkedList<String> tables, boolean doctorRequest, boolean registryRequest){
        this.root=root;
        this.db=db;
        this.tables=tables;
        box=new VBox();
        this.doctorRequest=doctorRequest;
        this.registryRequest=registryRequest;
        request=new Button("Посмотреть");
        makeRecord=new Button("Записать");

    }*/

    public void UpdateTable() throws SQLException {
        box=new VBox();

        final HBox hbox=new HBox();
        final Button add=new Button("Добавить");
        final Button delete=new Button("Удалить");
        final Button change=new Button("Изменить");
        HBox hbox2=new HBox();
        if (doctorRequest==true){
            hbox2.getChildren().addAll(request);
        } else if (registryRequest==true){
            hbox2.getChildren().addAll(request,makeRecord);
            hbox.getChildren().addAll(add,delete, change);
        } else {
            hbox.getChildren().addAll(add, delete, change);
        }


        hbox.setAlignment(Pos.BASELINE_CENTER);

        final TableView tableView=new TableView();

        final ChoiceBox cb = new ChoiceBox();
        cb.getItems().addAll(tables);
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
        box.getChildren().addAll(hbox,hbox2, cb);




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
                    cb.setVisible(false);
                    AddRec(tables, cb, tableView);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeleteRec(tables,cb, tableView);
            }
        });
        /*change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cb.setVisible(false);
                ChangeRec(tables, cb, tableView);
            }
        });
        request.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MakeRequest();
            }
        });
        makeRecord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MakeRecord();
            }
        });*/
    }

    public void AddRec(final LinkedList<String> tables, final ChoiceBox cb, final TableView tableView) throws SQLException {
        box.setVisible(false);
        box = new VBox();

        //ClearScreen(0);
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

       // TextField txtField=new TextField(String.valueOf(db.CountRecords(String.valueOf(object))));
        /*textFields.add(txtField);
        for (int i = 1; i < columns.size(); i++) {
            label = new Label();
            label.setText(columns.get(i));
            txtField = new TextField();
            textFields.add(txtField);
            AddForm.getChildren().addAll(label, txtField);
        }*/
        box.getChildren().add(AddForm);

        Button btn = new Button("Ок");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    LinkedList<Object> insertData=new LinkedList<Object>();
                    int count=0;
                    for (int i=0;i<textFields.size();i++){
                        if (textFields.get(i).getText().equals(""))
                            count++;

                    }
                    if (count==0){
                        for (int i=0;i<textFields.size();i++){

                            if (((cb.getValue().equals("кабинет"))&&(i==1))||((cb.getValue().equals("услуга"))&&(i==2))||((cb.getValue().equals("специалист"))&&(i==3)))
                                insertData.add(Integer.parseInt(textFields.get(i).getText()));
                            else
                                insertData.add(textFields.get(i).getText());

                        }

                        db.Adding(String.valueOf(cb.getValue()), insertData);
                        //ClearScreen(15);
                        lbl.setText("Добавлено!");
                        cb.setVisible(true);
                        UpdateTable();
                    } else {
                        lbl.setText("Одно или более полей пропущены, попробуйте еще раз.");
                    }

                } catch (Exception e) {
                    lbl.setText("Ошибка, попробуйте еще раз");
                }
            }
        });

        box.getChildren().addAll( btn, cb, tableView);
        root.getChildren().add(box);
    }
    public void DeleteRec(final LinkedList<String> tables, final ChoiceBox cb, final TableView tableView) {
        box.setVisible(false);
       // ClearScreen(0);
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
                        //ClearScreen(15);
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
}
