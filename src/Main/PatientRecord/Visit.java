package Main.PatientRecord;

import java.util.Date;
import java.util.List;

public class Visit {

    private String POID;
    private List<Record> records;
    private String diagnosis;
    private String patientCategory;
    private Date admitDateHos;
    private Date dischargeDateHos;
    private Date admitDateICU;
    private Date dischargeDateICU;
    private int lengthOfStayHosp;
    private int lengthOfStayICU;
    private String admitType;
    private String admitFrom;
    private String dependencyPreAdmit;
    private String pastMedicalHistory;
    private String history;
    private Boolean outcome;


    public String getPOID() {
        return POID;
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPatientCategory() {
        return patientCategory;
    }

    public Date getAdmitDateHos() {
        return admitDateHos;
    }

    public Date getDischargeDateHos() {
        return dischargeDateHos;
    }

    public Date getAdmitDateICU() {
        return admitDateICU;
    }

    public Date getDischargeDateICU() {
        return dischargeDateICU;
    }

    public int getLengthOfStayHosp() {
        return lengthOfStayHosp;
    }

    public int getLengthOfStayICU() {
        return lengthOfStayICU;
    }

    public String getAdmitType() {
        return admitType;
    }

    public String getAdmitFrom() {
        return admitFrom;
    }

    public String getDependencyPreAdmit() {
        return dependencyPreAdmit;
    }

    public String getPastMedicalHistory() {
        return pastMedicalHistory;
    }

    public String getHistory() {
        return history;
    }

    public Boolean getOutcome() {
        return outcome;
    }
}
