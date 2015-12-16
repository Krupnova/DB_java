/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package sample;

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
import java.util.ArrayList;
import java.util.LinkedList;


public class Controller {

    public Group root;
    private VBox box;
    public String log;
    public String psswrd;
    public MySQLAccess db;
    private int width=500;
    private int height=400;

    public Controller(Stage primaryStage) throws Exception{
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
        box=new VBox();
        HBox Hbox=new HBox();
        Hbox.setAlignment(Pos.CENTER);
        Hbox.getChildren().add(box);
        Hbox.setLayoutX(width / 2 - Hbox.getWidth() / 2);
        root.getChildren().add(Hbox);

        final Label logn=new Label("For connecting to the database press the button ");
        final Button ok=new Button("Ok");

        box.setAlignment(Pos.TOP_CENTER);
        box.maxWidth(width);
        box.minWidth(width);
        box.getChildren().addAll(logn, ok);

        log = "root";
        psswrd = "0000";

        Hbox.setLayoutX(width / 2 - 135);
        Hbox.setLayoutY(height / 2 - 80);

        ok.setOnAction(event -> {

            try {
                db = new MySQLAccess("univer", log, psswrd);
                logn.setVisible(false);
                ok.setVisible(false);
                /*final Button qq=new Button("qq");
                ok.setLayoutX(width / 2 - 80);
                ok.setLayoutY(height / 2 - 80);
                box.setAlignment(Pos.TOP_CENTER);
                box.maxWidth(width);
                box.minWidth(width);
                box.getChildren().addAll(qq);*/
                OutputInformation();
               /* final Button qq=new Button("qq");
                ok.setLayoutX(width / 2 - 80);
                ok.setLayoutY(height / 2 - 80);
                box.setAlignment(Pos.TOP_CENTER);
                box.maxWidth(width);
                box.minWidth(width);
                box.getChildren().addAll(qq);*/

            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println(e);
            }
        });

    }
    private void OutputInformation() throws SQLException {

        System.out.println("qq");
        HBox hbox=new HBox();

        Button add=new Button("Add");
        Button delete=new Button("Delete");
       // Button change = new Button("Change");
       // hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.getChildren().addAll(add,delete);
        hbox.setAlignment(Pos.BASELINE_CENTER);
       /* final LinkedList<String> tables = db.getTables();

        final LinkedList<String> columns = db.getColumns(tables.get(7));

        db.objCollection=db.SetBranchCollection("cathedra", columns,db.objCollection,db.object);
        final ObservableList<Object> data = FXCollections.observableArrayList(
                db.objCollection
        );



        TableView tableView=new TableView();

        for (int i=0;i<columns.size();i++){
            TableColumn col=new TableColumn();
            col.setText(columns.get(i));
            if (i==0) {
                col.setMaxWidth(width / columns.size() / 2);
                col.setMinWidth(width/columns.size()/2);
            }else {
                col.setMaxWidth((width - width/columns.size() / 2)/(columns.size()-1));
                col.setMinWidth((width - width/columns.size() / 2)/(columns.size()-1));
            }
            col.setCellValueFactory(new PropertyValueFactory(columns.get(i)));
            tableView.getColumns().add(col);
        }
        tableView.setItems(data);

        box=new VBox();
        tableView.setMaxWidth(width);
        tableView.setMinWidth(width);
        box.getChildren().addAll(hbox, tableView);
        root.getChildren().add(box);
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                box = new VBox();
                root.getChildren().add(box);
                final ArrayList<TextField> adding=new ArrayList<TextField>();
                ArrayList<Label> labels=new ArrayList<Label>();
                Button ok=new Button("Ok");
                TextField txt=new TextField();
                Label lbl=new Label();

                for(int i=0;i<columns.size();i++){
                    lbl.setText("Enter "+columns.get(i));

                    adding.add(txt);
                    labels.add(lbl);*/
//                    box.getChildren().addAll(lbl,txt);
                }

           /*     ok.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                           // db.Adding(tables.get(12),adding);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                });*/
          //  }
        //});


   // }

}
