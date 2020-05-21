package Main.Controllers;

import Main.Data.PatientRecord.Patient;
import Main.Enums.PatientRecordEnum;
import Main.Cleansing.CleansingHelpers.ExcelReader;
import Main.Main;
import Main.Matching.FieldMatcher;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FieldMatcherController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(FieldMatcherController.class.getName());


    Boolean isFiltered = false;
    List<String> headers;
    @FXML
    GridPane root_pane;
    @FXML
    VBox left_pane;
    @FXML
    VBox mid_pane;
    @FXML
    GridPane right_pane;
    @FXML
    Button button_confirm;
    @FXML
    TextField SearchBar;

    List<String> PatientSetList;
    List<String> Headers;
    List<String> FilteredHeaders;

    List<String> LeftJoined;
    List<String> RightJoined;

    private int leftSelectedIndex;
    private int midSelectedIndex;

    @FXML
    Button join_button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Stage fileSelectStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(fileSelectStage);
        ExcelReader excelReader = ExcelReader.getInstance();
        try {
            excelReader.setCurrentSheet(WorkbookFactory.create(file).getSheetAt(0));
            headers = excelReader.ExcelHeadersAsList();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }

        RightJoined = new LinkedList<>();
        LeftJoined = new LinkedList<>();
        Headers = new LinkedList<>();
        PatientSetList = new LinkedList<>();
        List<String> list = new ArrayList<>();
        try {
            list = headers;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        Headers = list;

        PatientSetList = Stream.of(PatientRecordEnum.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        PatientSetList = Stream.of(PatientRecordEnum.values())
                .map(Enum::name)
                .collect(Collectors.toList());


        Collections.sort(Headers);

        for (int i = 0; i < PatientSetList.size(); i++) {

            FieldMatcherSelectIconController icn = new FieldMatcherSelectIconController();

            final int index = i;
            icn.setOnMouseClicked(event -> LeftPaneClick(index));

            ((Label) icn.getChildren().get(0)).setText(PatientSetList.get(i));

            left_pane.getChildren().add(icn);
        }

        //populate left pane with multiple colored icons for testing
        for (int i = 0; i < Headers.size(); i++) {
            FieldMatcherSelectIconController icn = new FieldMatcherSelectIconController();

            final int index = i;
            icn.setOnMouseClicked(event -> MidPaneClick(index));

            ((Label) icn.getChildren().get(0)).setText(Headers.get(i));

            mid_pane.getChildren().add(icn);
        }
        leftSelectedIndex = -1;
        midSelectedIndex = -1;

    }

    @FXML
    private void LeftPaneClick(int i) {
        if (leftSelectedIndex == i) {
            leftSelectedIndex = -1;
        } else {
            leftSelectedIndex = i;
        }
        reload();
    }

    @FXML
    private void MidPaneClick(int i) {
        if (midSelectedIndex == i) {
            midSelectedIndex = -1;
        } else {
            midSelectedIndex = i;
        }
        reload();
    }

    @FXML
    private void join_button_click() {
        LeftJoined.add(PatientSetList.get(leftSelectedIndex));
        PatientSetList.remove(leftSelectedIndex);
        if (!isFiltered) {
            RightJoined.add(Headers.get(midSelectedIndex));
            Headers.remove(midSelectedIndex);
        } else {
            RightJoined.add(FilteredHeaders.get(midSelectedIndex));
            Headers.remove(FilteredHeaders.get(midSelectedIndex));
            FilteredHeaders.remove(midSelectedIndex);
        }

        leftSelectedIndex = -1;
        midSelectedIndex = -1;
        reload();
    }

    @FXML
    private void searchTextTyped() {
        FilteredHeaders = Headers.stream()
                .filter(x -> x.toUpperCase().contains(SearchBar.getText().toUpperCase()))
                .collect(Collectors.toList());
        isFiltered = true;
        midSelectedIndex = -1;
        reload();
    }

    @FXML
    private void reload() {

        Collections.sort(Headers);

        left_pane.getChildren().clear();
        mid_pane.getChildren().clear();
        right_pane.getChildren().clear();

        for (int i = 0; i < PatientSetList.size(); i++) {

            FieldMatcherSelectIconController icn = new FieldMatcherSelectIconController();
            ((Label) icn.getChildren().get(0)).setText(PatientSetList.get(i));
            final int index = i;
            icn.setOnMouseClicked(event -> LeftPaneClick(index));
            Tooltip.install(
                    icn,
                    new Tooltip(PatientRecordEnum.valueOf(PatientSetList.get(i)).getCode())
            );
            if (leftSelectedIndex == i) {
                icn.setStyle("-fx-background-color: #FFB877; -fx-background-radius:0; -fx-border-color: black");
            }
            left_pane.getChildren().add(icn);
        }
        if (!isFiltered) {
            //populate left pane with multiple colored icons for testing
            for (int i = 0; i < Headers.size(); i++) {
                FieldMatcherSelectIconController icn = new FieldMatcherSelectIconController();
                ((Label) icn.getChildren().get(0)).setText(Headers.get(i));
                final int index = i;
                icn.setOnMouseClicked(event -> MidPaneClick(index));
                Tooltip.install(
                        icn,
                        new Tooltip(Headers.get(i))
                );
                if (midSelectedIndex == i) {
                    icn.setStyle("-fx-background-color: #FFB877; -fx-background-radius:0; -fx-border-color: black");
                }
                mid_pane.getChildren().add(icn);
            }
        } else {
            //populate left pane with multiple colored icons for testing
            for (int i = 0; i < FilteredHeaders.size(); i++) {
                FieldMatcherSelectIconController icn = new FieldMatcherSelectIconController();
                ((Label) icn.getChildren().get(0)).setText(FilteredHeaders.get(i));
                final int index = i;
                icn.setOnMouseClicked(event -> MidPaneClick(index));
                Tooltip.install(
                        icn,
                        new Tooltip(FilteredHeaders.get(i))
                );
                if (midSelectedIndex == i) {
                    icn.setStyle("-fx-background-color: #FFB877; -fx-background-radius:0; -fx-border-color: black");
                }
                mid_pane.getChildren().add(icn);
            }
        }

        for (int i = 0; i < LeftJoined.size(); i++) {
            FieldMatcherSelectIconController icn = new FieldMatcherSelectIconController();
            ((Label) icn.getChildren().get(0)).setText(RightJoined.get(i));

            right_pane.add(icn, 1, i);
            FieldMatcherSelectIconController icn2 = new FieldMatcherSelectIconController();
            ((Label) icn2.getChildren().get(0)).setText(LeftJoined.get(i));

            right_pane.add(icn2, 0, i);
            Button btn = new Button();
            btn.setText("X");
            final int increment = i;
            btn.setOnMouseClicked((EventHandler<Event>) event -> {
                String left = LeftJoined.get(increment);
                String right = RightJoined.get(increment);
                LeftJoined.remove(increment);
                RightJoined.remove(increment);
                PatientSetList.add(left);
                Headers.add(right);
                if (isFiltered && right.toUpperCase().contains(SearchBar.getText().toUpperCase())) {
                    FilteredHeaders.add(right);
                }
                reload();
            });
            right_pane.add(btn, 2, i);
        }

    }

    @FXML
    private void button_confirm_click(){
        FieldMatcher matcher = new FieldMatcher(LeftJoined, RightJoined);
        List<Patient> patients = matcher.BuildPatientList();
        MainViewController main = Main.mainViewController;
        Stage stage = (Stage) button_confirm.getScene().getWindow();
        stage.close();
        main.setPatientList(patients);
        main.loadPatientTable();

    }


}
