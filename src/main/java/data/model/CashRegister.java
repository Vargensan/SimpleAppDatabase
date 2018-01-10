package data.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By Bartłomiej Woś
 */
public class CashRegister {

    private IntegerProperty cashID;
    private IntegerProperty money;
    private Date productionDate;

    public CashRegister(){
        cashID = new SimpleIntegerProperty();
        productionDate = new Date();
        money = new SimpleIntegerProperty();
    }

    public int getCashID() {
        return cashID.get();
    }

    public IntegerProperty cashIDProperty() {
        return cashID;
    }

    public void setCashID(int cashID) {
        this.cashID.set(cashID);
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getMoney() {
        return money.get();
    }

    public IntegerProperty moneyProperty() {
        return money;
    }

    public void setMoney(int money) {
        this.money.set(money);
    }
}
