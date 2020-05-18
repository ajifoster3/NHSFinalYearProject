package Main.Helpers;


import Main.Data.PatientRecord.Patient;
import Main.Main;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PatientJsonConverter {
    public static void SaveObjectData(List<Patient> obj) {

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Patients");
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                FileWriter myWriter = new FileWriter(file);
                String jsonStr = Obj.writeValueAsString(obj);
                myWriter.write(jsonStr);
                myWriter.close();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static List<Patient> OpenObjectData() {

        ObjectMapper Obj = new ObjectMapper();
        Obj.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Patients");
        File file = fileChooser.showOpenDialog(stage);
        String data = "";
        if (file != null) {
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    data = data.concat(myReader.nextLine());
                }
                myReader.close();
            }catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        List<Patient> patientList = new LinkedList<>();
        try{
            JsonNode tree = Obj.readTree(data);

            patientList = Obj.readValue(data, Obj.getTypeFactory().constructCollectionType(List.class, Patient.class));

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return patientList;

    }


}