package Main.Cleansing;

import Main.Data.RASS;
import Main.ExcelReader;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CleanserDelegatorTest  {

    static final CleanserDelegator cleanserDelegator = new CleanserDelegator();
    static final ExcelReader reader = ExcelReader.getInstance();
    static final String testExcelSheet = "test/resources/AnonNHSData(March2019).xlsx";


    @BeforeAll
    public static void SetUp(){
        File file = new File(testExcelSheet);
        try {
            reader.setCurrentSheet(WorkbookFactory.create(file).getSheetAt(0));
        } catch (Exception ex) {
        }
    }

    @Test
    void cleansehospitalNumber() {
        List<String> cleansedvalues = cleanserDelegator.cleansehospitalNumber("HospitalNumber");
        List<String> testHospitalNumbers = new ArrayList<>() {{
            add("1");
            add("10");
            add("32");
            add("");
            add("a");
        }};

        assertEquals(testHospitalNumbers, cleansedvalues);
    }

    @Test
    void cleansefirstName() {
        List<String> cleansedvalues = cleanserDelegator.cleansefirstName("FirstName");
        List<String> testHospitalNumbers = new ArrayList<>() {{
            add("JESS");
            add("JOHN JONES");
            add("JACK");
            add("");
            add("JANE");
        }};

        assertEquals(testHospitalNumbers, cleansedvalues);
    }

    @Test
    void cleanselastName() {
        List<String> cleansedvalues = cleanserDelegator.cleanselastName("LastName");
        List<String> testHospitalNumbers = new ArrayList<>() {{
            add("SMITH");
            add("SAMULESON");
            add("DALE-SMITH");
            add("");
            add("RER");
        }};

        assertEquals(testHospitalNumbers, cleansedvalues);
    }

    @Test
    void cleansedateOfBirth() {
        List<LocalDate> cleansedvalues = cleanserDelegator.cleansedateOfBirth("DateOfBirth");
        List<LocalDate> testValues = new ArrayList<>() {{
            add(LocalDate.of(1995, 02, 01));
            add(LocalDate.of(1992, 01, 21));
            add(LocalDate.of(1992, 01, 21));
            add(LocalDate.of(1, 01, 01));
            add(LocalDate.of(1992, 01, 21));
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseage() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseage("Age");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(-23);
            add(99);
            add(-1);
            add(-1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansesex() {
        List<String> cleansedvalues = cleanserDelegator.cleansesex("Sex");
        List<String> testHospitalNumbers = new ArrayList<>() {{
            add("MALE");
            add("FEMALE");
            add("UNDISCLOSED");
            add("");
            add("MALE");
        }};

        assertEquals(testHospitalNumbers, cleansedvalues);
    }

    @Test
    void cleansePOID() {
        List<String> cleansedvalues = cleanserDelegator.cleansePOID("POID");
        List<String> testValues = new ArrayList<>() {{
            add("1");
            add("2");
            add("3");
            add("");
            add("0");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansediagnosis() {
        List<String> cleansedvalues = cleanserDelegator.cleansediagnosis("Diagnosis");
        List<String> testValues = new ArrayList<>() {{
            add("SEPTIC SHOCK");
            add("INTRAPARAENCYMAL BRAIN HAEMORRHAGE");
            add("OTHER");
            add("");
            add("-1");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansepatientCategory() {
        List<String> cleansedvalues = cleanserDelegator.cleansepatientCategory("PatientCategory");
        List<String> testValues = new ArrayList<>() {{
            add("GENERAL MEDICINE");
            add("NEUROSURGERY");
            add("NEUROSURGERY");
            add("");
            add("GENERAL MEDICINE");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseadmitDateHos() {
        List<LocalDate> cleansedvalues = cleanserDelegator.cleanseadmitDateHos("HospitalAdmitDate");
        List<LocalDate> testValues = new ArrayList<>() {{
            add(LocalDate.of(1923, 02, 01));
            add(LocalDate.of(1972, 01, 21));
            add(LocalDate.of(1992, 01, 21));
            add(LocalDate.of(1, 01, 01));
            add(LocalDate.of(1990, 01, 21));
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansedischargeDateHos() {
        List<LocalDate> cleansedvalues = cleanserDelegator.cleansedischargeDateHos("HospitalDischargeDate");
        List<LocalDate> testValues = new ArrayList<>() {{
            add(LocalDate.of(1923, 02, 01));
            add(LocalDate.of(1972, 01, 21));
            add(LocalDate.of(1992, 01, 21));
            add(LocalDate.of(1, 01, 01));
            add(LocalDate.of(1990, 01, 21));
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseadmitDateICU() {
        List<LocalDate> cleansedvalues = cleanserDelegator.cleanseadmitDateICU("ICUAdmitDate");
        List<LocalDate> testValues = new ArrayList<>() {{
            add(LocalDate.of(1923, 02, 01));
            add(LocalDate.of(1972, 01, 21));
            add(LocalDate.of(1992, 01, 21));
            add(LocalDate.of(1, 01, 01));
            add(LocalDate.of(1990, 01, 21));
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansedischargeDateICU() {
        List<LocalDate> cleansedvalues = cleanserDelegator.cleansedischargeDateICU("ICUDischargeDate");
        List<LocalDate> testValues = new ArrayList<>() {{
            add(LocalDate.of(1923, 02, 01));
            add(LocalDate.of(1972, 01, 21));
            add(LocalDate.of(1992, 01, 21));
            add(LocalDate.of(1, 01, 01));
            add(LocalDate.of(1990, 01, 21));
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanselengthOfStayHosp() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanselengthOfStayHosp("LengthOfStayInHosp");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(-1);
            add(0);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanselengthOfStayICU() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanselengthOfStayICU("LengthOfStayInICU");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(-1);
            add(0);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseadmitType() {
        List<String> cleansedvalues = cleanserDelegator.cleanseadmitType("AdmitType");
        List<String> testValues = new ArrayList<>() {{
            add("UNPLANNED - POST SURGERY");
            add("PLANNED - POST SURGERY (LOCAL)");
            add("UNPLANNED - LOCAL MEDICAL PATIENT");
            add("");
            add("UNPLANNED - LOCAL MEDICAL PATIENT");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseadmitFrom() {
        List<String> cleansedvalues = cleanserDelegator.cleanseadmitFrom("AdmitFrom");
        List<String> testValues = new ArrayList<>() {{
            add("SURGICAL INPATIENT WARD");
            add("GENERAL THEATRES");
            add("GENERAL THEATRES");
            add("");
            add("");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansedependencyPreAdmit() {
        List<String> cleansedvalues = cleanserDelegator.cleansedependencyPreAdmit("DepedancyPreAdmit");
        List<String> testValues = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
            add("");
            add("1");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansepastMedicalHistory() {
        List<String> cleansedvalues = cleanserDelegator.cleansepastMedicalHistory("MedicalHistory");
        List<String> testValues = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
            add("");
            add("1");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansehistory() {
        List<String> cleansedvalues = cleanserDelegator.cleansehistory("History");
        List<String> testValues = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
            add("");
            add("1");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseoutcome() {
    }

    @Test
    void cleansedate() {
        List<LocalDate> cleansedvalues = cleanserDelegator.cleansedate("Date");
        List<LocalDate> testValues = new ArrayList<>() {{
            add(LocalDate.of(1923, 02, 01));
            add(LocalDate.of(1972, 01, 21));
            add(LocalDate.of(1992, 01, 21));
            add(LocalDate.of(1, 01, 01));
            add(LocalDate.of(1990, 01, 21));
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansebreathing() {
        List<String> cleansedvalues = cleanserDelegator.cleansebreathing("Breathing");
        List<String> testValues = new ArrayList<>() {{
            add("SV ON O2");
            add("SIMV");
            add("ASB");
            add("");
            add("0");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansecirculation() {
        List<String> cleansedvalues = cleanserDelegator.cleansecirculation("Circulation");
        List<String> testValues = new ArrayList<>() {{
            add("INOTROPES YES");
            add("INOTROPES YES");
            add("INOTROPES NO");
            add("");
            add("0");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansedurationOfSession() {
        List<String> cleansedvalues = cleanserDelegator.cleansedurationOfSession("DurationOfSession");
        List<String> testValues = new ArrayList<>() {{
            add("0");
            add("16-30");
            add("16-30");
            add("");
            add("0");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansefitnessToParticipate() {
        List<String> cleansedvalues = cleanserDelegator.cleansefitnessToParticipate("FitnessToParticipate");
        List<String> testValues = new ArrayList<>() {{
            add("NO LACK OF STAFF");
            add("YES");
            add("YES");
            add("0");
            add("NO UNSTABLE/UNWELL");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansedelirium() {
        List<String> cleansedvalues = cleanserDelegator.cleansedelirium("Delerium");
        List<String> testValues = new ArrayList<>() {{
            add(">=2 DELIRIUM PRESENT");
            add("");
            add("");
            add("");
            add("");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseipat() {
        List<String> cleansedvalues = cleanserDelegator.cleanseipat("IPAT");
        List<String> testValues = new ArrayList<>() {{
            add("5");
            add("14");
            add("3");
            add("");
            add("2");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansefitForPhysio() {
        List<Boolean> cleansedvalues = cleanserDelegator.cleansefitForPhysio("FitForPhysio");
        List<Boolean> testValues = new ArrayList<>() {{
            add(false);
            add(true);
            add(true);
            add(false);
            add(false);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanserass() {
        List<RASS> cleansedvalues = cleanserDelegator.cleanserass("Rass");
        List<Integer> lowRASS = new ArrayList<>() {{
            add(0);
            add(-4);
            add(0);
            add(-1);
            add(-1);
        }};

        List<Integer> highRASS = new ArrayList<>() {{
            add(0);
            add(2);
            add(0);
            add(3);
            add(0);
        }};

        assertEquals(lowRASS, cleansedvalues.stream().map(value -> value.rassLow).collect(Collectors.toList()));
        assertEquals(highRASS, cleansedvalues.stream().map(value -> value.rassHigh).collect(Collectors.toList()));
    }

    @Test
    void cleansecough() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansecough("Cough");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansemovingInBed() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansemovingInBed("MovingInBed");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansesupineToSitting() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansesupineToSitting("SupineToSitting");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansedynamicSitting() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansedynamicSitting("DynamicSitting");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansestandingBalance() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansestandingBalance("StandingBalance");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansesitToStand() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansesitToStand("SitToStand");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansetransferBedToChair() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansetransferBedToChair("TransferBedToChair");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansestepping() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansestepping("Stepping");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansegripStrength() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansegripStrength("GripStrength");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansecompleted() {
        List<Boolean> cleansedvalues = cleanserDelegator.cleansecompleted("Completed");
        List<Boolean> testValues = new ArrayList<>() {{
            add(true);
            add(false);
            add(false);
            add(true);
            add(false);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansemms() {
        List<String> cleansedvalues = cleanserDelegator.cleansemms("MMS");
        List<String> testValues = new ArrayList<>() {{
            add("0");
            add("1 PASSIVE MVMT, ACTIVE EXERCISE, CHAIR POSN IN BED");
            add("UNWELL");
            add("1 PASSIVE MVMT, ACTIVE EXERCISE, CHAIR POSN IN BED");
            add("1 PASSIVE MVMT, ACTIVE EXERCISE, CHAIR POSN IN BED");
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseshoulderAbductionRight() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseshoulderAbductionRight("ShoulderAbductionRight");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseshoulderAbductionLeft() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseshoulderAbductionLeft("ShoulderAbductionLeft");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseelbowFlexionRight() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseelbowFlexionRight("ElbowFlexionRight");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseelbowFlexionLeft() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseelbowFlexionLeft("ElbowFlexionLeft");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansewristExtensionRight() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansewristExtensionRight("WristExtensionRight");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansewristExtensionLeft() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansewristExtensionLeft("WristExtensionLeft");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansehipFlexionRight() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansehipFlexionRight("HipFlexionRight");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansehipFlexionLeft() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansehipFlexionLeft("HipFlexionLeft");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansekneeExtensionRight() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansekneeExtensionRight("KneeExtensionRight");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansekneeExtensionLeft() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansekneeExtensionLeft("KneeExtensionLeft");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseankleDorsiflexionRight() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseankleDorsiflexionRight("AnkleDosiflexionRight");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseankleDorsiflexionLeft() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseankleDorsiflexionLeft("AnkleDorsiflexionLeft");
        List<Integer> testValues = new ArrayList<>() {{
            add(1);
            add(4);
            add(2);
            add(-1);
            add(1);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanserespiratoryScore() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanserespiratoryScore("RespiratoryScore");
        List<Integer> testValues = new ArrayList<>() {{
            add(0);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansenervousScore() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansenervousScore("NervousScore");
        List<Integer> testValues = new ArrayList<>() {{
            add(0);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansecardiovascularScore() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansecardiovascularScore("CardiovascularScore");
        List<Integer> testValues = new ArrayList<>() {{
            add(0);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleanseliverScore() {
        List<Integer> cleansedvalues = cleanserDelegator.cleanseliverScore("LiverScore");
        List<Integer> testValues = new ArrayList<>() {{
            add(0);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansecoagulationScore() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansecoagulationScore("CoagulationScore");
        List<Integer> testValues = new ArrayList<>() {{
            add(0);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }

    @Test
    void cleansekidneyScore() {
        List<Integer> cleansedvalues = cleanserDelegator.cleansekidneyScore("KidneyScore");
        List<Integer> testValues = new ArrayList<>() {{
            add(0);
            add(0);
            add(1);
            add(-1);
            add(3);
        }};

        assertEquals(testValues, cleansedvalues);
    }
}