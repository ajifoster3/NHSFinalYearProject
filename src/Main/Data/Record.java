package Main.Data;

import Main.Cleansing.CleansingHelpers.LocalDateDeserializer;
import Main.Cleansing.CleansingHelpers.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.List;

public class Record {

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
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

    public Record(){

    }

    //region Accessors

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBreathing() {
        return breathing;
    }

    public void setBreathing(String breathing) {
        this.breathing = breathing;
    }

    public String getCirculation() {
        return circulation;
    }

    public void setCirculation(String circulation) {
        this.circulation = circulation;
    }

    public String getDurationOfSession() {
        return durationOfSession;
    }

    public void setDurationOfSession(String durationOfSession) {
        this.durationOfSession = durationOfSession;
    }

    public String getComprehensiveRehab() {
        return comprehensiveRehab;
    }

    public void setComprehensiveRehab(String comprehensiveRehab) {
        this.comprehensiveRehab = comprehensiveRehab;
    }

    public String getFitnessToParticipate() {
        return fitnessToParticipate;
    }

    public void setFitnessToParticipate(String fitnessToParticipate) {
        this.fitnessToParticipate = fitnessToParticipate;
    }

    public String getDelirium() {
        return delirium;
    }

    public void setDelirium(String delirium) {
        this.delirium = delirium;
    }

    public String getIpat() {
        return ipat;
    }

    public void setIpat(String ipat) {
        this.ipat = ipat;
    }

    public Boolean getFitForPhysio() {
        return fitForPhysio;
    }

    public void setFitForPhysio(Boolean fitForPhysio) {
        this.fitForPhysio = fitForPhysio;
    }

    public List<String> getPhysioInterventions() {
        return physioInterventions;
    }

    public void setPhysioInterventions(List<String> physioInterventions) {
        this.physioInterventions = physioInterventions;
    }

    public int getRassHigh() {
        return rassHigh;
    }

    public void setRassHigh(int rassHigh) {
        this.rassHigh = rassHigh;
    }

    public int getRassLow() {
        return rassLow;
    }

    public void setRassLow(int rassLow) {
        this.rassLow = rassLow;
    }

    public SOFA getSofa() {
        return sofa;
    }

    public void setSofa(SOFA sofa) {
        this.sofa = sofa;
    }

    public CPAx getCpax() {
        return cpax;
    }

    public void setCpax(CPAx cpax) {
        this.cpax = cpax;
    }

    public MRC getMrc() {
        return mrc;
    }

    public void setMrc(MRC mrc) {
        this.mrc = mrc;
    }

    public MMS getMms() {
        return mms;
    }

    public void setMms(MMS mms) {
        this.mms = mms;
    }

    //endregion

}
