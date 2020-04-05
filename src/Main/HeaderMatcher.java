package Main;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    SplitPane base_pane;
    @FXML
    VBox left_pane;
    @FXML VBox mid_pane;
    @FXML
    GridPane right_pane;

    String itemToBeDropped;

    List<String> PatientSetList;
    List<String> Headers;

    List<String> LeftJoined;
    List<String> RightJoined;

    Stage ps;

    private DragIcon mDragOverIcon = null;
    private DragIcon mRDragOverIcon = null;

    private EventHandler<DragEvent> mIconDragOverRoot = null;
    private EventHandler<DragEvent> mIconDragDropped = null;
    private EventHandler<DragEvent> mIconDragOverLeftPane = null;
    private EventHandler<DragEvent> mRIconDragOverRoot = null;
    private EventHandler<DragEvent> mRIconDragDropped = null;
    private EventHandler<DragEvent> mRIconDragOverLeftPane = null;


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

            addMidDragDetection(icn);

            ((Label)icn.getChildren().get(0)).setText(Headers.get(i));


            mid_pane.getChildren().add(icn);
        }
        for (int i = 0; i < PatientSetList.size(); i++) {

            StaticIcon icn = new StaticIcon();

            ((Label)icn.getChildren().get(0)).setText(PatientSetList.get(i));

            left_pane.getChildren().add(icn);
        }



        buildDragHandlers();
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

            addMidDragDetection(icn);

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
            addRightDragDetection(icn);
            ((Label)icn.getChildren().get(0)).setText(RightJoined.get(i));

            right_pane.add(icn, 1, i);
            DragIcon icn2 = new DragIcon();
            addRightDragDetection(icn2);
            ((Label)icn2.getChildren().get(0)).setText(LeftJoined.get(i));

            right_pane.add(icn2, 0, i);
        }



        buildDragHandlers();
    }

    private void addMidDragDetection(DragIcon dragIcon) {

        dragIcon.setOnDragDetected (new EventHandler <MouseEvent> () {

            @Override
            public void handle(MouseEvent event) {

                // set drag event handlers on their respective objects
                base_pane.setOnDragOver(mIconDragOverRoot);
                left_pane.setOnDragOver(mIconDragOverLeftPane);
                left_pane.setOnDragDropped(mIconDragDropped);

                // get a reference to the clicked DragIcon object
                DragIcon icn = (DragIcon) event.getSource();

                //begin drag ops
                ((Label)(mDragOverIcon.getChildren().get(0))).setText(((Label)icn.getChildren().get(0)).getText());
                mDragOverIcon.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));

                ClipboardContent content = new ClipboardContent();
                DragContainer container = new DragContainer();
                container.addData ("text", ((Label)mDragOverIcon.getChildren().get(0)).getText());
                content.put(DragContainer.AddNode, container);

                mDragOverIcon.startDragAndDrop (TransferMode.ANY).setContent(content);
                mDragOverIcon.setVisible(true);
                mDragOverIcon.setMouseTransparent(true);
                event.consume();
            }
        });
    }

    private void addRightDragDetection(DragIcon dragIcon) {

        dragIcon.setOnDragDetected (new EventHandler <MouseEvent> () {

            @Override
            public void handle(MouseEvent event) {

                // set drag event handlers on their respective objects
                base_pane.setOnDragOver(mRIconDragOverRoot);
                left_pane.setOnDragOver(mRIconDragOverLeftPane);
                left_pane.setOnDragDropped(mRIconDragDropped);
                mid_pane.setOnDragDropped(mRIconDragDropped);

                // get a reference to the clicked DragIcon object
                DragIcon icn = (DragIcon) event.getSource();

                //begin drag ops
                ((Label)(mRDragOverIcon.getChildren().get(0))).setText(((Label)icn.getChildren().get(0)).getText());
                mRDragOverIcon.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));

                ClipboardContent content = new ClipboardContent();
                DragContainer container = new DragContainer();
                container.addData ("text", ((Label)mRDragOverIcon.getChildren().get(0)).getText());
                content.put(DragContainer.AddNode, container);

                mRDragOverIcon.startDragAndDrop (TransferMode.ANY).setContent(content);
                mRDragOverIcon.setVisible(true);
                mRDragOverIcon.setMouseTransparent(true);
                event.consume();
            }
        });
    }

    private void buildDragHandlers() {

        //drag over transition to move widget form left pane to right pane
        mIconDragOverRoot = new EventHandler <DragEvent>() {

            @Override
            public void handle(DragEvent event) {

                Point2D p = left_pane.sceneToLocal(event.getSceneX(), event.getSceneY());

                //turn on transfer mode and track in the right-pane's context
                //if (and only if) the mouse cursor falls within the right pane's bounds.
                if (!left_pane.boundsInLocalProperty().get().contains(p)) {

                    event.acceptTransferModes(TransferMode.ANY);
                    mDragOverIcon.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));
                    return;
                }

                event.consume();
            }
        };
        //drag over transition to move widget form left pane to right pane
        mRIconDragOverRoot = new EventHandler <DragEvent>() {

            @Override
            public void handle(DragEvent event) {

                Point2D p = right_pane.sceneToLocal(event.getSceneX(), event.getSceneY());

                //turn on transfer mode and track in the right-pane's context
                //if (and only if) the mouse cursor falls within the right pane's bounds.
                if (!right_pane.boundsInLocalProperty().get().contains(p)) {

                    event.acceptTransferModes(TransferMode.ANY);
                    mRDragOverIcon.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));
                    return;
                }

                event.consume();
            }
        };


        mIconDragOverLeftPane = new EventHandler <DragEvent> () {

            @Override
            public void handle(DragEvent event) {

                event.acceptTransferModes(TransferMode.ANY);

                //convert the mouse coordinates to scene coordinates,
                //then convert back to coordinates that are relative to
                //the parent of mDragIcon.  Since mDragIcon is a child of the root
                //pane, coodinates must be in the root pane's coordinate system to work
                //properly.
                mDragOverIcon.relocateToPoint(
                        new Point2D(event.getSceneX(), event.getSceneY())
                );
                event.consume();
            }
        };

        mRIconDragOverLeftPane = new EventHandler <DragEvent> () {

            @Override
            public void handle(DragEvent event) {

                event.acceptTransferModes(TransferMode.ANY);

                //convert the mouse coordinates to scene coordinates,
                //then convert back to coordinates that are relative to
                //the parent of mDragIcon.  Since mDragIcon is a child of the root
                //pane, coodinates must be in the root pane's coordinate system to work
                //properly.
                mRDragOverIcon.relocateToPoint(
                        new Point2D(event.getSceneX(), event.getSceneY())
                );
                event.consume();
            }
        };


        mIconDragDropped = new EventHandler <DragEvent> () {

            @Override
            public void handle(DragEvent event) {

                DragContainer container =
                        (DragContainer) event.getDragboard().getContent(DragContainer.AddNode);

                container.addData("scene_coords",
                        new Point2D(event.getSceneX(), event.getSceneY()));

                ClipboardContent content = new ClipboardContent();
                content.put(DragContainer.AddNode, container);

                String thisClassType = event.getTarget().getClass().toString();
                String myText = "";

                if( thisClassType.equals("class com.sun.javafx.scene.control.LabeledText")){
                    myText = ((Text)event.getTarget()).getText();
                }else if(thisClassType.equals("class javafx.scene.control.Label")){
                    myText = ((Label)event.getTarget()).getText();
                } else{
                    return;
                }

                itemToBeDropped = container.getValue("text");

                LeftJoined.add(myText);
                PatientSetList.remove(myText);

                RightJoined.add(itemToBeDropped);
                Headers.remove(itemToBeDropped);

                event.getDragboard().setContent(content);
                event.setDropCompleted(true);

            }
        };

        mRIconDragDropped = new EventHandler <DragEvent> () {

            @Override
            public void handle(DragEvent event) {

                DragContainer container =
                        (DragContainer) event.getDragboard().getContent(DragContainer.AddNode);

                String leftHeader = container.getData().get(0).getValue().toString();

                int index = LeftJoined.indexOf(leftHeader);
                String rightHeader = RightJoined.get(index);


                container.addData("scene_coords",
                        new Point2D(event.getSceneX(), event.getSceneY()));

                ClipboardContent content = new ClipboardContent();
                content.put(DragContainer.AddNode, container);

                String thisClassType = event.getTarget().getClass().toString();


                itemToBeDropped = container.getValue("text");

                LeftJoined.remove(leftHeader);
                PatientSetList.add(leftHeader);

                RightJoined.remove(rightHeader);
                Headers.add(rightHeader);

                event.getDragboard().setContent(content);
                event.setDropCompleted(true);

            }
        };


        this.setOnDragDone (new EventHandler <DragEvent> (){

            @Override
            public void handle (DragEvent event) {

                left_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverLeftPane);
                left_pane.removeEventHandler(DragEvent.DRAG_DROPPED, mIconDragDropped);
                left_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverRoot);
                left_pane.removeEventHandler(DragEvent.DRAG_OVER, mRIconDragOverLeftPane);
                left_pane.removeEventHandler(DragEvent.DRAG_DROPPED, mRIconDragDropped);
                left_pane.removeEventHandler(DragEvent.DRAG_OVER, mRIconDragOverRoot);
                mid_pane.removeEventHandler(DragEvent.DRAG_OVER, mRIconDragOverLeftPane);
                mid_pane.removeEventHandler(DragEvent.DRAG_DROPPED, mRIconDragDropped);
                mid_pane.removeEventHandler(DragEvent.DRAG_OVER, mRIconDragOverRoot);

                mDragOverIcon.setVisible(false);
                mRDragOverIcon.setVisible(false);

                DragContainer container =
                        (DragContainer) event.getDragboard().getContent(DragContainer.AddNode);

                if (container != null) {
                    if (container.getValue("scene_coords") != null) {

                        DragIcon droppedIcon = new DragIcon();


                        ((Label)droppedIcon.getChildren().get(0)).setText(container.getValue("text").toString());
                        left_pane.getChildren().add(droppedIcon);

                        Point2D cursorPoint = container.getValue("scene_coords");

                    }
                }

                event.consume();
                reload();
            }
        });
    }

}
