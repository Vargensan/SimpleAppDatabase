package data.maping;

import data.model.Product;
import data.model.Receipt;
import data.model.ReceiptDetails;
import data.model.ReceiptProductDetails;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created By Bartłomiej Woś
 */
public class ReceiptMapping {

    public ReceiptMapping(){

    }

    public static Receipt makeNewReceipt(){
        Receipt receipt = new Receipt();
        ReceiptDetails receiptDetails = new ReceiptDetails();
        LocalDate localDate = LocalDate.now();

        receiptDetails.setReceipt(receipt);
        receiptDetails.setDateFormat(Date.valueOf(localDate));
        return receipt;
    }

    public static ReceiptDetails getReceiptDetailsForReceipt(Receipt receipt){
        return receipt.getReceiptDetails();

    }

    public static void addProductToReceipt(Receipt receipt,Product product){
        ReceiptProductDetails receiptProductDetails = new ReceiptProductDetails();
        receiptProductDetails.setReceipt(receipt);
        receiptProductDetails.setProduct(product);
    }

    public static void removeProductFromReceipt(){
        ReceiptProductDetails receiptProductDetails = new ReceiptProductDetails();

    }


    public static void insertReceipt(){


    }
}
