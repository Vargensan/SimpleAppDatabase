package logic.ctrl.LoginController;

import logic.ctrl.Controller;

public class MainController extends Controller {


    public MainController(){

    }

    @Override
    public void throwErrorMessage(String ErrorMessage) {
        System.out.println(ErrorMessage);
    }

    @Override
    public void initializeListeners() {

    }
}
