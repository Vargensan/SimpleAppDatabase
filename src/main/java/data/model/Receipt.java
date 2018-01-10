package data.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By Bartłomiej Woś
 */
public class Receipt {

    private IntegerProperty paragonID;
    private CashRegister cashRegister;
    private Worker worker;
    private ReceiptDetails receiptDetails;
    private ReceiptProductDetails receiptProductDetails;


    public Receipt(){
        paragonID = new SimpleIntegerProperty();
    }

    public int getParagonID() {
        return paragonID.get();
    }

    public IntegerProperty paragonIDProperty() {
        return paragonID;
    }

    public void setParagonID(int paragonID) {
        this.paragonID.set(paragonID);
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public ReceiptDetails getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(ReceiptDetails receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    public ReceiptProductDetails getReceiptProductDetails() {
        return receiptProductDetails;
    }

    public void setReceiptProductDetails(ReceiptProductDetails receiptProductDetails) {
        this.receiptProductDetails = receiptProductDetails;
    }
}
