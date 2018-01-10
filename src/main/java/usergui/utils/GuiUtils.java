package usergui.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import logic.DBApp;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Ernest Sadowski (Ernio)
 */
public class GuiUtils
{

	public static Background bgFill(Color color)
	{
		return new Background(new BackgroundFill(color, CornerRadii.EMPTY, null));
	}

	public static Border borderStroke(Color color)
	{
		return new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
	}

	public static void alert(AlertType type, String title, String header, String text)
	{
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(text);
		alert.initOwner(DBApp.instance().getStage());
		alert.showAndWait();
	}

	public static void throwDialog(Throwable throwable, String title, String header, String text)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(text);
		alert.initOwner(DBApp.instance().getStage());
		alert.initModality(Modality.APPLICATION_MODAL);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label("Stacktrace:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		alert.getDialogPane().setExpandableContent(new VBox(label, textArea));
		alert.showAndWait();
	}
}