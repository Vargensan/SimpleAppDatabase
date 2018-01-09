package ctrl.LoginController;

import logic.DatabaseApplication;
import logic.seciourity.Validation;
import data.model.LoginUser;
import ctrl.Controller;
import ctrl.Error.ErrorMessages;
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


    DatabaseApplication databaseApplication;
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

    public LoginController(DatabaseApplication databaseApplication){
        this.databaseApplication = databaseApplication;
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
                ChangeRoot.changeLayoutLevelAccess(ViewInstance.MAIN_VIEW);
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
