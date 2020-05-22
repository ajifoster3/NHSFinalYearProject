package Main.Building;


import Main.Cleansing.CleanserDelegator;
import Main.Building.BuildingHelper.CleanserDelagatorService;
import Main.Controllers.ControllerHelpers.PatientBuilderService;
import Main.Data.*;
import Main.Enums.PatientValuesEnum;
import Main.Cleansing.CleansingHelpers.RASSHelper;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientBuilder implements PatientBuilderService {

    private static final Logger LOGGER = Logger.getLogger(PatientBuilder.class.getName());

    private List<String> dataField;
    private List<String> excelField;
    private List<List<Object>> dataList = new LinkedList<>();
    private List<Patient> patientList = new LinkedList<>();

    private CleanserDelagatorService cleanserDelegator = new CleanserDelegator();

    public PatientBuilder(List<String> dataField, List<String> excelField){
        this.dataField = dataField;
        this.excelField = excelField;
    }

    public List<Patient> BuildPatientList(){
        var cArg = new Class[1];
        cArg[0] = String.class;
        for (String item : this.dataField){
            try{
                dataList.add((List<Object>)cleanserDelegator.getClass().getMethod("cleanse" + item, cArg).invoke(cleanserDelegator, excelField.get(this.dataField.indexOf(item))));
            }catch (Exception ex){
                LOGGER.log(Level.SEVERE, ex.toString(), ex);
            }
        }
        List<List<Integer>> indexesForVisits = new LinkedList<>();
        for (int i = 0; i < dataList.get(0).size(); i++) {
            Patient patient = buildPatient(i);
            if(!patientList.contains(patient)){
                patientList.add(patient);
                indexesForVisits.add(new LinkedList<>());
            }
            indexesForVisits.get(patientList.indexOf(patient)).add(i);
        }

        for (int i = 0; i < patientList.size(); i++) {
            List<Visit> visitList = new LinkedList<>();
            for (int j = 0; j < indexesForVisits.get(i).size(); j++) {
                Visit visit = buildVisit(indexesForVisits.get(i).get(j));
                if (!visitList.contains(visit)) {
                    visitList.add(visit);
                }
            }
            patientList.get(i).setHospitalVisits(visitList);
        }
        if(!patientList.get(0).getHospitalVisits().get(0).getPOID().equals("")){
            for (int i = 0; i < patientList.size(); i++) {
                for (int j = 0; j < patientList.get(i).getHospitalVisits().size(); j++) {
                    String visitPoid = patientList.get(i).getHospitalVisits().get(j).getPOID();
                    patientList.get(i).getHospitalVisits().get(j).setRecords(new LinkedList<>());
                    for (int k = 0; k < dataList.get(0).size(); k++) {
                        if(dataList.get(dataField.indexOf(PatientValuesEnum.POID.toString())).get(k).toString().equals(visitPoid)){
                            Record record = buildRecord(k);
                            if(!patientList.get(i).getHospitalVisits().get(j).getRecords().contains(record)){
                                patientList.get(i).getHospitalVisits().get(j).getRecords().add(buildRecord(k));
                            }
                        };
                    }
                }
            }
        }

        return patientList;

    }

    private Patient buildPatient(Integer i){
        Patient patient = new Patient();
        patient.setFirstName(getStringValueFromEnumAndIndex(PatientValuesEnum.firstName, i));
        patient.setLastName(getStringValueFromEnumAndIndex(PatientValuesEnum.lastName, i));
        patient.setDateOfBirth(getDateValueFromEnumAndIndex(PatientValuesEnum.dateOfBirth, i));
        patient.setHospitalNumber(getStringValueFromEnumAndIndex(PatientValuesEnum.hospitalNumber, i));
        patient.setSex(getStringValueFromEnumAndIndex(PatientValuesEnum.sex, i));
        return patient;
    }

    private Visit buildVisit(Integer visitIndex){
        Visit visit = new Visit();
        visit.setPOID(getStringValueFromEnumAndIndex(PatientValuesEnum.POID, visitIndex));
        visit.setPatientCategory(getStringValueFromEnumAndIndex(PatientValuesEnum.patientCategory, visitIndex));
        visit.setPastMedicalHistory(getStringValueFromEnumAndIndex(PatientValuesEnum.pastMedicalHistory, visitIndex));
        visit.setOutcome(getBooleanValueFromEnumAndIndex(PatientValuesEnum.outcome, visitIndex));
        visit.setHistory(getStringValueFromEnumAndIndex(PatientValuesEnum.history, visitIndex));
        visit.setDischargeDateICU(getDateValueFromEnumAndIndex(PatientValuesEnum.dischargeDateICU, visitIndex));
        visit.setDischargeDateHos(getDateValueFromEnumAndIndex(PatientValuesEnum.dischargeDateHos, visitIndex));
        visit.setDiagnosis(getStringValueFromEnumAndIndex(PatientValuesEnum.diagnosis, visitIndex));
        visit.setDependencyPreAdmit(getStringValueFromEnumAndIndex(PatientValuesEnum.dependencyPreAdmit, visitIndex));
        visit.setAdmitType(getStringValueFromEnumAndIndex(PatientValuesEnum.admitType, visitIndex));
        visit.setAdmitFrom(getStringValueFromEnumAndIndex(PatientValuesEnum.admitFrom, visitIndex));
        visit.setAdmitDateICU(getDateValueFromEnumAndIndex(PatientValuesEnum.admitDateICU, visitIndex));
        visit.setAdmitDateHos(getDateValueFromEnumAndIndex(PatientValuesEnum.admitDateHos, visitIndex));
        return visit;
    }

    private Record buildRecord(Integer recordIndex){
        Record record = new Record();
        record.setDate(getDateValueFromEnumAndIndex(PatientValuesEnum.date, recordIndex));
        record.setBreathing(getStringValueFromEnumAndIndex(PatientValuesEnum.breathing, recordIndex));
        record.setCirculation(getStringValueFromEnumAndIndex(PatientValuesEnum.circulation, recordIndex));
        record.setDurationOfSession(getStringValueFromEnumAndIndex(PatientValuesEnum.durationOfSession, recordIndex));
        record.setComprehensiveRehab(getStringValueFromEnumAndIndex(PatientValuesEnum.comprehensiveRehab, recordIndex));
        record.setFitnessToParticipate(getStringValueFromEnumAndIndex(PatientValuesEnum.fitnessToParticipate, recordIndex));
        record.setDelirium(getStringValueFromEnumAndIndex(PatientValuesEnum.delirium, recordIndex));
        record.setIpat(getStringValueFromEnumAndIndex(PatientValuesEnum.ipat, recordIndex));
        record.setFitForPhysio(getBooleanValueFromEnumAndIndex(PatientValuesEnum.fitForPhysio, recordIndex));
        record.setRassHigh(getRassValueFromEnumAndIndex(PatientValuesEnum.rass, recordIndex).rassHigh);
        record.setRassLow(getRassValueFromEnumAndIndex(PatientValuesEnum.rass, recordIndex).rassLow);
        record.setCpax(buildCPAx(recordIndex));
        record.setMms(buildMMS(recordIndex));
        record.setMrc(buildMRC(recordIndex));
        record.setSofa(buildSOFA(recordIndex));
        return record;
    }

    private CPAx buildCPAx(Integer recordIndex){
         CPAx cpax = new CPAx();
         cpax.setCough(getIntegerValueFromEnumAndIndex(PatientValuesEnum.cough, recordIndex));
         cpax.setDynamicSitting(getIntegerValueFromEnumAndIndex(PatientValuesEnum.dynamicSitting, recordIndex));
         cpax.setGripStrength(getIntegerValueFromEnumAndIndex(PatientValuesEnum.gripStrength, recordIndex));
         cpax.setMovingInBed(getIntegerValueFromEnumAndIndex(PatientValuesEnum.movingInBed, recordIndex));
         cpax.setSitToStand(getIntegerValueFromEnumAndIndex(PatientValuesEnum.sitToStand, recordIndex));
         cpax.setStandingBalance(getIntegerValueFromEnumAndIndex(PatientValuesEnum.standingBalance, recordIndex));
         cpax.setStepping(getIntegerValueFromEnumAndIndex(PatientValuesEnum.stepping, recordIndex));
         cpax.setSupineToSitting(getIntegerValueFromEnumAndIndex(PatientValuesEnum.supineToSitting, recordIndex));
         cpax.setTransferBedToChair(getIntegerValueFromEnumAndIndex(PatientValuesEnum.transferBedToChair, recordIndex));
         cpax.setTotal(getTotalIntegerValueFromEnumAndIndex(PatientValuesEnum.cpaxTotal, recordIndex));
         return cpax;
    }

    private MMS buildMMS(Integer recordIndex){
        MMS mms = new MMS();
        mms.setMms(getStringValueFromEnumAndIndex(PatientValuesEnum.mms, recordIndex));
        mms.setCompleted(getBooleanValueFromEnumAndIndex(PatientValuesEnum.completed, recordIndex));
        return mms;
    }

    private MRC buildMRC(Integer recordIndex){
        MRC mrc = new MRC();
        mrc.setAnkleDorsiflexionLeft(getIntegerValueFromEnumAndIndex(PatientValuesEnum.ankleDorsiflexionLeft, recordIndex));
        mrc.setAnkleDorsiflexionRight(getIntegerValueFromEnumAndIndex(PatientValuesEnum.ankleDorsiflexionRight, recordIndex));
        mrc.setElbowFlexionLeft(getIntegerValueFromEnumAndIndex(PatientValuesEnum.elbowFlexionLeft, recordIndex));
        mrc.setElbowFlexionRight(getIntegerValueFromEnumAndIndex(PatientValuesEnum.elbowFlexionRight, recordIndex));
        mrc.setHipFlexionLeft(getIntegerValueFromEnumAndIndex(PatientValuesEnum.hipFlexionLeft, recordIndex));
        mrc.setHipFlexionRight(getIntegerValueFromEnumAndIndex(PatientValuesEnum.hipFlexionRight, recordIndex));
        mrc.setKneeExtensionLeft(getIntegerValueFromEnumAndIndex(PatientValuesEnum.kneeExtensionLeft, recordIndex));
        mrc.setKneeExtensionRight(getIntegerValueFromEnumAndIndex(PatientValuesEnum.kneeExtensionRight, recordIndex));
        mrc.setShoulderAbductionLeft(getIntegerValueFromEnumAndIndex(PatientValuesEnum.shoulderAbductionLeft, recordIndex));
        mrc.setShoulderAbductionRight(getIntegerValueFromEnumAndIndex(PatientValuesEnum.shoulderAbductionRight, recordIndex));
        mrc.setWristExtensionLeft(getIntegerValueFromEnumAndIndex(PatientValuesEnum.wristExtensionLeft, recordIndex));
        mrc.setWristExtensionRight(getIntegerValueFromEnumAndIndex(PatientValuesEnum.wristExtensionRight, recordIndex));
        mrc.setTotal(getTotalIntegerValueFromEnumAndIndex(PatientValuesEnum.mrcTotal, recordIndex));
        return mrc;
    }

    private SOFA buildSOFA(Integer recordIndex){
        SOFA sofa = new SOFA();
        sofa.setCardiovascularScore(getIntegerValueFromEnumAndIndex(PatientValuesEnum.cardiovascularScore, recordIndex));
        sofa.setCoagulationScore(getIntegerValueFromEnumAndIndex(PatientValuesEnum.coagulationScore, recordIndex));
        sofa.setKidneyScore(getIntegerValueFromEnumAndIndex(PatientValuesEnum.kidneyScore, recordIndex));
        sofa.setLiverScore(getIntegerValueFromEnumAndIndex(PatientValuesEnum.liverScore, recordIndex));
        sofa.setNervousScore(getIntegerValueFromEnumAndIndex(PatientValuesEnum.nervousScore, recordIndex));
        sofa.setRespiratoryScore(getIntegerValueFromEnumAndIndex(PatientValuesEnum.respiratoryScore, recordIndex));
        sofa.setTotal(getTotalIntegerValueFromEnumAndIndex(PatientValuesEnum.sofaTotal, recordIndex));
        return sofa;
    }


    public String getStringValueFromEnumAndIndex(PatientValuesEnum patEnum, Integer index){
        try{
            return (String)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return "";
        }
    }

    public Integer getIntegerValueFromEnumAndIndex(PatientValuesEnum patEnum, Integer index){
        try{
            return (Integer)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return -1;
        }
    }

    public Integer getTotalIntegerValueFromEnumAndIndex(PatientValuesEnum patEnum, Integer index){
        try{
            return (Integer)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return -99;
        }
    }

    public RASSHelper getRassValueFromEnumAndIndex(PatientValuesEnum patEnum, Integer index){
        try{
            return (RASSHelper) dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return new RASSHelper(-99, -99);
        }
    }

    public Boolean getBooleanValueFromEnumAndIndex(PatientValuesEnum patEnum, Integer index){
        try{
            return (Boolean)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return false;
        }
    }

    public LocalDate getDateValueFromEnumAndIndex(PatientValuesEnum patEnum, Integer index){
        try{
            return (LocalDate)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return LocalDate.of(1,1,1);
        }
    }

}
