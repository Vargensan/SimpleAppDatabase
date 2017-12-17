package beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created By Bartłomiej Woś
 */
public class Receipt {

    StringProperty cashID;
    IntegerProperty paragonID;

    StringProperty productsOrdered;

    SimpleDateFormat dateFormat;

    DateFormat paragonDate;
    StringProperty recipentName;


}
