package Main.Data;

public enum PatientRecordEnum {

    hospitalNumber("Hospital Number specific to the patient"),
    firstName("First Name of the patient"),
    lastName("Last name of the patient"),
    dateOfBirth("Date of Birth of the patient"),
    age("Age of the patient"),
    sex("Sex of the patient"),
    POID("Unique POID code for the patient, used to keep track of the patient over multiple days"),
    diagnosis("Diagnosis for the patient i.e. Pneumonia"),
    patientCategory("Category of patient ailment i.e. Neurosurgery; General medicine, Elective surgery"),
    admitDateHos("Date of admission to hospital"),
    dischargeDateHos("Date of discharge from hospital"),
    admitDateICU("Date of admission to ICU"),
    dischargeDateICU("Date of discharge from ICU"),
    lengthOfStayHosp("Length of stay within the hospital"),
    lengthOfStayICU("Length of stay within ICU"),
    admitType("Reason for admission to ICU"),
    admitFrom("Department transferred from to ICU"),
    dependencyPreAdmit(""),
    pastMedicalHistory("Medical history of the patient"),
    history("Other History of patient"),
    outcome("Outcome of Hospital Visit"),
    date("Date of patient record"),
    breathing("Record of if the patient is on ventilation and if so what mode"),
    circulation("Record of if the patient is being medicated for Circulation"),
    durationOfSession("Duration of session for record"),
    comprehensiveRehab("Record of if the patient needs a comprehensive rehab assessment"),
    fitnessToParticipate("Assessment for fitness to participate in record taking"),
    delirium("Has the patient been delirious"),
    ipat("This measure is used to make a general assessment of the patient’s current psychological state. It is a short survey which patients can answers, which provides a score between 0 and 20. "),
    fitForPhysio("Assessment for fitness to participate in Physio"),
    physioInterventions("A record of activities taken in Physio Session"),
    rassHigh("The Richmond agitation-sedation scale (RASS) is used to monitor the level of a patient’s sedation whilst also evaluating any agitated behaviour. It runs on a scale between -5 and +4"),
    rassLow("The Richmond agitation-sedation scale (RASS) is used to monitor the level of a patient’s sedation whilst also evaluating any agitated behaviour. It runs on a scale between -5 and +4"),
    respiratoryScore("SOFA(Sequential organ failure assessment) Score for Respiratory function"),
    nervousScore("SOFA(Sequential organ failure assessment) Score for Nervous function"),
    cardiovascularScore("SOFA(Sequential organ failure assessment) Score for Cardiovascular function"),
    liverScore("SOFA(Sequential organ failure assessment) Score for Liver function"),
    coagulationScore("SOFA(Sequential organ failure assessment) Score for Blood coagulation function"),
    kidneyScore("SOFA(Sequential organ failure assessment) Score for Kidney function"),
    respiritoryFunction("CPAx(Chelsea critical care physical assessment tool)"),
    cough("CPAx(Chelsea critical care physical assessment tool)"),
    movingInBed("CPAx(Chelsea critical care physical assessment tool)"),
    supineToSitting("CPAx(Chelsea critical care physical assessment tool)"),
    dynamicSitting("CPAx(Chelsea critical care physical assessment tool)"),
    standingBalance("CPAx(Chelsea critical care physical assessment tool)"),
    sitToStand("CPAx(Chelsea critical care physical assessment tool)"),
    transferBedToChair("CPAx(Chelsea critical care physical assessment tool)"),
    stepping("CPAx(Chelsea critical care physical assessment tool)"),
    gripStrength("CPAx(Chelsea critical care physical assessment tool)"),
    shoulderAbductionRight("MRC(Medical research council scale)"),
    shoulderAbductionLeft("MRC(Medical research council scale)"),
    elbowFlexionRight("MRC(Medical research council scale)"),
    elbowFlexionLeft("MRC(Medical research council scale)"),
    wristExtensionRight("MRC(Medical research council scale)"),
    wristExtensionLeft("MRC(Medical research council scale)"),
    hipFlexionRight("MRC(Medical research council scale)"),
    hipFlexionLeft("MRC(Medical research council scale)"),
    kneeExtensionRight("MRC(Medical research council scale)"),
    kneeExtensionLeft("MRC(Medical research council scale)"),
    ankleDorsiflexionRight("MRC(Medical research council scale)"),
    ankleDorsiflexionLeft("MRC(Medical research council scale)"),
    completed("MMS – Manchester mobility score Completed"),
    mms("MMS (Manchester mobility score)");

    private String code;

    PatientRecordEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
