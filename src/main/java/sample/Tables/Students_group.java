package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class Students_group {
    private StringProperty name_group;
    private StringProperty name_faculty;
    private IntegerProperty number_course;
    private StringProperty direction;
    private StringProperty name_cathedra;

    public Students_group(String name_group, String name_faculty, int number_course, String direction, String name_cathedra){
        this.name_group = new SimpleStringProperty(name_group);
        this.name_faculty = new SimpleStringProperty(name_faculty);
        this.number_course = new SimpleIntegerProperty(number_course);
        this.direction = new SimpleStringProperty(direction);
        this.name_cathedra = new SimpleStringProperty(name_cathedra);
    }

    public Students_group(LinkedList<String> fields){
        this.name_group = new SimpleStringProperty(fields.get(0));
        this.name_faculty = new SimpleStringProperty(fields.get(1));
        this.number_course = new SimpleIntegerProperty(Integer.parseInt(fields.get(2)));
        this.direction = new SimpleStringProperty(fields.get(3));
        this.name_cathedra = new SimpleStringProperty(fields.get(4));

    }
}
