package data.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * Created By Bartłomiej Woś
 */
public class User implements Serializable{

    private IntegerProperty id;
    private IntegerProperty accessLevel;
    private StringProperty userName;
    private StringProperty userPassword;
    private Worker worker;

    public User(){
        id = new SimpleIntegerProperty();
        userName = new SimpleStringProperty();
        accessLevel = new SimpleIntegerProperty();
        userPassword = new SimpleStringProperty();
    }


    public int getAccessLevel() {
        return accessLevel.get();
    }

    public IntegerProperty accessLevelProperty() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel.set(accessLevel);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getUserPassword() {
        return userPassword.get();
    }

    public StringProperty userPasswordProperty() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword.set(userPassword);
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
