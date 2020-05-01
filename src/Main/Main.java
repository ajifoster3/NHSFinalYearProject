package Main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private static final Logger LOGGER = Logger.getLogger(FieldMatcherController.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/Main.fxml"));
        primaryStage.setTitle("NHS Data Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void NewButtonClick(){
        try {
            Stage stage = new Stage();
            stage.setTitle("NHS Field Matcher");
            FXMLLoader FieldMatcherLoader = new FXMLLoader(getClass().getResource("resources/FieldMatcher.fxml"));
            Parent root = FieldMatcherLoader.load();
            FieldMatcherLoader.getController();
            Scene scene = new Scene(root,1500,500);
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }

    }
}
