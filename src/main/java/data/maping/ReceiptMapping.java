package data.maping;

import data.config.HibConfig;
import data.model.*;
import logic.ctrl.Error.ErrorMessages;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Receipt indatabase = Selection.getReceiptByID(receipt.getParagonID());
        if(indatabase != null) {
            ReceiptProductDetails receiptProductDetails = new ReceiptProductDetails();
            receiptProductDetails.setReceipt(receipt);
            receiptProductDetails.setProduct(product);
            try(Session session = HibConfig.getOpenSession()){
                session.save(receiptProductDetails);
            }catch (HibernateException e){
                ErrorMessages.setAndThrowMessage("Unable to add product!");
            }
        }else{
            ErrorMessages.setAndThrowMessage("No receipt in database!");
        }
    }

    public static void addProductToReceipt(int receiptID, Product product){
        Receipt receipt = Selection.getReceiptByID(receiptID);
        if(receipt != null){
            addProductToReceipt(receipt,product);
        }
    }

    public static void removeProductFromReceipt(){
        ReceiptProductDetails receiptProductDetails = new ReceiptProductDetails();

    }

    public static void cancelReceipt(int receiptID){
        Receipt indatabase = Selection.getReceiptByID(receiptID);
        if(indatabase != null){
            try(Session session = HibConfig.getOpenSession()){
                Transaction tn = session.beginTransaction();
                ReceiptDetails receiptDetails = indatabase.getReceiptDetails();
                receiptDetails.setCanceled(true);

                session.update(receiptDetails);
                tn.commit();
            }
        }else{
            ErrorMessages.setAndThrowMessage("No receipt in database!");
        }
    }

    public static void insertReceipt(Receipt receipt){
        boolean isUp;
        try (Session session = HibConfig.getOpenSession()) {
            isUp = HibConfig.isTransictionUp(session);
            if(!isUp) {
                Transaction tn = session.beginTransaction();
            }
            session.save(receipt);
            if(!isUp) {
                HibConfig.getTransiction(session).commit();
            }
        }catch (HibernateException p) {
            ErrorMessages.setAndThrowMessage("Worker: Couldn't Execute Statement!");
        }
    }
}
