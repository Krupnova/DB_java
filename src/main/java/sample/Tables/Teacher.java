package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class Teacher {
    private IntegerProperty personal_number;
    private StringProperty last_name;
    private StringProperty job_title;
    private StringProperty degree;
    private StringProperty name_cathedra;
    private IntegerProperty phone;
    private StringProperty address;

    public Teacher(int personal_number, String last_name, String job_title, String degree, String name_cathedra, int phone, String address){

        this.personal_number = new SimpleIntegerProperty(personal_number);
        this.last_name = new SimpleStringProperty(last_name);
        this.job_title = new SimpleStringProperty(job_title);
        this.degree = new SimpleStringProperty(degree);
        this.name_cathedra = new SimpleStringProperty(name_cathedra);
        this.phone = new SimpleIntegerProperty(phone);
        this.address = new SimpleStringProperty(address);
    }

    public Teacher(LinkedList<String> fields){
        this.personal_number = new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.last_name = new SimpleStringProperty(fields.get(1));
        this.job_title = new SimpleStringProperty(fields.get(2));
        this.degree = new SimpleStringProperty(fields.get(3));
        this.name_cathedra = new SimpleStringProperty(fields.get(4));
        this.phone = new SimpleIntegerProperty(Integer.parseInt(fields.get(5)));
        this.address = new SimpleStringProperty(fields.get(6));
    }
}
