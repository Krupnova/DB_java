package sample;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerFX {

    private Stage guiRoot;
    private final String DB_LOGIN = "root";
    private final String DB_PASSWORD = "0000";
    private final String DB_SCHEMA_NAME = "univer";
    private Connection DB_CONNECTION = null;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="testButton"
    private Button testButton; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert testButton != null : "fx:id=\"testButton\" was not injected: check your FXML file 'sample.fxml'.";

        testButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button was pressed!");

                try {
                    DB_CONNECTION = getConnection();

                    if (DB_CONNECTION != null)
                        System.out.println("Got a connection!");

                    System.out.println();
                    ResultSet test = getResultFromDB(
                            SQLQueryType.SELECT,
                            "cathedra"
                    );

                    while (test.next()) {
                        System.out.println(test.getString(1));
                    }

                    ResultSet test2 = getResultFromDB(
                            SQLQueryType.SELECT,
                            "cathedra",
                            "head_of_department",
                            getSQLString("Vahidov")
                    );

                    while (test2.next()) {
                        System.out.println(test2.getString(2));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setStage(Stage source) {
        this.guiRoot = source;
    }

    /*
    * Транзакция - это комплексная операция, состоящая из группы операций, которые выполняются либо все,
    * либо ни одной в случае ошибки или отмены.
    *
    * Каждое действие с БД - транзакция.
    * Транзакция завершается только после вызова метода commit (если в начале работы с базой было вызвано setAutoCommit(false)).
    * */

    public void stopController() throws SQLException {
        if (DB_CONNECTION != null) {
            DB_CONNECTION.close();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_SCHEMA_NAME +
                "?user=" + DB_LOGIN + "&password=" + DB_PASSWORD);
    }

    private String getSQLString(String source) {
        if (source == null) return source;

        return '\'' + source + '\'';
    }

    private ResultSet getResultFromDB(SQLQueryType type, String... args) throws Exception {
        ResultSet result = null;

        switch(type) {
            case SELECT: {
                // SELECT columns FROM table WHERE conditions;
                // conditions => column_name = value
                if (args.length % 2 == 0 || args.length > 3) {
                    throw new SQLException("Invalid number of agruments for SELECT statement.");
                } else {
                    Statement statement = DB_CONNECTION.createStatement();

                    if (args.length == 1) {
                        result = statement.executeQuery("SELECT * FROM " + DB_SCHEMA_NAME + '.' + args[0]);
                    } else {
                        result = statement.executeQuery("SELECT * FROM " + DB_SCHEMA_NAME + '.' + args[0]
                                + " WHERE " + args[1] + " = " + args[2]);
                    }
                }
                break;
            }
        }

        return result;
    }
}
