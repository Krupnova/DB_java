package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class Education_building {
    private IntegerProperty number_EB;
    private StringProperty address;
    private IntegerProperty phone_EB;

    public Education_building(int number_EB, String address, int phone_EB){
        this.number_EB = new SimpleIntegerProperty(number_EB);
        this.address = new SimpleStringProperty(address);
        this.phone_EB = new SimpleIntegerProperty(phone_EB);
    }
    public  Education_building(LinkedList<String> fields){
        this.number_EB = new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.address = new SimpleStringProperty(fields.get(1));
        this.phone_EB = new SimpleIntegerProperty(Integer.parseInt(fields.get(2)));

    }

}
