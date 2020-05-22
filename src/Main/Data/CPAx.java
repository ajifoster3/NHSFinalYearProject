package Main.Data;

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
    private int total;

    public CPAx(){

    }

    public int getCough() {
        if(isValid()) return cough;
        return -1;
    }

    public void setCough(int cough) {
        this.cough = cough;
    }

    public int getMovingInBed() {
        if(isValid()) return movingInBed;
        return -1;
    }

    public void setMovingInBed(int movingInBed) {
        this.movingInBed = movingInBed;
    }

    public int getSupineToSitting() {
        if(isValid()) return supineToSitting;
        return -1;
    }

    public void setSupineToSitting(int supineToSitting) {
        this.supineToSitting = supineToSitting;
    }

    public int getDynamicSitting() {
        if(isValid()) return dynamicSitting;
        return -1;
    }

    public void setDynamicSitting(int dynamicSitting) {
        this.dynamicSitting = dynamicSitting;
    }

    public int getStandingBalance() {
        if(isValid()) return standingBalance;
        return -1;
    }

    public void setStandingBalance(int standingBalance) {
        this.standingBalance = standingBalance;
    }

    public int getSitToStand() {
        if(isValid()) return sitToStand;
        return -1;
    }

    public void setSitToStand(int sitToStand) {
        this.sitToStand = sitToStand;
    }

    public int getTransferBedToChair() {
        if(isValid()) return transferBedToChair;
        return -1;
    }

    public void setTransferBedToChair(int transferBedToChair) {
        this.transferBedToChair = transferBedToChair;
    }

    public int getStepping() {
        if(isValid()) return stepping;
        return -1;
    }

    public void setStepping(int stepping) {
        this.stepping = stepping;
    }

    public int getGripStrength() {
        if(isValid()) return gripStrength;
        return -1;
    }

    public void setGripStrength(int gripStrength) {
        this.gripStrength = gripStrength;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private boolean isValid(){
        return !(getTotal() == -1);
    }

}