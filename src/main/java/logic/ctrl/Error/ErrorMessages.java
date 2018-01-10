package logic.ctrl.Error;

import logic.DBApp;
import logic.ctrl.Controller;

/**
 * Created By Bartłomiej Woś
 */
public class ErrorMessages {

    private static String errorMessage = "";

    public static String loginError(){
        ErrorMessages.setErrorMessage("" +
                "Username or Password incorrect!");
        return getErrorMessage();
    }


    public static String getErrorMessage() {
        return errorMessage;
    }

    public static void setErrorMessage(String errorMessage) {
        ErrorMessages.errorMessage = errorMessage;
    }

    public static void setAndThrowMessage(String errorMessage){
        if(DBApp.instance().getActualController() != null) {
            ErrorMessages.errorMessage = errorMessage;
            DBApp.instance().getActualController().throwErrorMessage(errorMessage);
            //controller.throwErrorMessage(errorMessage);
        }else{
            System.out.println(errorMessage);
        }
    }
}
