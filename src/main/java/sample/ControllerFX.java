package sample;

import java.awt.*;
import java.net.URL;
import java.security.acl.Group;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Tables.Cathedra;

public class ControllerFX {

    private Stage guiRoot;
    private final String DB_LOGIN = "root";
    private final String DB_PASSWORD = "0000";
    private final String DB_SCHEMA_NAME = "univer";
    private Connection DB_CONNECTION = null;


    @FXML
    private Button update;
    @FXML
    private ToggleGroup TG1;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private RadioButton cathedra_rb;
    @FXML
    private RadioButton student_rb;
    @FXML
    private RadioButton faculty_rb;
    @FXML
    private RadioButton studentsGroup_rb;
    @FXML
    private RadioButton teacher_rb;
    @FXML
    private RadioButton EB_rb;
    @FXML
    private AnchorPane CathedraAdd;
    @FXML
    private AnchorPane EDAdd;
    @FXML
    private AnchorPane FacultyAdd;
    @FXML
    private AnchorPane StudentAdd;
    @FXML
    private AnchorPane TeacherAdd;
    @FXML
    private AnchorPane StudentsGroupAdd;
    @FXML
    private Tab tab_del;
    @FXML
    private Tab tab_upd;
    @FXML
    private Tab tab_add;
    @FXML
    private Tab tab_view;
    @FXML
    private AnchorPane pane_del;
    @FXML
    private AnchorPane EDDel;
    @FXML
    private AnchorPane FacultyDel;
    @FXML
    private AnchorPane TeacherDel;
    @FXML
    private AnchorPane StudentsGroupDel;
    @FXML
    private AnchorPane StudentUpdate;
    @FXML
    private AnchorPane FacultyUpdate;
    @FXML
    private AnchorPane CathedraDel;
    @FXML
    private AnchorPane EDUpdate;
    @FXML
    private AnchorPane StudentsGroupUpdate;
    @FXML
    private AnchorPane TeacherUpdate;
    @FXML
    private AnchorPane StudentDel;
    @FXML
    private AnchorPane CathedraUpdate;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="testButton"
    private Button testButton; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert testButton != null : "fx:id=\"testButton\" was not injected: check your FXML file 'sample.fxml'.";

        testButton.setOnAction(event -> {
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
            cathedra_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(true);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(true);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(true);

                //если нажата кнопка добавить запись то вызываем функцию с определенным типом запроса для опред талицы
                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.CATHEDRA, SQLQueryType.ADD);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.CATHEDRA, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.CATHEDRA, SQLQueryType.UPDATE);
                });

            });

            student_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(true);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(true);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(true);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.STUDENT, SQLQueryType.ADD);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.STUDENT, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.STUDENT, SQLQueryType.UPDATE);
                });
            });

            faculty_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(true);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(true);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(true);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.FACULTY, SQLQueryType.ADD);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.FACULTY, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.FACULTY, SQLQueryType.UPDATE);
                });
            });

            studentsGroup_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(true);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(true);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(true);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.GROUP, SQLQueryType.ADD);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.GROUP, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.GROUP, SQLQueryType.UPDATE);
                });
            });

            teacher_rb.setOnAction(event1 -> {
                EDAdd.setVisible(false);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(true);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(false);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(true);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(false);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(true);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.TEACHER, SQLQueryType.ADD);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.TEACHER, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.TEACHER, SQLQueryType.UPDATE);
                });
            });

            EB_rb.setOnAction(event1 -> {
                EDAdd.setVisible(true);
                StudentAdd.setVisible(false);
                StudentsGroupAdd.setVisible(false);
                TeacherAdd.setVisible(false);
                FacultyAdd.setVisible(false);
                CathedraAdd.setVisible(false);

                EDDel.setVisible(true);
                StudentDel.setVisible(false);
                StudentsGroupDel.setVisible(false);
                TeacherDel.setVisible(false);
                FacultyDel.setVisible(false);
                CathedraDel.setVisible(false);

                EDUpdate.setVisible(true);
                StudentUpdate.setVisible(false);
                StudentsGroupUpdate.setVisible(false);
                TeacherUpdate.setVisible(false);
                FacultyUpdate.setVisible(false);
                CathedraUpdate.setVisible(false);

                add.setOnAction(event2 -> {
                    AddToDatabase(SQLTable.BUILDING, SQLQueryType.ADD);
                });
                delete.setOnAction(event2 -> {
                    DeleteFromDatabase(SQLTable.BUILDING, SQLQueryType.DELETE);
                });
                update.setOnAction(event2 -> {
                    UpdateDatabase(SQLTable.BUILDING, SQLQueryType.UPDATE);
                });
            });

        });
    }
    @FXML
    private Button selectTable;

    public void setStage(Stage source) {
        this.guiRoot = source;
    }
    private void AddToDatabase(SQLTable table, SQLQueryType query){
        System.out.println("table " + table.toString() + " query " + query.toString());


    }

    private void DeleteFromDatabase(SQLTable table, SQLQueryType query) {
        System.out.println("table " + table.toString() + " query " + query.toString());


    }

    private void UpdateDatabase (SQLTable table, SQLQueryType query){
        System.out.println("table " + table.toString() + " query " + query.toString());


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
