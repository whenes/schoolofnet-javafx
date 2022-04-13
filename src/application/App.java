package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello JavaFX");
		
		GridPane gridPane = new GridPane();
		Group group = new Group();
		
		Label label = new Label("Hello from JavaFX");
		Button button = new Button("First buttom");
		TextField field = new TextField();
		String[] array = new String[] {"hello","hi", "hi there"};
		ChoiceBox<String> choice = new ChoiceBox<>(FXCollections.observableArrayList(array));
		choice.setTooltip(new Tooltip("Select your greeting"));
		CheckBox check = new CheckBox("Caption");
		BorderPane borderPane = new BorderPane();
		MenuBar menuBar = new MenuBar();
		Menu menu =  new Menu("File");
		menu.getItems().add(new MenuItem("New"));
		menu.getItems().add(new MenuItem("Save"));
		menuBar.getMenus().add(menu);
		menuBar.prefWidthProperty().bind(stage.widthProperty());
		borderPane.setTop(menuBar);
		borderPane.setBottom(gridPane);
		
		gridPane.setPadding(new Insets(5, 5, 5, 5));
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.autosize();
		gridPane.add(label, 0, 0);
		gridPane.add(button, 0, 1);
		gridPane.add(field, 0, 2);
		gridPane.add(choice, 0, 3);
		gridPane.add(check, 0, 4);
		
//		group.getChildren().add(gridPane);
		group.getChildren().add(borderPane);
		
		Scene scene = new Scene(group, 400, 200);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
