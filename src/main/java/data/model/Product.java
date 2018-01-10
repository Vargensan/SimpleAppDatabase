package data.model;

import javafx.beans.property.*;

import java.util.Date;

/**
 * Created By Bartłomiej Woś
 */
public class Product {

    private IntegerProperty productID;
    private StringProperty productName;
    private StringProperty producentName;
    private FloatProperty productCost;

    public Product(){
        productID = new SimpleIntegerProperty();
        producentName = new SimpleStringProperty();
        productName = new SimpleStringProperty();
        productCost = new SimpleFloatProperty();

    }


    public int getProductID() {
        return productID.get();
    }

    public IntegerProperty productIDProperty() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public String getProductName() {
        return productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public String getProducentName() {
        return producentName.get();
    }

    public StringProperty producentNameProperty() {
        return producentName;
    }

    public void setProducentName(String producentName) {
        this.producentName.set(producentName);
    }


    public float getProductCost() {
        return productCost.get();
    }

    public FloatProperty productCostProperty() {
        return productCost;
    }

    public void setProductCost(float productCost) {
        this.productCost.set(productCost);
    }

}
