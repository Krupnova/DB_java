package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class Student {
    private IntegerProperty number_record_book;
    private StringProperty last_name;
    private IntegerProperty year_birth;
    private StringProperty name_group;

    public Student(int number_record_book, String last_name, int year_birth, String name_group){
        this.number_record_book = new SimpleIntegerProperty(number_record_book);
        this.last_name = new SimpleStringProperty(last_name);
        this.year_birth = new SimpleIntegerProperty(year_birth);
        this.name_group = new SimpleStringProperty(name_group);
    }

    public Student(LinkedList<String> fields){
        this.number_record_book = new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.last_name = new SimpleStringProperty(fields.get(1));
        this.year_birth = new SimpleIntegerProperty(Integer.parseInt(fields.get(2)));
        this.name_group = new SimpleStringProperty(fields.get(3));
    }
}
