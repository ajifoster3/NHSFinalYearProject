package Main;

import Main.Data.PatientRecord.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RecordScoresViewController implements Initializable {

    //region Labels
    @FXML Label respiratory;
    @FXML Label nervous;
    @FXML Label cardiovascular;
    @FXML Label liver;
    @FXML Label coagulation;
    @FXML Label kidney;
    @FXML Label cough;
    @FXML Label movingInBed;
    @FXML Label supineToStanding;
    @FXML Label dynamicSitting;
    @FXML Label standingBalance;
    @FXML Label sitToStand;
    @FXML Label transferBedToChair;
    @FXML Label stepping;
    @FXML Label gripStrength;
    @FXML Label shoulderAbductionRight;
    @FXML Label shoulderAbductionLeft;
    @FXML Label elbowFlexionRight;
    @FXML Label elbowFlexionleft;
    @FXML Label wristExtensionLeft;
    @FXML Label wristExtensionRight;
    @FXML Label hipFlexionRight;
    @FXML Label hipFlexionLeft;
    @FXML Label kneeExtensionRight;
    @FXML Label kneeExtensionleft;
    @FXML Label ankleDorsiflexionRight;
    @FXML Label ankleDorsiflexionLeft;
    @FXML Label mms;
//endregion

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void populateScores(Record record){
        populateSOFA(record.getSofa());
        populateCPAx(record.getCpax());
        populateMRC(record.getMrc());
        populateMMS(record.getMms());
    }

    private void populateSOFA(SOFA sofa){
        respiratory.setText(String.valueOf(sofa.getRespiratoryScore()));
        nervous.setText(String.valueOf(sofa.getNervousScore()));
        cardiovascular.setText(String.valueOf(sofa.getCardiovascularScore()));
        liver.setText(String.valueOf(sofa.getLiverScore()));
        coagulation.setText(String.valueOf(sofa.getCoagulationScore()));
        kidney.setText(String.valueOf(sofa.getKidneyScore()));
    }

    private void populateCPAx(CPAx cpax){
        cough.setText(String.valueOf(cpax.getCough()));
        movingInBed.setText(String.valueOf(cpax.getMovingInBed()));
        supineToStanding.setText(String.valueOf(cpax.getSupineToSitting()));
        dynamicSitting.setText(String.valueOf(cpax.getDynamicSitting()));
        standingBalance.setText(String.valueOf(cpax.getStandingBalance()));
        sitToStand.setText(String.valueOf(cpax.getSitToStand()));
        transferBedToChair.setText(String.valueOf(cpax.getTransferBedToChair()));
        stepping.setText(String.valueOf(cpax.getStepping()));
        gripStrength.setText(String.valueOf(cpax.getGripStrength()));

    }

    private void populateMRC(MRC mrc){
        shoulderAbductionRight.setText(String.valueOf(mrc.getShoulderAbductionRight()));
        shoulderAbductionLeft.setText(String.valueOf(mrc.getShoulderAbductionLeft()));
        elbowFlexionRight.setText(String.valueOf(mrc.getElbowFlexionRight()));
        elbowFlexionleft.setText(String.valueOf(mrc.getElbowFlexionLeft()));
        wristExtensionRight.setText(String.valueOf(mrc.getWristExtensionRight()));
        wristExtensionLeft.setText(String.valueOf(mrc.getWristExtensionLeft()));
        hipFlexionRight.setText(String.valueOf(mrc.getHipFlexionRight()));
        hipFlexionLeft.setText(String.valueOf(mrc.getHipFlexionLeft()));
        kneeExtensionRight.setText(String.valueOf(mrc.getKneeExtensionRight()));
        kneeExtensionleft.setText(String.valueOf(mrc.getKneeExtensionLeft()));
        ankleDorsiflexionRight.setText(String.valueOf(mrc.getAnkleDorsiflexionRight()));
        ankleDorsiflexionLeft.setText(String.valueOf(mrc.getAnkleDorsiflexionLeft()));
    }

    private void populateMMS(MMS mms){
        this.mms.setText(String.valueOf(mms.getMms()));
    }
}
