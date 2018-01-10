package data.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created By Bartłomiej Woś
 */
public class ReceiptProductDetails {
    private IntegerProperty uniqueID;
    private Receipt receipt;
    private Product product;

    public ReceiptProductDetails(){
        uniqueID = new SimpleIntegerProperty();
    }

    public Receipt getReceipt() {
        return receipt;
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

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
