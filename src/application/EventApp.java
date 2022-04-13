package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EventApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Events");
		
		Label label1 = new Label();
		label1.setVisible(false);
		Label label = new Label("Input your name: ");
		TextField text = new TextField();
		text.setTooltip(new Tooltip("Type your name here"));
		Button button = new Button("Say hello");
		button.setTooltip(new Tooltip("Click here"));
		button.setOnAction((ActionEvent event) -> {
			if (text.getText().length() > 0) {
				label1.setText("Hello " + text.getText());
				label1.setVisible(true);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setContentText("Opps!");
			}
		});
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				if (text.getText().length() > 0) {
//					label1.setText("Hello " + text.getText());
//					label1.setVisible(true);
//				} else {
//					Alert alert = new Alert(AlertType.WARNING);
//					alert.setContentText("Opps!");
//				}
////				Alert alert = new Alert(AlertType.INFORMATION);
////				alert.setTitle("Alert title");
////				alert.setHeaderText("Header text");
////				alert.setContentText("This is my text");
////				alert.showAndWait();
//			}
//		});
		
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(20);
		grid.autosize();
		grid.add(label, 0, 0);
		grid.add(text, 1, 0);
		grid.add(button, 0, 2);
		grid.setPadding(new Insets(10));
		grid.add(label1, 0, 3);
		
		Group group = new Group();
		group.getChildren().add(grid);
		Scene scene = new Scene(group, 500, 300);
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
