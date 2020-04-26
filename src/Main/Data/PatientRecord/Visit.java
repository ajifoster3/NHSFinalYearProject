package Main.Data.PatientRecord;

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

}
