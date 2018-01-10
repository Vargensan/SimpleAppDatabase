package logic.ctrl.LoginController;

import logic.DBApp;
import logic.seciourity.Validation;
import data.model.User;
import logic.ctrl.Controller;
import logic.ctrl.Error.ErrorMessages;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.ChangeRoot;
import data.maping.Selection;
import usergui.utils.ViewInstance;

/**
 * Created By Bartłomiej Woś
 */
public class LoginController extends Controller {


    @FXML
    public TextField errorMessage;
    @FXML
    public Button submit;
    @FXML
    public TextField login;
    @FXML
    public TextField password;

    public LoginController(){
      //  addListeners();
    }

 //   public void initialize(){
 //       addListeners();
  //  }


    @Override
    public void initializeListeners() {
        addListeners();
    }

    private void addListeners(){
            submit.setOnAction(event -> {
                System.out.println("ok");
                String loginText;
                String passwordText;
                loginText = login.getText();
                passwordText = password.getText();
                tryToLogin(loginText, passwordText);

            });
    }

    private void tryToLogin(String loginText, String passwordText){
        try {
            if (Validation.isPasswordCorrect(passwordText,Selection.getUserByLogin(loginText).getUserPassword())) {
                ChangeRoot.changeLayoutLevelAccess(ViewInstance.MAIN_VIEW);
            } else {
                ErrorMessages.setAndThrowMessage("Invalid Password!");
            }
        }catch(NullPointerException e){
            ErrorMessages.setAndThrowMessage("Exception: User Does Not Exist!");
        }
    }

    @Override
    public void throwErrorMessage(String ErrorMessage) {
        errorMessage.setText(ErrorMessage);
    }
}
