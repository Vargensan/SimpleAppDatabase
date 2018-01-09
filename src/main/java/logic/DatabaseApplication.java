package logic;

import data.config.HibConfig;
import javafx.application.Application;
import javafx.stage.Stage;
import data.maping.Selection;
import data.maping.UserMapping;

/**
 * Created By Bartłomiej Woś
 */
public class DatabaseApplication extends Application{

    private static DatabaseApplication DATABASEApplication;
    private Stage stage;
    private Database database;

    private HibConfig hibConfig;

    public static void main(String[] args){
        launch(args);
    }

    public DatabaseApplication(){
        DATABASEApplication = this;
    }

    @Override
    public void init() throws Exception {
        database = new Database();
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DATABASEApplication.stage = primaryStage;
        showLoginLayout();
    }

    public void showLoginLayout(){
        ChangeRoot.login();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public void test(){
        UserMapping.addUser("agata","1q2w3e4r");
        Selection.listUsers();
    }

    public static DatabaseApplication instance()
    {
        return DATABASEApplication;
    }

    public Database getDatabase() { return database; }

    public static Stage getStage() {return DATABASEApplication.stage; }



}
