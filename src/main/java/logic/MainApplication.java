package logic;

import ctrl.LoginController.LoginController;
import hibernate.HibConfig;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import maping.Selection;
import maping.UserMapping;

/**
 * Created By Bartłomiej Woś
 */
public class MainApplication extends Application{

    static private Stage primaryStage;
    private BorderPane rootLayout;

    ChangeRoot changeRoot;
    HibConfig hibConfig;

    public static void main(String[] args){
        launch(args);
    }

    public MainApplication(){

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApplication.primaryStage = primaryStage;
        makestart();
    }

    public void makestart(){
        hibConfig = new HibConfig();;
        ChangeRoot.login();
        test();
    }

    public void test(){
        UserMapping.addUser("agata","1q2w3e4r");
        Selection.listUsers();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }


}
