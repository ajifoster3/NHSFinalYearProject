package Main.Data.PatientRecord;

public class CPAx {

    private int cough;
    private int movingInBed;
    private int supineToSitting;
    private int dynamicSitting;
    private int standingBalance;
    private int sitToStand;
    private int transferBedToChair;
    private int stepping;
    private int gripStrength;

    public CPAx(){

    }

    public int getCough() {
        return cough;
    }

    public void setCough(int cough) {
        this.cough = cough;
    }

    public int getMovingInBed() {
        return movingInBed;
    }

    public void setMovingInBed(int movingInBed) {
        this.movingInBed = movingInBed;
    }

    public int getSupineToSitting() {
        return supineToSitting;
    }

    public void setSupineToSitting(int supineToSitting) {
        this.supineToSitting = supineToSitting;
    }

    public int getDynamicSitting() {
        return dynamicSitting;
    }

    public void setDynamicSitting(int dynamicSitting) {
        this.dynamicSitting = dynamicSitting;
    }

    public int getStandingBalance() {
        return standingBalance;
    }

    public void setStandingBalance(int standingBalance) {
        this.standingBalance = standingBalance;
    }

    public int getSitToStand() {
        return sitToStand;
    }

    public void setSitToStand(int sitToStand) {
        this.sitToStand = sitToStand;
    }

    public int getTransferBedToChair() {
        return transferBedToChair;
    }

    public void setTransferBedToChair(int transferBedToChair) {
        this.transferBedToChair = transferBedToChair;
    }

    public int getStepping() {
        return stepping;
    }

    public void setStepping(int stepping) {
        this.stepping = stepping;
    }

    public int getGripStrength() {
        return gripStrength;
    }

    public void setGripStrength(int gripStrength) {
        this.gripStrength = gripStrength;
    }
}