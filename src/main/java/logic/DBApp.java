package logic;

import data.config.HibConfig;
import javafx.application.Application;
import javafx.stage.Stage;
import data.maping.Selection;
import data.maping.UserMapping;
import logic.ctrl.Controller;

/**
 * Created By Bartłomiej Woś
 */
public class DBApp extends Application{

    private static DBApp DBApp;
    private Stage stage;
    private Database database;
    private Controller actualController;


    private HibConfig hibConfig;

    public static void main(String[] args){
        launch(args);
    }

    public DBApp(){
        if(DBApp == null) {
            DBApp = this;
        }
    }

    @Override
    public void init() throws Exception {
        database = new Database();
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        instance().stage = primaryStage;
        showLoginLayout();
        database.test();
    }

    public void showLoginLayout(){
        ChangeRoot.login();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static DBApp instance()
    {
        return DBApp;
    }

    public Database getDatabase() { return database; }

    public Stage getStage() {return DBApp.stage; }


    public Controller getActualController() {
        return actualController;
    }

    public void setActualController(Controller actualController) {
        this.actualController = actualController;
    }
}
