package Main.PatientRecord;

import java.util.Date;
import java.util.List;

public class Patient {

    private String hospitalNumber;
    private List<Visit> hospitalVisits;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int age;
    private String sex;


    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public List<Visit> getHospitalVisits() {
        return hospitalVisits;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
