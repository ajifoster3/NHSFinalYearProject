package Main.Data.PatientRecord;

import Main.AgeCalculator;
import Main.LocalDateDeserializer;
import Main.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Visit {

    private String POID;
    private List<Record> records;
    private String diagnosis;
    private String patientCategory;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate admitDateHos;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dischargeDateHos;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate admitDateICU;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dischargeDateICU;
    private int lengthOfStayHosp;
    private int lengthOfStayICU;
    private String admitType;
    private String admitFrom;
    private String dependencyPreAdmit;
    private String pastMedicalHistory;
    private String history;
    private Boolean outcome;

    public Visit(){

    }

    public String getPOID() {
        return POID;
    }

    public void setPOID(String POID) {
        this.POID = POID;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPatientCategory() {
        return patientCategory;
    }

    public void setPatientCategory(String patientCategory) {
        this.patientCategory = patientCategory;
    }

    public LocalDate getAdmitDateHos() {
        return admitDateHos;
    }

    public void setAdmitDateHos(LocalDate admitDateHos) {
        this.admitDateHos = admitDateHos;
    }

    public LocalDate getDischargeDateHos() {
        return dischargeDateHos;
    }

    public void setDischargeDateHos(LocalDate dischargeDateHos) {
        this.dischargeDateHos = dischargeDateHos;
    }

    public LocalDate getAdmitDateICU() {
        return admitDateICU;
    }

    public void setAdmitDateICU(LocalDate admitDateICU) {
        this.admitDateICU = admitDateICU;
    }

    public LocalDate getDischargeDateICU() {
        return dischargeDateICU;
    }

    public void setDischargeDateICU(LocalDate dischargeDateICU) {
        this.dischargeDateICU = dischargeDateICU;
    }

    public int getLengthOfStayHosp() {
            try{
                Integer length = AgeCalculator.calculateDays(getAdmitDateHos(), getDischargeDateHos());
                return length;
            }catch (Exception ex){
                return -1;
            }
    }

    public void setLengthOfStayHosp(int lengthOfStayHosp) {
        this.lengthOfStayHosp = lengthOfStayHosp;
    }

    public int getLengthOfStayICU() {
            try{
                return AgeCalculator.calculateDays(getAdmitDateICU(), getDischargeDateICU());
            }catch (Exception ex){
                return -1;
            }
    }

    public void setLengthOfStayICU(int lengthOfStayICU) {
        this.lengthOfStayICU = lengthOfStayICU;
    }

    public String getAdmitType() {
        return admitType;
    }

    public void setAdmitType(String admitType) {
        this.admitType = admitType;
    }

    public String getAdmitFrom() {
        return admitFrom;
    }

    public void setAdmitFrom(String admitFrom) {
        this.admitFrom = admitFrom;
    }

    public String getDependencyPreAdmit() {
        return dependencyPreAdmit;
    }

    public void setDependencyPreAdmit(String dependencyPreAdmit) {
        this.dependencyPreAdmit = dependencyPreAdmit;
    }

    public String getPastMedicalHistory() {
        return pastMedicalHistory;
    }

    public void setPastMedicalHistory(String pastMedicalHistory) {
        this.pastMedicalHistory = pastMedicalHistory;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Boolean getOutcome() {
        if(outcome != null)
            return outcome;
        else
            return false;
    }

    public void setOutcome(Boolean outcome) {
        this.outcome = outcome;
    }

    @Override
    public boolean equals(Object object)
    {
        boolean isSame = false;

        if (object instanceof Visit)
        {
            isSame =
                            this.getDependencyPreAdmit().equals(((Visit) object).getDependencyPreAdmit()) &&
                            this.getAdmitDateHos().compareTo(((Visit) object).getAdmitDateHos()) == 0 &&
                            this.getAdmitDateICU().compareTo(((Visit) object).getAdmitDateICU()) == 0 &&
                            this.getDischargeDateHos().compareTo(((Visit) object).getDischargeDateHos()) == 0 &&
                            this.getDischargeDateICU().compareTo(((Visit) object).getDischargeDateICU()) == 0 &&
                            this.getAdmitFrom().equals(((Visit) object).getAdmitFrom()) &&
                            this.getAdmitType().equals(((Visit) object).getAdmitType()) &&
                            this.getDiagnosis().equals(((Visit) object).getDiagnosis()) &&
                            this.getHistory().equals(((Visit) object).getHistory()) &&
                            this.getPastMedicalHistory().equals(((Visit) object).getPastMedicalHistory()) &&
                            this.getPatientCategory().equals(((Visit) object).getPatientCategory()) &&
                            this.getPOID().equals(((Visit) object).getPOID()) &&
                            this.getOutcome().equals(((Visit) object).getOutcome());

        }

        return isSame;
    }
}
