package Controller;

import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent lightRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/fxml/TrafficLight.fxml")));
			Scene lightScene = new Scene(lightRoot);
			stage.setScene(lightScene);
			stage.setTitle("Traffic");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
