package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class NewData {

    @FXML
    BorderPane border_pane;

    @FXML
    AnchorPane anchor_pane;

    @FXML
    VBox vbox;

    @FXML
    Button anchor_pane_button;

    @FXML
    GridPane center_grid;

    @FXML
    public void start() throws Exception {
        vbox = new VBox();
        center_grid = new GridPane();
        center_grid.setMinSize(25, 25);
        center_grid.setPrefSize(25000, 25000);
        vbox.getChildren().add(center_grid);
        Stage primaryStage = new Stage();

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);

        HeaderMatcher headerMatcher = new HeaderMatcher();
        headerMatcher.start(file);

        center_grid.getChildren().add(headerMatcher);

        primaryStage.setTitle("Header Matcher");


        try {
            Scene scene = new Scene(vbox,1000,500);
            scene.getStylesheets().add(this.getClass().getClassLoader().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}

