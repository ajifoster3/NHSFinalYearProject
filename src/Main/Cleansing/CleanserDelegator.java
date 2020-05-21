package Main.Cleansing;

import Main.Data.RASS;
import java.time.LocalDate;
import java.util.List;

public class CleanserDelegator {

    private PatientCleanser patientCleanser;
    private VisitCleanser visitCleanser;
    private RecordCleanser recordCleanser;
    private CPAxCleanser cpaxCleanser;
    private MMSCleanser mmsCleanser;
    private MRCCleanser mrcCleanser;
    private SOFACleanser sofaCleanser;

    public CleanserDelegator(){
        patientCleanser = new PatientCleanser();
        visitCleanser = new VisitCleanser();
        recordCleanser = new RecordCleanser();
        cpaxCleanser = new CPAxCleanser();
        mmsCleanser = new MMSCleanser();
        mrcCleanser = new MRCCleanser();
        sofaCleanser = new SOFACleanser();
    }

    //region patientCleansers

    public List<String> cleansehospitalNumber(String header){
        return patientCleanser.cleansehospitalNumber(header);
    }

    public List<String> cleansefirstName(String header){
        return patientCleanser.cleansefirstName(header);
    }

    public List<String> cleanselastName(String header){
        return patientCleanser.cleanselastName(header);
    }

    public List<LocalDate> cleansedateOfBirth(String header){
        return patientCleanser.cleansedateOfBirth(header);
    }

    public List<Integer> cleanseage(String header){
        return patientCleanser.cleanseage(header);
    }

    public List<String> cleansesex(String header){
        return patientCleanser.cleansesex(header);
    }

    //endregion

    //region visitCleansers

    public List<String> cleansePOID(String header){
        return visitCleanser.cleansePOID(header);
    }

    public List<String> cleansediagnosis(String header){
        return visitCleanser.cleansediagnosis(header);
    }

    public List<String> cleansepatientCategory(String header){
        return visitCleanser.cleansepatientCategory(header);
    }

    public List<LocalDate> cleanseadmitDateHos(String header){
        return visitCleanser.cleanseadmitDateHos(header);
    }

    public List<LocalDate> cleansedischargeDateHos(String header){
        return visitCleanser.cleansedischargeDateHos(header);
    }

    public List<LocalDate> cleanseadmitDateICU(String header){
        return visitCleanser.cleanseadmitDateICU(header);
    }

    public List<LocalDate> cleansedischargeDateICU(String header){
        return visitCleanser.cleansedischargeDateICU(header);
    }

    public List<Integer> cleanselengthOfStayHosp(String header){
        return visitCleanser.cleanselengthOfStayHosp(header);
    }

    public List<Integer> cleanselengthOfStayICU(String header){
        return visitCleanser.cleanselengthOfStayICU(header);
    }

    public List<String> cleanseadmitType(String header){
        return visitCleanser.cleanseadmitType(header);
    }

    public List<String> cleanseadmitFrom(String header){
        return visitCleanser.cleanseadmitFrom(header);
    }

    public List<String> cleansedependencyPreAdmit(String header){
        return visitCleanser.cleansedependencyPreAdmit(header);
    }

    public List<String> cleansepastMedicalHistory(String header){
        return visitCleanser.cleansepastMedicalHistory(header);
    }

    public List<String> cleansehistory(String header){
        return visitCleanser.cleansehistory(header);
    }

    public List<Boolean> cleanseoutcome(String header){
        return visitCleanser.cleanseoutcome(header);
    }

    //endregion

    //region recordCleansers

    public List<LocalDate> cleansedate(String header){
        return recordCleanser.cleansedate(header);
    }

    public List<String> cleansebreathing(String header){
        return recordCleanser.cleansebreathing(header);
    }

    public List<String> cleansecirculation(String header){
        return recordCleanser.cleansecirculation(header);
    }

    public List<String> cleansedurationOfSession(String header){
        return recordCleanser.cleansedurationOfSession(header);
    }

    public List<String> cleansecomprehensiveRehab(String header){
        return recordCleanser.cleansecomprehensiveRehab(header);
    }

    public List<String> cleansefitnessToParticipate(String header){
        return recordCleanser.cleansefitnessToParticipate(header);
    }

    public List<String> cleansedelirium(String header){
        return recordCleanser.cleansedelirium(header);
    }

