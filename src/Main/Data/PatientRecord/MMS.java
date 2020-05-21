package Main.Data.PatientRecord;

public class MMS {

    private boolean completed;
    private String mms;

    public MMS(){

    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getMms() {
        if(mms == ""){
            return "-1";
        }
        return mms;
    }

    public void setMms(String mms) {
        this.mms = mms;
    }
}
