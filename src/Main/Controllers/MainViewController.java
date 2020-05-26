package Main.Controllers;

import Main.Data.Patient;
import Main.Data.Record;
import Main.Data.Visit;
import Main.Controllers.ControllerHelpers.DBHelper;
import Main.Controllers.ControllerHelpers.PatientJsonConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainViewController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(FieldMatcherController.class.getName());

    private List<Patient> patientList;

    @FXML
    AnchorPane root_pane;

    @FXML
    GridPane PatientTableContainer;

    @FXML
    TableView patientTable;

    @FXML
    public void loadPatientTable() {

        patientTable.getItems().clear();

        patientTable.setRowFactory(tv -> {
            TableRow<Patient> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {
                    Patient clickedRow = row.getItem();

                    loadVisitTable(patientList.get(patientList.indexOf(clickedRow)).getHospitalVisits());
                }
            });
            return row ;
        });

        patientList.forEach(patient -> {
            patientTable.getItems().add(patient);
        });

    }

    @FXML
    public void loadVisitTable(List<Visit> visits) {

        TableView tableView = new TableView();

        tableView.setRowFactory(tv -> {
            TableRow<Visit> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {
                    Visit clickedRow = row.getItem();
                    loadRecordTable(visits.get(visits.indexOf(clickedRow)).getRecords());
                }
            });
            return row ;
        });

        TableColumn<String, Visit> column1 = new TableColumn<>("POID");
        column1.setCellValueFactory(new PropertyValueFactory<>("POID"));

        TableColumn<String, Visit> column2 = new TableColumn<>("Diagnosis");
        column2.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));

        TableColumn<String, Visit> column3 = new TableColumn<>("Patient Category");
        column3.setCellValueFactory(new PropertyValueFactory<>("patientCategory"));

        TableColumn<LocalDate, Visit> column4 = new TableColumn<>("Hospital Admit Date");
        column4.setCellValueFactory(new PropertyValueFactory<>("admitDateHos"));

        TableColumn<LocalDate, Visit> column5 = new TableColumn<>("Hospital Discharge Date");
        column5.setCellValueFactory(new PropertyValueFactory<>("dischargeDateHos"));

        TableColumn<LocalDate, Visit> column6 = new TableColumn<>("Hospital Length Of Say (Days)");
        column6.setCellValueFactory(new PropertyValueFactory<>("lengthOfStayHosp"));

        TableColumn<LocalDate, Visit> column7 = new TableColumn<>("ICU Admit Date");
        column7.setCellValueFactory(new PropertyValueFactory<>("admitDateICU"));

        TableColumn<LocalDate, Visit> column8 = new TableColumn<>("ICU Discharge Date");
        column8.setCellValueFactory(new PropertyValueFactory<>("dischargeDateICU"));

        TableColumn<LocalDate, Visit> column9 = new TableColumn<>("ICU Length Of Stay (Days)");
        column9.setCellValueFactory(new PropertyValueFactory<>("lengthOfStayICU"));

        TableColumn<Integer, Visit> column10 = new TableColumn<>("Admit Type");
        column10.setCellValueFactory(new PropertyValueFactory<>("admitType"));

        TableColumn<Integer, Visit> column11 = new TableColumn<>("Admit From");
        column11.setCellValueFactory(new PropertyValueFactory<>("admitFrom"));

        TableColumn<String, Visit> column12 = new TableColumn<>("Dependency Pre Admission");
        column12.setCellValueFactory(new PropertyValueFactory<>("dependencyPreAdmit"));

        TableColumn<String, Visit> column13 = new TableColumn<>("Past Medical History");
        column13.setCellValueFactory(new PropertyValueFactory<>("pastMedicalHistory"));

        TableColumn<String, Visit> column14 = new TableColumn<>("History");
        column14.setCellValueFactory(new PropertyValueFactory<>("history"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);
        tableView.getColumns().add(column9);
        tableView.getColumns().add(column10);
        tableView.getColumns().add(column11);
        tableView.getColumns().add(column12);
        tableView.getColumns().add(column13);
        tableView.getColumns().add(column14);


        visits.forEach(visit -> {
            tableView.getItems().add(visit);
        });

        Scene scene = new Scene(tableView);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void loadRecordTable(List<Record> records) {

        TableView tableView = new TableView();

        tableView.setRowFactory(tv -> {
            TableRow<Record> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {
                    Record clickedRow = row.getItem();
                    loadRecordScores(records.get(records.indexOf(clickedRow)));
                }
            });
            return row ;
        });

        TableColumn<LocalDate, Record> column1 = new TableColumn<>("Date");
        column1.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<String, Record> column2 = new TableColumn<>("Breathing");
        column2.setCellValueFactory(new PropertyValueFactory<>("breathing"));

        TableColumn<String, Record> column3 = new TableColumn<>("Circulation");
        column3.setCellValueFactory(new PropertyValueFactory<>("circulation"));

        TableColumn<String, Record> column4 = new TableColumn<>("Duration of Session");
        column4.setCellValueFactory(new PropertyValueFactory<>("durationOfSession"));

        TableColumn<String, Record> column5 = new TableColumn<>("Comprehensive Rehab");
        column5.setCellValueFactory(new PropertyValueFactory<>("comprehensiveRehab"));

        TableColumn<String, Record> column6 = new TableColumn<>("Fitness to Participate");
        column6.setCellValueFactory(new PropertyValueFactory<>("fitnessToParticipate"));

        TableColumn<String, Record> column7 = new TableColumn<>("Delerium");
        column7.setCellValueFactory(new PropertyValueFactory<>("delirium"));

        TableColumn<String, Record> column8 = new TableColumn<>("IPAT");
        column8.setCellValueFactory(new PropertyValueFactory<>("ipat"));

        TableColumn<String, Record> column9 = new TableColumn<>("Fit for Physio");
        column9.setCellValueFactory(new PropertyValueFactory<>("fitForPhysio"));

        TableColumn<Integer, Record> column10 = new TableColumn<>("Rass High");
        column10.setCellValueFactory(new PropertyValueFactory<>("rassHigh"));

        TableColumn<Integer, Record> column11 = new TableColumn<>("Rass Low");
        column11.setCellValueFactory(new PropertyValueFactory<>("rassLow"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);
        tableView.getColumns().add(column9);
        tableView.getColumns().add(column10);
        tableView.getColumns().add(column11);

        records.forEach(record -> {
            tableView.getItems().add(record);
        });


        Scene scene = new Scene(tableView);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void loadRecordScores(Record record){
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            FXMLLoader RecordScoresLoader = new FXMLLoader(getClass().getResource("RecordScoresView.fxml"));
            Parent root = RecordScoresLoader.load();
            RecordScoresViewController controller = RecordScoresLoader.getController();
            controller.populateScores(record);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<String, Patient> column1 = new TableColumn<>("Hospital Number");
        column1.setCellValueFactory(new PropertyValueFactory<>("hospitalNumber"));

        TableColumn<String, Patient> column2 = new TableColumn<>("First Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<String, Patient> column3 = new TableColumn<>("Last Name");
        column3.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Date, Patient> column4 = new TableColumn<>("Date Of Birth");
        column4.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        TableColumn<Integer, Patient> column5 = new TableColumn<>("Age");
        column5.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<String, Patient> column6 = new TableColumn<>("Sex");
        column6.setCellValueFactory(new PropertyValueFactory<>("sex"));

        patientTable.getColumns().add(column1);
        patientTable.getColumns().add(column2);
        patientTable.getColumns().add(column3);
        patientTable.getColumns().add(column4);
        patientTable.getColumns().add(column5);
        patientTable.getColumns().add(column6);

    }


    @FXML
    private void NewButtonClick(){
        try {
            Stage stage = new Stage();
            stage.setTitle("NHS Field Matcher");
            FXMLLoader FieldMatcherLoader = new FXMLLoader(getClass().getResource("FieldMatcher.fxml"));
            Parent root = FieldMatcherLoader.load();
            FieldMatcherController matcherLoader = FieldMatcherLoader.getController();
            matcherLoader.mainViewController = this;
            Scene scene = new Scene(root,1500,500);
            stage.setMaximized(true);
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
    }

    @FXML
    private void OpenButtonClick(){
        try {
            patientList = PatientJsonConverter.OpenObjectData();
            loadPatientTable();
        } catch(Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
    }

    @FXML
    private void SaveAsButtonClick(){
        try {
            PatientJsonConverter.SaveObjectData(patientList);
        } catch(Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public void SaveAsDbButtonClick(ActionEvent actionEvent) {
        try {
            DBHelper.createNewDatabase("Patient.db");
            DBHelper.createDataTables("Patient.db");
            DBHelper.InsertPatients("Patient.db", this.patientList);
        } catch(Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
    }
}
