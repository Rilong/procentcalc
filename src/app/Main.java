package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Application.setUserAgentStylesheet(getClass().getResource("style.css").toExternalForm());
        FlowPane pane = FXMLLoader.load(getClass().getResource("ui.fxml"));
        Scene scene = new Scene(pane, 390, 450);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("procentCalc");
        primaryStage.getIcons().add(new Image(getClass().getResource("procent.png").toExternalForm()));
        primaryStage.show();
    }
}
