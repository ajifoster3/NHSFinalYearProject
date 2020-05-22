package Main.Building;


import Main.Cleansing.CleanserDelegator;
import Main.Building.BuildingHelper.CleanserDelagatorService;
import Main.Controllers.ControllerHelpers.PatientBuilderService;
import Main.Data.*;
import Main.Enums.PatientHeadersEnum;
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
                        if(dataList.get(dataField.indexOf(PatientHeadersEnum.POID.toString())).get(k).toString().equals(visitPoid)){
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
        patient.setFirstName(getStringValueFromEnumAndIndex(PatientHeadersEnum.firstName, i));
        patient.setLastName(getStringValueFromEnumAndIndex(PatientHeadersEnum.lastName, i));
        patient.setDateOfBirth(getDateValueFromEnumAndIndex(PatientHeadersEnum.dateOfBirth, i));
        patient.setHospitalNumber(getStringValueFromEnumAndIndex(PatientHeadersEnum.hospitalNumber, i));
        patient.setSex(getStringValueFromEnumAndIndex(PatientHeadersEnum.sex, i));
        return patient;
    }

    private Visit buildVisit(Integer visitIndex){
        Visit visit = new Visit();
        visit.setPOID(getStringValueFromEnumAndIndex(PatientHeadersEnum.POID, visitIndex));
        visit.setPatientCategory(getStringValueFromEnumAndIndex(PatientHeadersEnum.patientCategory, visitIndex));
        visit.setPastMedicalHistory(getStringValueFromEnumAndIndex(PatientHeadersEnum.pastMedicalHistory, visitIndex));
        visit.setOutcome(getBooleanValueFromEnumAndIndex(PatientHeadersEnum.outcome, visitIndex));
        visit.setHistory(getStringValueFromEnumAndIndex(PatientHeadersEnum.history, visitIndex));
        visit.setDischargeDateICU(getDateValueFromEnumAndIndex(PatientHeadersEnum.dischargeDateICU, visitIndex));
        visit.setDischargeDateHos(getDateValueFromEnumAndIndex(PatientHeadersEnum.dischargeDateHos, visitIndex));
        visit.setDiagnosis(getStringValueFromEnumAndIndex(PatientHeadersEnum.diagnosis, visitIndex));
        visit.setDependencyPreAdmit(getStringValueFromEnumAndIndex(PatientHeadersEnum.dependencyPreAdmit, visitIndex));
        visit.setAdmitType(getStringValueFromEnumAndIndex(PatientHeadersEnum.admitType, visitIndex));
        visit.setAdmitFrom(getStringValueFromEnumAndIndex(PatientHeadersEnum.admitFrom, visitIndex));
        visit.setAdmitDateICU(getDateValueFromEnumAndIndex(PatientHeadersEnum.admitDateICU, visitIndex));
        visit.setAdmitDateHos(getDateValueFromEnumAndIndex(PatientHeadersEnum.admitDateHos, visitIndex));
        return visit;
    }

    private Record buildRecord(Integer recordIndex){
        Record record = new Record();
        record.setDate(getDateValueFromEnumAndIndex(PatientHeadersEnum.date, recordIndex));
        record.setBreathing(getStringValueFromEnumAndIndex(PatientHeadersEnum.breathing, recordIndex));
        record.setCirculation(getStringValueFromEnumAndIndex(PatientHeadersEnum.circulation, recordIndex));
        record.setDurationOfSession(getStringValueFromEnumAndIndex(PatientHeadersEnum.durationOfSession, recordIndex));
        record.setComprehensiveRehab(getStringValueFromEnumAndIndex(PatientHeadersEnum.comprehensiveRehab, recordIndex));
        record.setFitnessToParticipate(getStringValueFromEnumAndIndex(PatientHeadersEnum.fitnessToParticipate, recordIndex));
        record.setDelirium(getStringValueFromEnumAndIndex(PatientHeadersEnum.delirium, recordIndex));
        record.setIpat(getStringValueFromEnumAndIndex(PatientHeadersEnum.ipat, recordIndex));
        record.setFitForPhysio(getBooleanValueFromEnumAndIndex(PatientHeadersEnum.fitForPhysio, recordIndex));
        record.setRassHigh(getRassValueFromEnumAndIndex(PatientHeadersEnum.rass, recordIndex).rassHigh);
        record.setRassLow(getRassValueFromEnumAndIndex(PatientHeadersEnum.rass, recordIndex).rassLow);
        record.setCpax(buildCPAx(recordIndex));
        record.setMms(buildMMS(recordIndex));
        record.setMrc(buildMRC(recordIndex));
        record.setSofa(buildSOFA(recordIndex));
        return record;
    }

    private CPAx buildCPAx(Integer recordIndex){
         CPAx cpax = new CPAx();
         cpax.setCough(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.cough, recordIndex));
         cpax.setDynamicSitting(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.dynamicSitting, recordIndex));
         cpax.setGripStrength(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.gripStrength, recordIndex));
         cpax.setMovingInBed(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.movingInBed, recordIndex));
         cpax.setSitToStand(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.sitToStand, recordIndex));
         cpax.setStandingBalance(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.standingBalance, recordIndex));
         cpax.setStepping(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.stepping, recordIndex));
         cpax.setSupineToSitting(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.supineToSitting, recordIndex));
         cpax.setTransferBedToChair(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.transferBedToChair, recordIndex));
         cpax.setTotal(getTotalIntegerValueFromEnumAndIndex(PatientHeadersEnum.cpaxTotal, recordIndex));
         return cpax;
    }

    private MMS buildMMS(Integer recordIndex){
        MMS mms = new MMS();
        mms.setMms(getStringValueFromEnumAndIndex(PatientHeadersEnum.mms, recordIndex));
        mms.setCompleted(getBooleanValueFromEnumAndIndex(PatientHeadersEnum.completed, recordIndex));
        return mms;
    }

    private MRC buildMRC(Integer recordIndex){
        MRC mrc = new MRC();
        mrc.setAnkleDorsiflexionLeft(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.ankleDorsiflexionLeft, recordIndex));
        mrc.setAnkleDorsiflexionRight(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.ankleDorsiflexionRight, recordIndex));
        mrc.setElbowFlexionLeft(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.elbowFlexionLeft, recordIndex));
        mrc.setElbowFlexionRight(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.elbowFlexionRight, recordIndex));
        mrc.setHipFlexionLeft(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.hipFlexionLeft, recordIndex));
        mrc.setHipFlexionRight(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.hipFlexionRight, recordIndex));
        mrc.setKneeExtensionLeft(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.kneeExtensionLeft, recordIndex));
        mrc.setKneeExtensionRight(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.kneeExtensionRight, recordIndex));
        mrc.setShoulderAbductionLeft(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.shoulderAbductionLeft, recordIndex));
        mrc.setShoulderAbductionRight(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.shoulderAbductionRight, recordIndex));
        mrc.setWristExtensionLeft(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.wristExtensionLeft, recordIndex));
        mrc.setWristExtensionRight(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.wristExtensionRight, recordIndex));
        mrc.setTotal(getTotalIntegerValueFromEnumAndIndex(PatientHeadersEnum.mrcTotal, recordIndex));
        return mrc;
    }

    private SOFA buildSOFA(Integer recordIndex){
        SOFA sofa = new SOFA();
        sofa.setCardiovascularScore(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.cardiovascularScore, recordIndex));
        sofa.setCoagulationScore(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.coagulationScore, recordIndex));
        sofa.setKidneyScore(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.kidneyScore, recordIndex));
        sofa.setLiverScore(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.liverScore, recordIndex));
        sofa.setNervousScore(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.nervousScore, recordIndex));
        sofa.setRespiratoryScore(getIntegerValueFromEnumAndIndex(PatientHeadersEnum.respiratoryScore, recordIndex));
        sofa.setTotal(getTotalIntegerValueFromEnumAndIndex(PatientHeadersEnum.sofaTotal, recordIndex));
        return sofa;
    }


    public String getStringValueFromEnumAndIndex(PatientHeadersEnum patEnum, Integer index){
        try{
            return (String)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return "";
        }
    }

    public Integer getIntegerValueFromEnumAndIndex(PatientHeadersEnum patEnum, Integer index){
        try{
            return (Integer)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return -1;
        }
    }

    public Integer getTotalIntegerValueFromEnumAndIndex(PatientHeadersEnum patEnum, Integer index){
        try{
            return (Integer)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return -99;
        }
    }

    public RASSHelper getRassValueFromEnumAndIndex(PatientHeadersEnum patEnum, Integer index){
        try{
            return (RASSHelper) dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return new RASSHelper(-99, -99);
        }
    }

    public Boolean getBooleanValueFromEnumAndIndex(PatientHeadersEnum patEnum, Integer index){
        try{
            return (Boolean)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return false;
        }
    }

    public LocalDate getDateValueFromEnumAndIndex(PatientHeadersEnum patEnum, Integer index){
        try{
            return (LocalDate)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return LocalDate.of(1,1,1);
        }
    }

}
