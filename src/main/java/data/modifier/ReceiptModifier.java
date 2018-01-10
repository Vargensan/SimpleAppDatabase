package data.modifier;

import data.model.Product;
import data.model.Receipt;

public class ReceiptModifier {

    Receipt receipt;

    public ReceiptModifier(Receipt receipt){
        this.receipt = receipt;
    }

    public void addProduct(Product product){

    }

    public void removeProduct(Product product){

    }

    public void acceptReceipt(){

    }

    public void rejectReceipt(){

    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
    }
}
