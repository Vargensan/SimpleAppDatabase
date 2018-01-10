package logic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import usergui.utils.GuiUtils;
import usergui.utils.ViewInstance;

/**
 * Created By Bartłomiej Woś
 */
public class ChangeRoot {


    public ChangeRoot(){
    }

    /*
     * Always with root privilages
     */
    public static void login(){
        DBApp.instance().getDatabase().initalizeHibernateConfig();
        updateView(ViewInstance.LOGIN);
    }

    /**
     * Without root privilages -> check user privilages and then perform action
     *
     */
    private static void changeView(ViewInstance viewInstance){
        try {
            String filename = viewInstance.layoutName().getFileName();
            System.out.println(filename);
            replaceSceneContent(viewInstance);
        } catch (Exception e) {
            //e.printStackTrace();
            GuiUtils.alert(Alert.AlertType.ERROR,"Error","Unable To Change Layout",e.getMessage());
        }
    }

    public static void changeLayoutLevelAccess(ViewInstance viewInstance){
        int accesLevel = AcessLevel.getAccessLevel();

        //TODO: set Access Level Deppending on User Privillages
        ChangeRoot.changeView(viewInstance);

    }


    private static void updateView(ViewInstance viewInstance){
        try{
            replaceSceneContent(viewInstance);
            DBApp.instance().getActualController().initializeListeners();
            DBApp.instance().getStage().show();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    private static Parent replaceSceneContent(ViewInstance viewInstance) throws Exception {
        Stage stage = DBApp.instance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(DBApp.class.getResource(viewInstance.layoutName().getFileName()));
        Parent page;
        try {
            page = fxmlLoader.load();
            DBApp.instance().setActualController(fxmlLoader.getController());
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
        Scene scene;
        try {
            scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            //scene.getStylesheets().add(App.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
            stage.getScene().setRoot(page);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        stage.setResizable(false);
    }catch (NullPointerException e){

    }
        return page;
    }

}
