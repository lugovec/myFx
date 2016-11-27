package sample.objects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by andrey on 16.11.16.
 */
public class Person {
    private SimpleStringProperty fio = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");

    public  Person() {

    }

    public Person(String fio, String phone) {
        this.fio = new SimpleStringProperty(fio);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getFio() {
        return fio.get();
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public SimpleStringProperty fioProperty() {
        return fio;
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }
}
