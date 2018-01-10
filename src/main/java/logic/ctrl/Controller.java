package logic.ctrl;

import javafx.stage.Stage;

/**
 * Created By Bartłomiej Woś
 */
public abstract class Controller {

    Stage mainStage;

    public Controller(){

    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void throwErrorMessage(String ErrorMessage){
        System.out.println(ErrorMessage);
    }

    public abstract void initializeListeners();
}
