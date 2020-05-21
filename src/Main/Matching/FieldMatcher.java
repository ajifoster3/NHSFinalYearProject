package Main.Matching;


import Main.Cleansing.CleanserDelegator;
import Main.Controllers.FieldMatcherController;
import Main.Data.PatientRecord.*;
import Main.Enums.PatientRecordEnum;
import Main.Data.RASS;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FieldMatcher {

    private static final Logger LOGGER = Logger.getLogger(FieldMatcherController.class.getName());

    private List<String> dataField;
    private List<String> excelField;
    private List<List<Object>> dataList = new LinkedList<>();
    private List<Patient> patientList = new LinkedList<>();

    private CleanserDelegator cleanserDelegator = new CleanserDelegator();

    public  FieldMatcher(List<String> dataField,List<String> excelField){
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
                        if(dataList.get(dataField.indexOf(PatientRecordEnum.POID.toString())).get(k).toString().equals(visitPoid)){
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
        patient.setFirstName(getStringValueFromEnumAndIndex(PatientRecordEnum.firstName, i));
        patient.setLastName(getStringValueFromEnumAndIndex(PatientRecordEnum.lastName, i));
        patient.setDateOfBirth(getDateValueFromEnumAndIndex(PatientRecordEnum.dateOfBirth, i));
        patient.setHospitalNumber(getStringValueFromEnumAndIndex(PatientRecordEnum.hospitalNumber, i));
        patient.setSex(getStringValueFromEnumAndIndex(PatientRecordEnum.sex, i));
        return patient;
    }

    private Visit buildVisit(Integer visitIndex){
        Visit visit = new Visit();
        visit.setPOID(getStringValueFromEnumAndIndex(PatientRecordEnum.POID, visitIndex));
        visit.setPatientCategory(getStringValueFromEnumAndIndex(PatientRecordEnum.patientCategory, visitIndex));
        visit.setPastMedicalHistory(getStringValueFromEnumAndIndex(PatientRecordEnum.pastMedicalHistory, visitIndex));
        visit.setOutcome(getBooleanValueFromEnumAndIndex(PatientRecordEnum.outcome, visitIndex));
        visit.setHistory(getStringValueFromEnumAndIndex(PatientRecordEnum.history, visitIndex));
        visit.setDischargeDateICU(getDateValueFromEnumAndIndex(PatientRecordEnum.dischargeDateICU, visitIndex));
        visit.setDischargeDateHos(getDateValueFromEnumAndIndex(PatientRecordEnum.dischargeDateHos, visitIndex));
        visit.setDiagnosis(getStringValueFromEnumAndIndex(PatientRecordEnum.diagnosis, visitIndex));
        visit.setDependencyPreAdmit(getStringValueFromEnumAndIndex(PatientRecordEnum.dependencyPreAdmit, visitIndex));
        visit.setAdmitType(getStringValueFromEnumAndIndex(PatientRecordEnum.admitType, visitIndex));
        visit.setAdmitFrom(getStringValueFromEnumAndIndex(PatientRecordEnum.admitFrom, visitIndex));
        visit.setAdmitDateICU(getDateValueFromEnumAndIndex(PatientRecordEnum.admitDateICU, visitIndex));
        visit.setAdmitDateHos(getDateValueFromEnumAndIndex(PatientRecordEnum.admitDateHos, visitIndex));
        return visit;
    }

    private Record buildRecord(Integer recordIndex){
        Record record = new Record();
        record.setDate(getDateValueFromEnumAndIndex(PatientRecordEnum.date, recordIndex));
        record.setBreathing(getStringValueFromEnumAndIndex(PatientRecordEnum.breathing, recordIndex));
        record.setCirculation(getStringValueFromEnumAndIndex(PatientRecordEnum.circulation, recordIndex));
        record.setDurationOfSession(getStringValueFromEnumAndIndex(PatientRecordEnum.durationOfSession, recordIndex));
        record.setComprehensiveRehab(getStringValueFromEnumAndIndex(PatientRecordEnum.comprehensiveRehab, recordIndex));
        record.setFitnessToParticipate(getStringValueFromEnumAndIndex(PatientRecordEnum.fitnessToParticipate, recordIndex));
        record.setDelirium(getStringValueFromEnumAndIndex(PatientRecordEnum.delirium, recordIndex));
        record.setIpat(getStringValueFromEnumAndIndex(PatientRecordEnum.ipat, recordIndex));
        record.setFitForPhysio(getBooleanValueFromEnumAndIndex(PatientRecordEnum.fitForPhysio, recordIndex));
        record.setRassHigh(getRassValueFromEnumAndIndex(PatientRecordEnum.rass, recordIndex).rassHigh);
        record.setRassLow(getRassValueFromEnumAndIndex(PatientRecordEnum.rass, recordIndex).rassLow);
        record.setCpax(buildCPAx(recordIndex));
        record.setMms(buildMMS(recordIndex));
        record.setMrc(buildMRC(recordIndex));
        record.setSofa(buildSOFA(recordIndex));
        return record;
    }

    private CPAx buildCPAx(Integer recordIndex){
         CPAx cpax = new CPAx();
         cpax.setCough(getIntegerValueFromEnumAndIndex(PatientRecordEnum.cough, recordIndex));
         cpax.setDynamicSitting(getIntegerValueFromEnumAndIndex(PatientRecordEnum.dynamicSitting, recordIndex));
         cpax.setGripStrength(getIntegerValueFromEnumAndIndex(PatientRecordEnum.gripStrength, recordIndex));
         cpax.setMovingInBed(getIntegerValueFromEnumAndIndex(PatientRecordEnum.movingInBed, recordIndex));
         cpax.setSitToStand(getIntegerValueFromEnumAndIndex(PatientRecordEnum.sitToStand, recordIndex));
         cpax.setStandingBalance(getIntegerValueFromEnumAndIndex(PatientRecordEnum.standingBalance, recordIndex));
         cpax.setStepping(getIntegerValueFromEnumAndIndex(PatientRecordEnum.stepping, recordIndex));
         cpax.setSupineToSitting(getIntegerValueFromEnumAndIndex(PatientRecordEnum.supineToSitting, recordIndex));
         cpax.setTransferBedToChair(getIntegerValueFromEnumAndIndex(PatientRecordEnum.transferBedToChair, recordIndex));
         return cpax;
    }

    private MMS buildMMS(Integer recordIndex){
        MMS mms = new MMS();
        mms.setMms(getStringValueFromEnumAndIndex(PatientRecordEnum.mms, recordIndex));
        mms.setCompleted(getBooleanValueFromEnumAndIndex(PatientRecordEnum.completed, recordIndex));
        return mms;
    }

    private MRC buildMRC(Integer recordIndex){
        MRC mrc = new MRC();
        mrc.setAnkleDorsiflexionLeft(getIntegerValueFromEnumAndIndex(PatientRecordEnum.ankleDorsiflexionLeft, recordIndex));
        mrc.setAnkleDorsiflexionRight(getIntegerValueFromEnumAndIndex(PatientRecordEnum.ankleDorsiflexionRight, recordIndex));
        mrc.setElbowFlexionLeft(getIntegerValueFromEnumAndIndex(PatientRecordEnum.elbowFlexionLeft, recordIndex));
        mrc.setElbowFlexionRight(getIntegerValueFromEnumAndIndex(PatientRecordEnum.elbowFlexionRight, recordIndex));
        mrc.setHipFlexionLeft(getIntegerValueFromEnumAndIndex(PatientRecordEnum.hipFlexionLeft, recordIndex));
        mrc.setHipFlexionRight(getIntegerValueFromEnumAndIndex(PatientRecordEnum.hipFlexionRight, recordIndex));
        mrc.setKneeExtensionLeft(getIntegerValueFromEnumAndIndex(PatientRecordEnum.kneeExtensionLeft, recordIndex));
        mrc.setKneeExtensionRight(getIntegerValueFromEnumAndIndex(PatientRecordEnum.kneeExtensionRight, recordIndex));
        mrc.setShoulderAbductionLeft(getIntegerValueFromEnumAndIndex(PatientRecordEnum.shoulderAbductionLeft, recordIndex));
        mrc.setShoulderAbductionRight(getIntegerValueFromEnumAndIndex(PatientRecordEnum.shoulderAbductionRight, recordIndex));
        mrc.setWristExtensionLeft(getIntegerValueFromEnumAndIndex(PatientRecordEnum.wristExtensionLeft, recordIndex));
        mrc.setWristExtensionRight(getIntegerValueFromEnumAndIndex(PatientRecordEnum.wristExtensionRight, recordIndex));
        return mrc;
    }

    private SOFA buildSOFA(Integer recordIndex){
        SOFA sofa = new SOFA();
        sofa.setCardiovascularScore(getIntegerValueFromEnumAndIndex(PatientRecordEnum.cardiovascularScore, recordIndex));
        sofa.setCoagulationScore(getIntegerValueFromEnumAndIndex(PatientRecordEnum.coagulationScore, recordIndex));
        sofa.setKidneyScore(getIntegerValueFromEnumAndIndex(PatientRecordEnum.kidneyScore, recordIndex));
        sofa.setLiverScore(getIntegerValueFromEnumAndIndex(PatientRecordEnum.liverScore, recordIndex));
        sofa.setNervousScore(getIntegerValueFromEnumAndIndex(PatientRecordEnum.nervousScore, recordIndex));
        sofa.setRespiratoryScore(getIntegerValueFromEnumAndIndex(PatientRecordEnum.respiratoryScore, recordIndex));
        return sofa;
    }


    public String getStringValueFromEnumAndIndex(PatientRecordEnum patEnum, Integer index){
        try{
            return (String)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return "";
        }
    }

    public Integer getIntegerValueFromEnumAndIndex(PatientRecordEnum patEnum, Integer index){
        try{
            return (Integer)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return -1;
        }
    }

    public RASS getRassValueFromEnumAndIndex(PatientRecordEnum patEnum, Integer index){
        try{
            return (RASS) dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return new RASS(-99, -99);
        }
    }

    public Boolean getBooleanValueFromEnumAndIndex(PatientRecordEnum patEnum, Integer index){
        try{
            return (Boolean)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return false;
        }
    }

    public LocalDate getDateValueFromEnumAndIndex(PatientRecordEnum patEnum, Integer index){
        try{
            return (LocalDate)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return LocalDate.of(1,1,1);
        }
    }

}
