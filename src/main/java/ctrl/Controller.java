package ctrl;

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

    public abstract void ThrowErrorMessage(String ErrorMessage);
}
