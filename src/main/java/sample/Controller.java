/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
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
    }
}
