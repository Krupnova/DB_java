package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class Cathedra {

    private StringProperty name_cathedra;
    private StringProperty head_department;
    private IntegerProperty phone_department;
    private IntegerProperty number_EB;

    public Cathedra(String name_cathedra, String head_department, int phone_department, int number_EB){
        this.name_cathedra = new SimpleStringProperty(name_cathedra);
        this.head_department = new SimpleStringProperty(head_department);
        this.phone_department = new SimpleIntegerProperty(phone_department);
        this.number_EB = new SimpleIntegerProperty(number_EB);
    }
public Cathedra(LinkedList<String> fields){
    this.name_cathedra = new SimpleStringProperty(fields.get(0));
    this.head_department = new SimpleStringProperty(fields.get(1));
    this.phone_department = new SimpleIntegerProperty(Integer.parseInt(fields.get(2)));
    this.number_EB = new SimpleIntegerProperty(Integer.parseInt(fields.get(3)));

}

}
