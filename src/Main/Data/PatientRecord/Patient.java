package Main.Data.PatientRecord;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Patient {

    public Patient(){
        
    }

    private String hospitalNumber;
    private List<Visit> hospitalVisits;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int age;
    private String sex;

}
