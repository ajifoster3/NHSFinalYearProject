package Main.PatientRecord;

import java.util.Date;
import java.util.List;

public class Record {

    private Date date;
    private String breathing;
    private String circulation;
    private String durationOfSession;
    private String comprehensiveRehab;
    private String fitnessToParticipate;
    private String delirium;
    private String ipat;
    private Boolean fitForPhysio;
    private List<String> physioInterventions;
    private int rassHigh;
    private int rassLow;
    private SOFA sofa;
    private CPAx cpax;
    private MRC mrc;
    private MMS mms;


    public Date getDate() {
        return date;
    }

    public String getBreathing() {
        return breathing;
    }

    public String getCirculation() {
        return circulation;
    }

    public String getDurationOfSession() {
        return durationOfSession;
    }

    public String getComprehensiveRehab() {
        return comprehensiveRehab;
    }

    public String getFitnessToParticipate() {
        return fitnessToParticipate;
    }

    public String getDelirium() {
        return delirium;
    }

    public String getIpat() {
        return ipat;
    }

    public Boolean getFitForPhysio() {
        return fitForPhysio;
    }

    public List<String> getPhysioInterventions() {
        return physioInterventions;
    }

    public int getRassHigh() {
        return rassHigh;
    }

    public int getRassLow() {
        return rassLow;
    }

    public SOFA getSofa() {
        return sofa;
    }

    public CPAx getCpax() {
        return cpax;
    }

    public MRC getMrc() {
        return mrc;
    }

    public MMS getMms() {
        return mms;
    }
}
