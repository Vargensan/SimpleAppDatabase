package ctrl.LoginController;

import Seciourity.Validation;
import beans.LoginUser;
import ctrl.Controller;
import ctrl.Error.ErrorMessages;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.ChangeRoot;
import logic.MainApplication;
import maping.Selection;

import javax.persistence.NoResultException;

/**
 * Created By Bartłomiej Woś
 */
public class LoginController extends Controller {


    MainApplication mainApplication;
    @FXML
    public TextField errorMessage;
    @FXML
    public Button submit;
    @FXML
    public TextField login;
    @FXML
    public TextField password;



    public LoginController(){

    }

    public LoginController(MainApplication mainApplication){
        this.mainApplication = mainApplication;
        addListeners();
    }

    public void initialize(){
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

    public void tryToLogin(String loginText, String passwordText){
        LoginUser loginUser;
        loginUser = Selection.getUserByLogin(loginText);
        if(loginUser !=  null) {
            boolean isCorrect = Validation.isPasswordCorrect(passwordText, loginUser.getUserPassword());
            if (isCorrect) {
                ChangeRoot.changeLayoutLevelAccess();
            } else {
                ErrorMessages.setErrorMessage("Invalid Password!");
                ErrorMessages.throwErrorMessage(this);
            }
        }else{
            ErrorMessages.setErrorMessage("User Does Not Exist!");
            ErrorMessages.throwErrorMessage(this);

        }
    }

    @Override
    public void ThrowErrorMessage(String ErrorMessage) {
        errorMessage.setText(ErrorMessage);
    }
}
