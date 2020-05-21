package Main.Data.PatientRecord;

public class SOFA {

    private int respiratoryScore;
    private int nervousScore;
    private int cardiovascularScore;
    private int liverScore;
    private int coagulationScore;
    private int kidneyScore;
    private int total;

    public SOFA(){

    }

    public int getRespiratoryScore() {
        if(isValid()) return respiratoryScore;
        return -1;
    }

    public void setRespiratoryScore(int respiratoryScore) {
        this.respiratoryScore = respiratoryScore;
    }

    public int getNervousScore() {
        if(isValid()) return nervousScore;
        return -1;
    }

    public void setNervousScore(int nervousScore) {
        this.nervousScore = nervousScore;
    }

    public int getCardiovascularScore() {
        if(isValid()) return cardiovascularScore;
        return -1;
    }

    public void setCardiovascularScore(int cardiovascularScore) {
        this.cardiovascularScore = cardiovascularScore;
    }

    public int getLiverScore() {
        if(isValid()) return liverScore;
        return -1;
    }

    public void setLiverScore(int liverScore) {
        this.liverScore = liverScore;
    }

    public int getCoagulationScore() {
        if(isValid()) return coagulationScore;
        return -1;
    }

    public void setCoagulationScore(int coagulationScore) {
        this.coagulationScore = coagulationScore;
    }

    public int getKidneyScore() {
        if(isValid()) return kidneyScore;
        return -1;
    }

    public void setKidneyScore(int kidneyScore) {
        this.kidneyScore = kidneyScore;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private boolean isValid(){
        return !(total == -1);
    }
}
