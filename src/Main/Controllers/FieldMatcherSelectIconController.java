package Main.Controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class FieldMatcherSelectIconController extends AnchorPane{

    public FieldMatcherSelectIconController() {

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("FieldMatcherSelectIcon.fxml")
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

}