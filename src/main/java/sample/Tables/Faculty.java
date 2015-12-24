package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class Faculty {
    private StringProperty name_faculty;
    private StringProperty dean;
    private IntegerProperty phone_dean;
    private IntegerProperty number_students;

    public Faculty(String name_faculty, String dean, int phone_dean, int number_students){
        this.name_faculty = new SimpleStringProperty(name_faculty);
        this.dean = new SimpleStringProperty(dean);
        this.phone_dean = new SimpleIntegerProperty(phone_dean);
        this.number_students = new SimpleIntegerProperty(number_students);
    }

    public String getName_faculty() {
        return name_faculty.get();
    }

    public StringProperty name_facultyProperty() {
        return name_faculty;
    }

    public String getDean() {
        return dean.get();
    }

    public StringProperty deanProperty() {
        return dean;
    }

    public int getPhone_dean() {
        return phone_dean.get();
    }

    public IntegerProperty phone_deanProperty() {
        return phone_dean;
    }

    public int getNumber_students() {
        return number_students.get();
    }

    public IntegerProperty number_studentsProperty() {
        return number_students;
    }

    public Faculty(LinkedList<String> fields){
        this.name_faculty = new SimpleStringProperty(fields.get(0));
        this.dean = new SimpleStringProperty(fields.get(1));
        this.phone_dean = new SimpleIntegerProperty(Integer.parseInt(fields.get(2)));
        this.number_students = new SimpleIntegerProperty(Integer.parseInt(fields.get(3)));

    }
}
