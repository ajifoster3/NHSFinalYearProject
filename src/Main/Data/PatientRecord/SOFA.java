package Main.Data.PatientRecord;

public class SOFA {

    private int respiratoryScore;
    private int nervousScore;
    private int cardiovascularScore;
    private int liverScore;
    private int coagulationScore;
    private int kidneyScore;

    public SOFA(){

    }

    public int getRespiratoryScore() {
        return respiratoryScore;
    }

    public void setRespiratoryScore(int respiratoryScore) {
        this.respiratoryScore = respiratoryScore;
    }

    public int getNervousScore() {
        return nervousScore;
    }

    public void setNervousScore(int nervousScore) {
        this.nervousScore = nervousScore;
    }

    public int getCardiovascularScore() {
        return cardiovascularScore;
    }

    public void setCardiovascularScore(int cardiovascularScore) {
        this.cardiovascularScore = cardiovascularScore;
    }

    public int getLiverScore() {
        return liverScore;
    }

    public void setLiverScore(int liverScore) {
        this.liverScore = liverScore;
    }

    public int getCoagulationScore() {
        return coagulationScore;
    }

    public void setCoagulationScore(int coagulationScore) {
        this.coagulationScore = coagulationScore;
    }

    public int getKidneyScore() {
        return kidneyScore;
    }

    public void setKidneyScore(int kidneyScore) {
        this.kidneyScore = kidneyScore;
    }
}
