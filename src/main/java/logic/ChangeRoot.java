package logic;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
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

    public static void login(){
        try {
            replaceSceneContent(DatabaseApplication.getStage(),"/dbLogin.fxml");
            DatabaseApplication.getStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeView(ViewInstance viewInstance){
        try {
            replaceSceneContent(DatabaseApplication.getStage(),viewInstance.layoutName().getFileName());
        } catch (Exception e) {
            GuiUtils.alert(Alert.AlertType.ERROR,"Error","Occured",e.getMessage());
        }
    }

    public static void changeLayoutLevelAccess(ViewInstance viewInstance){
        int accesLevel = AcessLevel.getAccessLevel();
        //TODO: set Access Level Deppending on User Privillages
        changeView(viewInstance);

    }


    private static Parent replaceSceneContent(Stage stage, String fxml) throws Exception {
        Parent page;
        try {
            page = (Parent) FXMLLoader.load(DatabaseApplication.class.getResource(fxml), null, new JavaFXBuilderFactory());
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
