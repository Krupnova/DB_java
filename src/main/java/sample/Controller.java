/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Controller {

  /*  @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="someAction"
    private Button someAction; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert someAction != null : "fx:id=\"someAction\" was not injected: check your FXML file 'sample.fxml'.";

        someAction.setOnMouseClicked(
                event -> {
                    try {
                        System.out.println("Mouse clicked triggered");
                        getDBConnect();
                        someAction.setText("YES :)");
                        //System.out.println("Connection info: " + SQLITE);
                        //connectionTest();
                    } catch (Exception e) {
                        someAction.setText("NOPE :(");
                    }
                    //someAction.setText("YES :)");
                }
        );
    }

    private Connection SQLITE = null;
    private final String DATABASE = "H:/Univer.db";

    private void getDBConnect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        System.out.println("Getting connect");
        //вот тут он начинает не работать
        SQLITE = DriverManager.getConnection("jdbc:sqlite:" + DATABASE);
        System.out.println("qq");
        System.out.println("SQLITE: " + SQLITE);
        connectionTest();
    }

    private void connectionTest() throws SQLException {
        java.sql.Statement stmt = SQLITE.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student;");
        System.out.println("Is result set null?: " + (rs == null));
        while (rs.next()) {
            System.out.println(rs.getString("Last_name"));
        }
    }*/

    public Group root;
    private VBox box;
    private String log;
    private String psswrd;
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
        // Hbox.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().add(Hbox);
        final Label logn=new Label("¬ведите  ");
        final Button ok=new Button("Ok");
        box.getChildren().addAll(logn, ok);
        log = "root";
        psswrd = "password";

        Hbox.setLayoutX(width / 2 - 80);
        Hbox.setLayoutY(height/2-80);

        try {
           db = new MySQLAccess("univer", log, psswrd);
            OutputInformation();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void OutputInformation() throws SQLException {

        HBox hbox=new HBox();
        Button add=new Button("Add");
        Button delete=new Button("Delete");
        hbox.getChildren().addAll(add,delete);
        hbox.setAlignment(Pos.BASELINE_CENTER);

        final LinkedList<String> tables = db.getTables();

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
                    labels.add(lbl);
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
            }
        });


    }

}
