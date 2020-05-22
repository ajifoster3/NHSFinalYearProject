package Main.Data;

import Main.Data.DataHelpers.AgeCalculator;
import Main.Cleansing.CleansingHelpers.LocalDateDeserializer;
import Main.Cleansing.CleansingHelpers.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.List;

public class Patient {

    private String hospitalNumber;
    @JsonProperty
    private List<Visit> hospitalVisits;
    private String firstName;
    private String lastName;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;
    private int age;
    private String sex;

    public Patient(){
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(String hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public List<Visit> getHospitalVisits() {
        return hospitalVisits;
    }

    public void setHospitalVisits(List<Visit> hospitalVisits) {
        this.hospitalVisits = hospitalVisits;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        try{
            return AgeCalculator.calculateAge(getDateOfBirth(), LocalDate.now());
        }catch (Exception ex){
            return -1;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object object)
    {
        boolean isSame = false;

        if (object instanceof Patient)
        {
            isSame =
                        this.getAge() == ((Patient) object).getAge() &&
                        this.getDateOfBirth().compareTo(((Patient) object).getDateOfBirth()) == 0 &&
                        this.getAge() == ((Patient) object).getAge() &&
                        this.getFirstName().equals(((Patient) object).getFirstName()) &&
                        this.getSex().equals(((Patient) object).getSex()) &&
                        this.getLastName().equals(((Patient) object).getLastName()) &&
                        this.getHospitalNumber().equals(((Patient) object).getHospitalNumber());
        }

        return isSame;
    }

}
