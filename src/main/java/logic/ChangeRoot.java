package logic;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created By Bartłomiej Woś
 */
public class ChangeRoot {


    public ChangeRoot(){
    }

    public static void login(){
        try {
            replaceSceneContent(MainApplication.getPrimaryStage(),"/dbLogin.fxml");
            MainApplication.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logedIn(){
        try {
            replaceSceneContent(MainApplication.getPrimaryStage(),"/resources/dbLogin.fxml");
            MainApplication.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recipentLayout(){
        try {
            replaceSceneContent(MainApplication.getPrimaryStage(),"/resources/dbMain.fxml");
            MainApplication.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logoutLayout(){
        try {
            replaceSceneContent(MainApplication.getPrimaryStage(),"/resources/dbLogin.fxml");
            MainApplication.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adminLayout(){

    }

    public void shopDirectorLayout(){

    }

    public static void changeLayoutLevelAccess(){
        int accesLevel = AcessLevel.getAccessLevel();
        //TODO: set Access Level Deppending on User Privillages

        recipentLayout();
    }



    private static Parent replaceSceneContent(Stage stage, String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(MainApplication.class.getResource(fxml), null, new JavaFXBuilderFactory());
  //      FXMLLoader fxmlLoader = new FXMLLoader();
     //   Parent page = (Parent) FXMLLoader.load(ChangeRoot.class.getResource(fxml));
        Scene scene = null;
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
