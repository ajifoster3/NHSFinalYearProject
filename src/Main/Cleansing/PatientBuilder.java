package Main.Cleansing;


import Main.Data.PatientRecord.*;
import Main.Enums.EnumValue;
import Main.Data.RASS;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientBuilder {

    private static final Logger LOGGER = Logger.getLogger(PatientBuilder.class.getName());

    private List<String> dataField;
    private List<String> excelField;
    private List<List<Object>> dataList = new LinkedList<>();
    private List<Patient> patientList = new LinkedList<>();

    private CleanserDelegator cleanserDelegator = new CleanserDelegator();

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
                        if(dataList.get(dataField.indexOf(EnumValue.POID.toString())).get(k).toString().equals(visitPoid)){
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
        patient.setFirstName(getStringValueFromEnumAndIndex(EnumValue.firstName, i));
        patient.setLastName(getStringValueFromEnumAndIndex(EnumValue.lastName, i));
        patient.setDateOfBirth(getDateValueFromEnumAndIndex(EnumValue.dateOfBirth, i));
        patient.setHospitalNumber(getStringValueFromEnumAndIndex(EnumValue.hospitalNumber, i));
        patient.setSex(getStringValueFromEnumAndIndex(EnumValue.sex, i));
        return patient;
    }

    private Visit buildVisit(Integer visitIndex){
        Visit visit = new Visit();
        visit.setPOID(getStringValueFromEnumAndIndex(EnumValue.POID, visitIndex));
        visit.setPatientCategory(getStringValueFromEnumAndIndex(EnumValue.patientCategory, visitIndex));
        visit.setPastMedicalHistory(getStringValueFromEnumAndIndex(EnumValue.pastMedicalHistory, visitIndex));
        visit.setOutcome(getBooleanValueFromEnumAndIndex(EnumValue.outcome, visitIndex));
        visit.setHistory(getStringValueFromEnumAndIndex(EnumValue.history, visitIndex));
        visit.setDischargeDateICU(getDateValueFromEnumAndIndex(EnumValue.dischargeDateICU, visitIndex));
        visit.setDischargeDateHos(getDateValueFromEnumAndIndex(EnumValue.dischargeDateHos, visitIndex));
        visit.setDiagnosis(getStringValueFromEnumAndIndex(EnumValue.diagnosis, visitIndex));
        visit.setDependencyPreAdmit(getStringValueFromEnumAndIndex(EnumValue.dependencyPreAdmit, visitIndex));
        visit.setAdmitType(getStringValueFromEnumAndIndex(EnumValue.admitType, visitIndex));
        visit.setAdmitFrom(getStringValueFromEnumAndIndex(EnumValue.admitFrom, visitIndex));
        visit.setAdmitDateICU(getDateValueFromEnumAndIndex(EnumValue.admitDateICU, visitIndex));
        visit.setAdmitDateHos(getDateValueFromEnumAndIndex(EnumValue.admitDateHos, visitIndex));
        return visit;
    }

    private Record buildRecord(Integer recordIndex){
        Record record = new Record();
        record.setDate(getDateValueFromEnumAndIndex(EnumValue.date, recordIndex));
        record.setBreathing(getStringValueFromEnumAndIndex(EnumValue.breathing, recordIndex));
        record.setCirculation(getStringValueFromEnumAndIndex(EnumValue.circulation, recordIndex));
        record.setDurationOfSession(getStringValueFromEnumAndIndex(EnumValue.durationOfSession, recordIndex));
        record.setComprehensiveRehab(getStringValueFromEnumAndIndex(EnumValue.comprehensiveRehab, recordIndex));
        record.setFitnessToParticipate(getStringValueFromEnumAndIndex(EnumValue.fitnessToParticipate, recordIndex));
        record.setDelirium(getStringValueFromEnumAndIndex(EnumValue.delirium, recordIndex));
        record.setIpat(getStringValueFromEnumAndIndex(EnumValue.ipat, recordIndex));
        record.setFitForPhysio(getBooleanValueFromEnumAndIndex(EnumValue.fitForPhysio, recordIndex));
        record.setRassHigh(getRassValueFromEnumAndIndex(EnumValue.rass, recordIndex).rassHigh);
        record.setRassLow(getRassValueFromEnumAndIndex(EnumValue.rass, recordIndex).rassLow);
        record.setCpax(buildCPAx(recordIndex));
        record.setMms(buildMMS(recordIndex));
        record.setMrc(buildMRC(recordIndex));
        record.setSofa(buildSOFA(recordIndex));
        return record;
    }

    private CPAx buildCPAx(Integer recordIndex){
         CPAx cpax = new CPAx();
         cpax.setCough(getIntegerValueFromEnumAndIndex(EnumValue.cough, recordIndex));
         cpax.setDynamicSitting(getIntegerValueFromEnumAndIndex(EnumValue.dynamicSitting, recordIndex));
         cpax.setGripStrength(getIntegerValueFromEnumAndIndex(EnumValue.gripStrength, recordIndex));
         cpax.setMovingInBed(getIntegerValueFromEnumAndIndex(EnumValue.movingInBed, recordIndex));
         cpax.setSitToStand(getIntegerValueFromEnumAndIndex(EnumValue.sitToStand, recordIndex));
         cpax.setStandingBalance(getIntegerValueFromEnumAndIndex(EnumValue.standingBalance, recordIndex));
         cpax.setStepping(getIntegerValueFromEnumAndIndex(EnumValue.stepping, recordIndex));
         cpax.setSupineToSitting(getIntegerValueFromEnumAndIndex(EnumValue.supineToSitting, recordIndex));
         cpax.setTransferBedToChair(getIntegerValueFromEnumAndIndex(EnumValue.transferBedToChair, recordIndex));
         cpax.setTotal(getTotalIntegerValueFromEnumAndIndex(EnumValue.cpaxTotal, recordIndex));
         return cpax;
    }

    private MMS buildMMS(Integer recordIndex){
        MMS mms = new MMS();
        mms.setMms(getStringValueFromEnumAndIndex(EnumValue.mms, recordIndex));
        mms.setCompleted(getBooleanValueFromEnumAndIndex(EnumValue.completed, recordIndex));
        return mms;
    }

    private MRC buildMRC(Integer recordIndex){
        MRC mrc = new MRC();
        mrc.setAnkleDorsiflexionLeft(getIntegerValueFromEnumAndIndex(EnumValue.ankleDorsiflexionLeft, recordIndex));
        mrc.setAnkleDorsiflexionRight(getIntegerValueFromEnumAndIndex(EnumValue.ankleDorsiflexionRight, recordIndex));
        mrc.setElbowFlexionLeft(getIntegerValueFromEnumAndIndex(EnumValue.elbowFlexionLeft, recordIndex));
        mrc.setElbowFlexionRight(getIntegerValueFromEnumAndIndex(EnumValue.elbowFlexionRight, recordIndex));
        mrc.setHipFlexionLeft(getIntegerValueFromEnumAndIndex(EnumValue.hipFlexionLeft, recordIndex));
        mrc.setHipFlexionRight(getIntegerValueFromEnumAndIndex(EnumValue.hipFlexionRight, recordIndex));
        mrc.setKneeExtensionLeft(getIntegerValueFromEnumAndIndex(EnumValue.kneeExtensionLeft, recordIndex));
        mrc.setKneeExtensionRight(getIntegerValueFromEnumAndIndex(EnumValue.kneeExtensionRight, recordIndex));
        mrc.setShoulderAbductionLeft(getIntegerValueFromEnumAndIndex(EnumValue.shoulderAbductionLeft, recordIndex));
        mrc.setShoulderAbductionRight(getIntegerValueFromEnumAndIndex(EnumValue.shoulderAbductionRight, recordIndex));
        mrc.setWristExtensionLeft(getIntegerValueFromEnumAndIndex(EnumValue.wristExtensionLeft, recordIndex));
        mrc.setWristExtensionRight(getIntegerValueFromEnumAndIndex(EnumValue.wristExtensionRight, recordIndex));
        mrc.setTotal(getTotalIntegerValueFromEnumAndIndex(EnumValue.mrcTotal, recordIndex));
        return mrc;
    }

    private SOFA buildSOFA(Integer recordIndex){
        SOFA sofa = new SOFA();
        sofa.setCardiovascularScore(getIntegerValueFromEnumAndIndex(EnumValue.cardiovascularScore, recordIndex));
        sofa.setCoagulationScore(getIntegerValueFromEnumAndIndex(EnumValue.coagulationScore, recordIndex));
        sofa.setKidneyScore(getIntegerValueFromEnumAndIndex(EnumValue.kidneyScore, recordIndex));
        sofa.setLiverScore(getIntegerValueFromEnumAndIndex(EnumValue.liverScore, recordIndex));
        sofa.setNervousScore(getIntegerValueFromEnumAndIndex(EnumValue.nervousScore, recordIndex));
        sofa.setRespiratoryScore(getIntegerValueFromEnumAndIndex(EnumValue.respiratoryScore, recordIndex));
        sofa.setTotal(getTotalIntegerValueFromEnumAndIndex(EnumValue.sofaTotal, recordIndex));
        return sofa;
    }


    public String getStringValueFromEnumAndIndex(EnumValue patEnum, Integer index){
        try{
            return (String)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return "";
        }
    }

    public Integer getIntegerValueFromEnumAndIndex(EnumValue patEnum, Integer index){
        try{
            return (Integer)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return -1;
        }
    }

    public Integer getTotalIntegerValueFromEnumAndIndex(EnumValue patEnum, Integer index){
        try{
            return (Integer)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return -99;
        }
    }

    public RASS getRassValueFromEnumAndIndex(EnumValue patEnum, Integer index){
        try{
            return (RASS) dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return new RASS(-99, -99);
        }
    }

    public Boolean getBooleanValueFromEnumAndIndex(EnumValue patEnum, Integer index){
        try{
            return (Boolean)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return false;
        }
    }

    public LocalDate getDateValueFromEnumAndIndex(EnumValue patEnum, Integer index){
        try{
            return (LocalDate)dataList.get(dataField.indexOf(patEnum.toString())).get(index);
        }catch (Exception ex){
            return LocalDate.of(1,1,1);
        }
    }

}
