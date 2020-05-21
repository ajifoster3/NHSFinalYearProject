package Main.Data.PatientRecord;

public class MRC {

    private int shoulderAbductionRight;
    private int shoulderAbductionLeft;
    private int elbowFlexionRight;
    private int elbowFlexionLeft;
    private int wristExtensionRight;
    private int wristExtensionLeft;
    private int hipFlexionRight;
    private int hipFlexionLeft;
    private int kneeExtensionRight;
    private int kneeExtensionLeft;
    private int ankleDorsiflexionRight;
    private int ankleDorsiflexionLeft;
    private int total;

    public MRC(){

    }

    public int getShoulderAbductionRight() {
        if(isValid()) return shoulderAbductionRight;
        return -1;
    }

    public void setShoulderAbductionRight(int shoulderAbductionRight) {
        this.shoulderAbductionRight = shoulderAbductionRight;
    }

    public int getShoulderAbductionLeft() {
        if(isValid()) return shoulderAbductionLeft;
        return -1;
    }

    public void setShoulderAbductionLeft(int shoulderAbductionLeft) {
        this.shoulderAbductionLeft = shoulderAbductionLeft;
    }

    public int getElbowFlexionRight() {
        if(isValid()) return elbowFlexionRight;
        return -1;
    }

    public void setElbowFlexionRight(int elbowFlexionRight) {
        this.elbowFlexionRight = elbowFlexionRight;
    }

    public int getElbowFlexionLeft() {
        if(isValid()) return elbowFlexionLeft;
        return -1;
    }

    public void setElbowFlexionLeft(int elbowFlexionLeft) {
        this.elbowFlexionLeft = elbowFlexionLeft;
    }

    public int getWristExtensionRight() {
        if(isValid()) return wristExtensionRight;
        return -1;
    }

    public void setWristExtensionRight(int wristExtensionRight) {
        this.wristExtensionRight = wristExtensionRight;
    }

    public int getWristExtensionLeft() {
        if(isValid()) return wristExtensionLeft;
        return -1;
    }

    public void setWristExtensionLeft(int wristExtensionLeft) {
        this.wristExtensionLeft = wristExtensionLeft;
    }

    public int getHipFlexionRight() {
        if(isValid()) return hipFlexionRight;
        return -1;
    }

    public void setHipFlexionRight(int hipFlexionRight) {
        this.hipFlexionRight = hipFlexionRight;
    }

    public int getHipFlexionLeft() {
        if(isValid()) return hipFlexionLeft;
        return -1;
    }

    public void setHipFlexionLeft(int hipFlexionLeft) {
        this.hipFlexionLeft = hipFlexionLeft;
    }

    public int getKneeExtensionRight() {
        if(isValid()) return kneeExtensionRight;
        return -1;
    }

    public void setKneeExtensionRight(int kneeExtensionRight) {
        this.kneeExtensionRight = kneeExtensionRight;
    }

    public int getKneeExtensionLeft() {
        if(isValid()) return kneeExtensionLeft;
        return -1;
    }

    public void setKneeExtensionLeft(int kneeExtensionLeft) {
        this.kneeExtensionLeft = kneeExtensionLeft;
    }

    public int getAnkleDorsiflexionRight() {
        if(isValid()) return ankleDorsiflexionRight;
        return -1;
    }

    public void setAnkleDorsiflexionRight(int ankleDorsiflexionRight) {
        this.ankleDorsiflexionRight = ankleDorsiflexionRight;
    }

    public int getAnkleDorsiflexionLeft() {
        if(isValid()) return ankleDorsiflexionLeft;
        return -1;
    }

    public void setAnkleDorsiflexionLeft(int ankleDorsiflexionLeft) {
        this.ankleDorsiflexionLeft = ankleDorsiflexionLeft;
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
