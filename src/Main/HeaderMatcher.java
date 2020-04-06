package Main;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderMatcher extends AnchorPane {

    List<String> headers;

    @FXML
    VBox left_pane;
    @FXML VBox mid_pane;
    @FXML
    GridPane right_pane;

    List<String> PatientSetList;
    List<String> Headers;

    List<String> LeftJoined;
    List<String> RightJoined;

    private DragIcon mDragOverIcon = null;
    private DragIcon mRDragOverIcon = null;


    public void start(File file) throws Exception {

        headers = ExcelReading.ExcelHeadersAsList(WorkbookFactory.create(file).getSheetAt(0));

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("resources/HeaderMatcher.fxml")
        );

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {

        RightJoined = new LinkedList<>();
        LeftJoined = new LinkedList<>();
        Headers = new LinkedList<>();
        PatientSetList = new LinkedList<>();
        //Add one icon that will be used for the drag-drop process
        //This is added as a child to the root anchorpane so it can be visible
        //on both sides of the split pane.
        mDragOverIcon = new DragIcon();
        mDragOverIcon.setVisible(false);
        mDragOverIcon.setOpacity(0.65);
        getChildren().add(mDragOverIcon);
        mRDragOverIcon = new DragIcon();
        mRDragOverIcon.setVisible(false);
        mRDragOverIcon.setOpacity(0.65);
        getChildren().add(mRDragOverIcon);
        List<String> list = new ArrayList<>();
        try {
            list = headers;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        Headers = list;
        PatientSetList = (Arrays.asList(PatientSet.class.getFields())).stream().map(Field::getName).collect(Collectors.toList());


        //populate left pane with multiple colored icons for testing
        for (int i = 0; i < Headers.size(); i++) {
            DragIcon icn = new DragIcon();

            ((Label)icn.getChildren().get(0)).setText(Headers.get(i));


            mid_pane.getChildren().add(icn);
        }
        for (int i = 0; i < PatientSetList.size(); i++) {

            StaticIcon icn = new StaticIcon();

            ((Label)icn.getChildren().get(0)).setText(PatientSetList.get(i));

            left_pane.getChildren().add(icn);
        }



    }


    @FXML
    private void reload() {

        left_pane.getChildren().clear();
        mid_pane.getChildren().clear();
        right_pane.getChildren().clear();
        //Add one icon that will be used for the drag-drop process
        //This is added as a child to the root anchorpane so it can be visible
        //on both sides of the split pane.
        mDragOverIcon = new DragIcon();

        mDragOverIcon.setVisible(false);
        mDragOverIcon.setOpacity(0.65);
        getChildren().add(mDragOverIcon);



        //populate left pane with multiple colored icons for testing
        for (int i = 0; i < Headers.size(); i++) {
            DragIcon icn = new DragIcon();
            ((Label)icn.getChildren().get(0)).setText(Headers.get(i));
            mid_pane.getChildren().add(icn);
        }
        for (int i = 0; i < PatientSetList.size(); i++) {

            StaticIcon icn = new StaticIcon();
            ((Label)icn.getChildren().get(0)).setText(PatientSetList.get(i));
            left_pane.getChildren().add(icn);
        }
        for (int i = 0; i < LeftJoined.size(); i++) {
            DragIcon icn = new DragIcon();
            ((Label)icn.getChildren().get(0)).setText(RightJoined.get(i));

            right_pane.add(icn, 1, i);
            DragIcon icn2 = new DragIcon();
            ((Label)icn2.getChildren().get(0)).setText(LeftJoined.get(i));

            right_pane.add(icn2, 0, i);
        }

    }



}
