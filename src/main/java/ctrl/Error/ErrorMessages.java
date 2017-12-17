package ctrl.Error;

import ctrl.Controller;

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

    public static void setAndThrowMessage(String errorMessage,Controller controller){
        ErrorMessages.errorMessage = errorMessage;
        controller.ThrowErrorMessage(errorMessage);
    }

    public static void throwErrorMessage(Controller controller){
        controller.ThrowErrorMessage(errorMessage);
    }
}
