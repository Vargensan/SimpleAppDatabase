package beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * Created By Bartłomiej Woś
 */
public class LoginUser implements Serializable{

    private IntegerProperty id;
    private IntegerProperty accessLevel;
    private StringProperty userName;
    private StringProperty userPassword;

    public LoginUser(){
        id = new SimpleIntegerProperty();
        userName = new SimpleStringProperty();
        accessLevel = new SimpleIntegerProperty();
        userPassword = new SimpleStringProperty();
    }
    public LoginUser(String username, String userpassword){
        id = new SimpleIntegerProperty();
        userName = new SimpleStringProperty();
        accessLevel = new SimpleIntegerProperty();
        userPassword = new SimpleStringProperty();
        setAccessLevel(1);
        setUserName(username);
        setUserPassword(userpassword);
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
}
