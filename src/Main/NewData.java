package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
    AnchorPane center_anchor;

    @FXML
    public void start() throws Exception {
        vbox = new VBox();
        VBox.setVgrow(vbox, Priority.ALWAYS);
        center_anchor = new AnchorPane();
        vbox.getChildren().add(center_anchor);
        Button anchor_pane_button = new Button("Confirm");
        vbox.getChildren().add(anchor_pane_button);
        Stage primaryStage = new Stage();

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);

        HeaderMatcher headerMatcher = new HeaderMatcher();
        headerMatcher.start(file);

        center_anchor.getChildren().add(headerMatcher);

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

