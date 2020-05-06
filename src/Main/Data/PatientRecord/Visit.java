package Main.Data.PatientRecord;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Visit {

    private String POID;
    private List<Record> records;
    private String diagnosis;
    private String patientCategory;
    private LocalDate admitDateHos;
    private LocalDate dischargeDateHos;
    private LocalDate admitDateICU;
    private LocalDate dischargeDateICU;
    private int lengthOfStayHosp;
    private int lengthOfStayICU;
    private String admitType;
    private String admitFrom;
    private String dependencyPreAdmit;
    private String pastMedicalHistory;
    private String history;
    private Boolean outcome;

}
