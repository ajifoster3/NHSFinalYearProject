package Main.Helpers;

import Main.Data.PatientRecord.*;
import Main.Main;
import org.sqlite.SQLiteConfig;

import java.io.File;
import java.sql.*;
import java.util.List;

import static javax.swing.UIManager.getInt;

public class DBHelper {


    public static Connection getConnection(String fileName) throws ClassNotFoundException {
        Connection connection = null;
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            connection = DriverManager.getConnection(fileName,config.toProperties());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }

    public static void createNewDatabase(String fileName) {

        File file = new File(fileName);

        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createDataTables(String fileName){
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = getConnection("jdbc:sqlite:" + fileName);
            System.out.println("Opened database successfully");

            createPatientTable(c);
            createVisitTable(c);
            createRecordTable(c);
            createCPAxTable(c);
            createMMSTable(c);
            createMRCTable(c);
            createSOFATable(c);

            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void createPatientTable(Connection c){

        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE PATIENT " +
                    "(HOSPNO INT PRIMARY KEY     NOT NULL," +
                    " FIRSTNAME           TEXT, " +
                    " LASTNAME            TEXT, " +
                    " DATEOFBIRTH         DATE, " +
                    " AGE            INT, " +
                    " SEX         TEXT)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void createVisitTable(Connection c){

        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE VISIT " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "POID TEXT     NOT NULL," +
                    "HOSPNO TEXT     NOT NULL," +
                    "DIAGNOSIS           TEXT, " +
                    "PATIENTCATEGORY            TEXT, " +
                    "HOSPITALADMITDATE         DATE, " +
                    "HOSPITALDISCHARGEDATE         DATE, " +
                    "ICUADMITDATE DATE     NOT NULL," +
                    "ICUDISCHARGEDATE DATE     NOT NULL," +
                    "ADMITTYPE            TEXT, " +
                    "ADMITFROM         TEXT,"+
                    "DEPENDENCYPREADMISSION            TEXT, " +
                    "PASTMEDICALHISTORY            TEXT, " +
                    "HISTORY            TEXT," +
                    "FOREIGN KEY(HOSPNO) REFERENCES PATIENT(HOSPNO))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void createRecordTable(Connection c){

        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE RECORD " +
                    "(DATE DATE NOT NULL," +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "VISITID     INTEGER," +
                    "BREATHING           TEXT, " +
                    "CIRCULATION            TEXT, " +
                    "DURATIONOFSESSION         TEXT, " +
                    "COMPREHENSIVEREHAB            TEXT, " +
                    "FITNESSTOPARTICIPATE            TEXT, " +
                    "DELERIUM            TEXT, " +
                    "IPAT            TEXT, " +
                    "FITFORPHYSIO            TEXT, " +
                    "RASSLOW            INT, " +
                    "RASSHIGH         INT," +
                    "FOREIGN KEY(VISITID) REFERENCES VISIT(ID))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void createSOFATable(Connection c){

        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE SOFA " +
                    "(RECORDID           INTEGER, " +
                    "RESPIRITORYSCORE           INT, " +
                    "NERVOUSSCORE            INT, " +
                    "CARDIOVASCULARSCORE         INT, " +
                    "LIVERSCORE            INT, " +
                    "COAGULATIONSCORE            INT, " +
                    "KIDNEYSCORE            INT, " +
                    "PRIMARY KEY (RECORDID)," +
                    "FOREIGN KEY(RECORDID) REFERENCES RECORD(ID))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void createCPAxTable(Connection c){

        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE CPAX " +
                    "(RECORDID           INTEGER , " +
                    "COUGH           INT, " +
                    "MOVINGINBED            INT, " +
                    "SUPINETOSITTING         INT, " +
                    "DYNAMICBALANCE            INT, " +
                    "STANDINGBALANCE            INT, " +
                    "SITTOSTAND            INT, " +
                    "TRANSFERBEDTOCHAIR            INT, " +
                    "STEPPING            INT, " +
                    "GRIPSTRENGTH            INT," +
                    "PRIMARY KEY (RECORDID)," +
                    "FOREIGN KEY(RECORDID) REFERENCES RECORD(ID))";;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void createMRCTable(Connection c){

        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE MRC " +
                    "(RECORDID           INTEGER, " +
                    "SHOULDERABDUCTIONRIGHT           INT, " +
                    "SHOULDERABDUCTIONLEFT           INT, " +
                    "ELBOWFLEXIONRIGHT           INT, " +
                    "ELBOWFLEXIONLEFT           INT, " +
                    "WRISTEXTENSIONRIGHT           INT, " +
                    "WRISTEXTENSIONLEFT           INT, " +
                    "HIPFLEXIONRIGHT           INT, " +
                    "HIPFLEXIONLEFT           INT, " +
                    "KNEEEXTENSIONRIGHT           INT, " +
                    "KNEEEXTENSIONLEFT           INT, " +
                    "ANKLEDORSIFLEXIONRIGHT           INT, " +
                    "ANKLEDORSIFLEXIONLEFT           INT, " +
                    "PRIMARY KEY (RECORDID)" +
                    "FOREIGN KEY(RECORDID) REFERENCES RECORD(ID))"; ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void createMMSTable(Connection c){

        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE MMS " +
                    "(RECORDID           INTEGER, " +
                    "MMS           TEXT, "  +
                    "PRIMARY KEY (RECORDID)" +
                    "FOREIGN KEY(RECORDID) REFERENCES RECORD(ID))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void InsertPatients(String fileName, List<Patient> patients){

        try {
            Connection c = getConnection("jdbc:sqlite:" + fileName);
            patients.forEach(patient -> InsertPatient(c, patient));
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void InsertPatient(Connection c, Patient patient){
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO PATIENT (" +
                    "HOSPNO, " +
                    "FIRSTNAME, " +
                    "LASTNAME, " +
                    "DATEOFBIRTH, " +
                    "AGE, " +
                    "SEX) " +
                    "\nVALUES ("
                    + patient.getHospitalNumber() + " ,"
                    + "\'" + patient.getFirstName() + "\'" + " ,"
                    + "\'" +  patient.getLastName() + "\'" + " ,"
                    + patient.getDateOfBirth() + " ,"
                    + patient.getAge() + ","
                    + "\'" +  patient.getSex() + "\'" +  ");";
            stmt.executeUpdate(sql);
            stmt.close();
            patient.getHospitalVisits().forEach(visit ->{
                InsertVisit(c, visit, patient.getHospitalNumber());
            });
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void InsertVisit(Connection c, Visit visit, String hospNo){
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO VISIT (" +
                    "POID, " +
                    "HOSPNO, " +
                    "DIAGNOSIS, " +
                    "PATIENTCATEGORY, " +
                    "HOSPITALADMITDATE, " +
                    "HOSPITALDISCHARGEDATE, " +
                    "ICUADMITDATE, " +
                    "ICUDISCHARGEDATE, " +
                    "ADMITTYPE, " +
                    "ADMITFROM, " +
                    "DEPENDENCYPREADMISSION, " +
                    "PASTMEDICALHISTORY, " +
                    "HISTORY)" +
                    "VALUES ("
                    + "\'" +  visit.getPOID() + "\'" +  " ,"
                    + hospNo + " ,"
                    + "\'" +  visit.getDiagnosis() + "\'" +  " ,"
                    + "\'" +  visit.getPatientCategory() + "\'" +  " ,"
                    + visit.getAdmitDateHos() + ","
                    + visit.getDischargeDateHos() + " ,"
                    + visit.getAdmitDateICU() + " ,"
                    + visit.getDischargeDateICU() + " ,"
                    + "\'" +  visit.getAdmitType() + "\'" +  " ,"
                    + "\'" +  visit.getAdmitFrom() + "\'" +  ","
                    + "\'" +  visit.getDependencyPreAdmit() + "\'" +  " ,"
                    + "\'" +  visit.getPastMedicalHistory() + "\'" +  " ,"
                    + "\'" +  visit.getHistory() + "\'" +  ")";
            stmt.executeUpdate(sql);

            ResultSet resultset = stmt.getGeneratedKeys();
            int key = resultset.getInt("last_insert_rowid()");

            stmt.close();


            visit.getRecords().forEach(record ->{
                InsertRecord(c, record, key);
            });
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void InsertRecord(Connection c, Record record, int visitId){
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO RECORD (" +
                    "DATE, " +
                    "VISITID, " +
                    "BREATHING, " +
                    "CIRCULATION, " +
                    "DURATIONOFSESSION, " +
                    "COMPREHENSIVEREHAB, " +
                    "FITNESSTOPARTICIPATE, " +
                    "DELERIUM, " +
                    "IPAT, " +
                    "FITFORPHYSIO, " +
                    "RASSLOW, " +
                    "RASSHIGH)" +
                    "VALUES ("
                    + record.getDate() + " ,"
                    + "\'" +  visitId + "\'" +  " ,"
                    + "\'" +  record.getBreathing() + "\'" +  " ,"
                    + "\'" +  record.getCirculation() + "\'" +  ","
                    + "\'" +  record.getDurationOfSession() + "\'" +  " ,"
                    + "\'" +  record.getComprehensiveRehab() + "\'" +  " ,"
                    + "\'" +  record.getFitnessToParticipate() + "\'" +  " ,"
                    + "\'" +  record.getDelirium() + "\'" +  " ,"
                    + "\'" +  record.getIpat() + "\'" +  ","
                    + "\'" +  record.getFitForPhysio() + "\'" +  " ,"
                    + record.getRassLow() + " ,"
                    + record.getRassHigh() + ")";
            stmt.executeUpdate(sql);
            ResultSet resultset = stmt.getGeneratedKeys();
            int key = resultset.getInt("last_insert_rowid()");
            stmt.close();
            InsertSOFA(c, record.getSofa(), key);
            InsertCPAX(c, record.getCpax(), key);
            InsertMRC(c, record.getMrc(), key);
            InsertMMS(c, record.getMms(), key);

        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public static void InsertSOFA(Connection c, SOFA sofa, int recordId){
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO SOFA (" +
                    "RECORDID," +
                    "RESPIRITORYSCORE, " +
                    "NERVOUSSCORE, " +
                    "CARDIOVASCULARSCORE, " +
                    "LIVERSCORE, " +
                    "COAGULATIONSCORE, " +
                    "KIDNEYSCORE) " +
                    "VALUES ("
                    + recordId + " ,"
                    + sofa.getRespiratoryScore() + " ,"
                    + sofa.getNervousScore() + " ,"
                    + sofa.getCardiovascularScore() + " ,"
                    + sofa.getLiverScore() + ","
                    + sofa.getCoagulationScore() + ","
                    + sofa.getKidneyScore() + ")";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void InsertCPAX(Connection c, CPAx cpax, int recordId){
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO CPAX (" +
                    "RECORDID," +
                    "COUGH, " +
                    "MOVINGINBED, " +
                    "SUPINETOSITTING, " +
                    "DYNAMICBALANCE, " +
                    "STANDINGBALANCE, " +
                    "SITTOSTAND, " +
                    "TRANSFERBEDTOCHAIR, " +
                    "STEPPING, " +
                    "GRIPSTRENGTH)" +
                    "VALUES ("
                    + recordId + " ,"
                    + cpax.getCough() + " ,"
                    + cpax.getMovingInBed() + " ,"
                    + cpax.getSupineToSitting() + " ,"
                    + cpax.getDynamicSitting() + ","
                    + cpax.getStandingBalance() + ","
                    + cpax.getSitToStand() + ","
                    + cpax.getTransferBedToChair() + ","
                    + cpax.getStandingBalance()  + ","
                    + cpax.getGripStrength() + ")";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void InsertMRC(Connection c, MRC mrc, int recordId){
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO MRC (" +
                    "RECORDID, " +
                    "SHOULDERABDUCTIONRIGHT, " +
                    "SHOULDERABDUCTIONLEFT, " +
                    "ELBOWFLEXIONRIGHT, " +
                    "ELBOWFLEXIONLEFT, " +
                    "WRISTEXTENSIONRIGHT, " +
                    "WRISTEXTENSIONLEFT, " +
                    "HIPFLEXIONRIGHT, " +
                    "HIPFLEXIONLEFT, " +
                    "KNEEEXTENSIONRIGHT, " +
                    "KNEEEXTENSIONLEFT, " +
                    "ANKLEDORSIFLEXIONRIGHT , " +
                    "ANKLEDORSIFLEXIONLEFT) " +
                    "VALUES ("
                    + recordId + " ,"
                    + mrc.getShoulderAbductionRight() + " ,"
                    + mrc.getShoulderAbductionLeft() + " ,"
                    + mrc.getElbowFlexionRight() + " ,"
                    + mrc.getElbowFlexionLeft() + ","
                    + mrc.getWristExtensionRight() + " ,"
                    + mrc.getWristExtensionLeft() + " ,"
                    + mrc.getHipFlexionRight() + " ,"
                    + mrc.getHipFlexionLeft() + ","
                    + mrc.getKneeExtensionRight() + " ,"
                    + mrc.getKneeExtensionLeft() + ","
                    + mrc.getAnkleDorsiflexionRight() + ","
                    + mrc.getAnkleDorsiflexionLeft() + ")";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void InsertMMS(Connection c, MMS mms, int recordId){
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO MMS (" +
                    "RECORDID, " +
                    "MMS) " +
                    "VALUES ("
                    + recordId + ", "
                    + mms.getMms() + ")";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
