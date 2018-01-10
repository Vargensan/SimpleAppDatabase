package data.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import logic.Database;

import java.io.Serializable;
import java.util.Date;

public class Worker implements Serializable{

    private StringProperty personalID;

    private StringProperty name;
    private StringProperty surname;
    private StringProperty position;
    private Date birthDate;

    public Worker(){
        personalID = new SimpleStringProperty();
        name = new SimpleStringProperty();
        surname = new SimpleStringProperty();
        position = new SimpleStringProperty();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonalID() {
        return personalID.get();
    }

    public StringProperty personalIDProperty() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID.set(personalID);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}
