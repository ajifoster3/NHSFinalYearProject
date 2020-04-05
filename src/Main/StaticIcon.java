package Main;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StaticIcon extends AnchorPane {

    @FXML AnchorPane root_pane;

    public StaticIcon() {

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("resources/StaticIcon.fxml")
        );
        getStyleClass().add("dragicon");
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {}



}