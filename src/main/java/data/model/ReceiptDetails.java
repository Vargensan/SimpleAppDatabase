package data.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Date;

/**
 * Created By Bartłomiej Woś
 */
public class ReceiptDetails {
    private IntegerProperty uniqueID;
    private Date dateFormat;
    private Receipt receipt;
    private BooleanProperty canceled;

    public ReceiptDetails(){
        uniqueID = new SimpleIntegerProperty();
        canceled = new SimpleBooleanProperty(false);
    }

    public boolean isCanceled() {
        return canceled.get();
    }

    public BooleanProperty canceledProperty() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled.set(canceled);
    }

    public Date getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(Date dateFormat) {
        this.dateFormat = dateFormat;
    }

    public int getUniqueID() {
        return uniqueID.get();
    }

    public IntegerProperty uniqueIDProperty() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID.set(uniqueID);
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}
