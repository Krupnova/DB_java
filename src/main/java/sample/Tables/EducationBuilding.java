package sample.Tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

/**
 * Created by Дарья on 01.11.2015.
 */
public class EducationBuilding {
    private IntegerProperty number_EB;
    private StringProperty address;
    private IntegerProperty phone_EB;

    public EducationBuilding(int number_EB, String address, int phone_EB){
        this.number_EB = new SimpleIntegerProperty(number_EB);
        this.address = new SimpleStringProperty(address);
        this.phone_EB = new SimpleIntegerProperty(phone_EB);

    }
    public int getNumber_EB() {
        return number_EB.get();
    }

    public IntegerProperty number_EBProperty() {
        return number_EB;
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public int getPhone_EB() {
        return phone_EB.get();
    }

    public IntegerProperty phone_EBProperty() {
        return phone_EB;
    }


    public EducationBuilding(LinkedList<String> fields){
        this.number_EB = new SimpleIntegerProperty(Integer.parseInt(fields.get(0)));
        this.address = new SimpleStringProperty(fields.get(1));
        this.phone_EB = new SimpleIntegerProperty(Integer.parseInt(fields.get(2)));

    }

}