    public List<String> cleanseipat(String header){
        return recordCleanser.cleanseipat(header);
    }

    public List<Boolean> cleansefitForPhysio(String header){
        return recordCleanser.cleansefitForPhysio(header);
    }

    public List<RASS> cleanserass(String header){
        return recordCleanser.cleanserass(header);
    }

    //endregion

    //region cpaxCleansers

    public List<Integer> cleansecough(String header){
        return cpaxCleanser.cleansecough(header);
    }

    public List<Integer> cleansemovingInBed(String header) {
        return cpaxCleanser.cleansemovingInBed(header);
    }

    public List<Integer> cleansesupineToSitting(String header) {
        return cpaxCleanser.cleansesupineToSitting(header);
    }

    public List<Integer> cleansedynamicSitting(String header) {
        return cpaxCleanser.cleansedynamicSitting(header);
    }

    public List<Integer> cleansestandingBalance(String header) {
        return cpaxCleanser.cleansestandingBalance(header);
    }

    public List<Integer> cleansesitToStand(String header) {
        return cpaxCleanser.cleansesitToStand(header);
    }

    public List<Integer> cleansetransferBedToChair(String header) {
        return cpaxCleanser.cleansetransferBedToChair(header);
    }

    public List<Integer> cleansestepping(String header) {
        return cpaxCleanser.cleansestepping(header);
    }

    public List<Integer> cleansegripStrength(String header) {
        return cpaxCleanser.cleansegripStrength(header);
    }

    //endregion

    //region mmsCleansers

    public List<Boolean> cleansecompleted(String header){
        return mmsCleanser.cleansecompleted(header);
    }

    public List<String> cleansemms(String header){
        return mmsCleanser.cleansemms(header);
    }

    //endregion

    //region mrcCleansers

    public List<Integer> cleanseshoulderAbductionRight(String header){
        return mrcCleanser.cleanseshoulderAbductionRight(header);
    }

    public List<Integer> cleanseshoulderAbductionLeft(String header){
        return mrcCleanser.cleanseshoulderAbductionLeft(header);
    }

    public List<Integer> cleanseelbowFlexionRight(String header){
        return mrcCleanser.cleanseelbowFlexionRight(header);
    }

    public List<Integer> cleanseelbowFlexionLeft(String header){
        return mrcCleanser.cleanseelbowFlexionLeft(header);
    }

    public List<Integer> cleansewristExtensionRight(String header){
        return mrcCleanser.cleansewristExtensionRight(header);
    }

    public List<Integer> cleansewristExtensionLeft(String header){
        return mrcCleanser.cleansewristExtensionLeft(header);
    }

    public List<Integer> cleansehipFlexionRight(String header){
        return mrcCleanser.cleansehipFlexionRight(header);
    }

    public List<Integer> cleansehipFlexionLeft(String header){
        return mrcCleanser.cleansehipFlexionLeft(header);
    }

    public List<Integer> cleansekneeExtensionRight(String header){
        return mrcCleanser.cleansekneeExtensionRight(header);
    }

    public List<Integer> cleansekneeExtensionLeft(String header){
        return mrcCleanser.cleansekneeExtensionLeft(header);
    }

    public List<Integer> cleanseankleDorsiflexionRight(String header){
        return mrcCleanser.cleanseankleDorsiflexionRight(header);
    }

    public List<Integer> cleanseankleDorsiflexionLeft(String header){
        return mrcCleanser.cleanseankleDorsiflexionLeft(header);
    }

    //endregion

    //region sofaCleansers

    public List<Integer> cleanserespiratoryScore(String header){
        return sofaCleanser.cleanserespiratoryScore(header);
    }

    public List<Integer> cleansenervousScore(String header){
        return sofaCleanser.cleansenervousScore(header);
    }

    public List<Integer> cleansecardiovascularScore(String header){
        return sofaCleanser.cleansecardiovascularScore(header);
    }

    public List<Integer> cleanseliverScore(String header){
        return sofaCleanser.cleanseliverScore(header);
    }

    public List<Integer> cleansecoagulationScore(String header){
        return sofaCleanser.cleansecoagulationScore(header);
    }

    public List<Integer> cleansekidneyScore(String header){
        return sofaCleanser.cleansekidneyScore(header);
    }

    //endregion


}
