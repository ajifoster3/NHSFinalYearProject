package Main.Building.BuildingHelper;

import Main.Cleansing.CleansingHelpers.RASSHelper;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface class for accessing CleanserDelegator
 */
public interface CleanserDelagatorService {

    List<String> cleansehospitalNumber(String header);

    List<String> cleansefirstName(String header);

    List<String> cleanselastName(String header);

    List<LocalDate> cleansedateOfBirth(String header);

    List<Integer> cleanseage(String header);

    List<String> cleansesex(String header);

    //endregion

    //region visitCleansers

    List<String> cleansePOID(String header);

    List<String> cleansediagnosis(String header);

    List<String> cleansepatientCategory(String header);

    List<LocalDate> cleanseadmitDateHos(String header);

    List<LocalDate> cleansedischargeDateHos(String header);

    List<LocalDate> cleanseadmitDateICU(String header);

    List<LocalDate> cleansedischargeDateICU(String header);

    List<Integer> cleanselengthOfStayHosp(String header);

    List<Integer> cleanselengthOfStayICU(String header);

    List<String> cleanseadmitType(String header);

    List<String> cleanseadmitFrom(String header);

    List<String> cleansedependencyPreAdmit(String header);

    List<String> cleansepastMedicalHistory(String header);

    List<String> cleansehistory(String header);

    List<Boolean> cleanseoutcome(String header);

    //endregion

    //region recordCleansers

    List<LocalDate> cleansedate(String header);

    List<String> cleansebreathing(String header);

    List<String> cleansecirculation(String header);

    List<String> cleansedurationOfSession(String header);

    List<String> cleansecomprehensiveRehab(String header);

    List<String> cleansefitnessToParticipate(String header);

    List<String> cleansedelirium(String header);

    List<String> cleanseipat(String header);

    List<Boolean> cleansefitForPhysio(String header);

    List<RASSHelper> cleanserass(String header);

    //endregion

    //region cpaxCleansers

    List<Integer> cleanserespiritoryFunction(String header);

    List<Integer> cleansecough(String header);

    List<Integer> cleansemovingInBed(String header);

    List<Integer> cleansesupineToSitting(String header);

    List<Integer> cleansedynamicSitting(String header);

    List<Integer> cleansestandingBalance(String header);

    List<Integer> cleansesitToStand(String header);

    List<Integer> cleansetransferBedToChair(String header);

    List<Integer> cleansestepping(String header);

    List<Integer> cleansegripStrength(String header);

    List<Integer> cleansecpaxTotal(String header);

    //endregion

    //region mmsCleansers

    List<Boolean> cleansecompleted(String header);

    List<String> cleansemms(String header);

    //endregion

    //region mrcCleansers

    List<Integer> cleanseshoulderAbductionRight(String header);

    List<Integer> cleanseshoulderAbductionLeft(String header);

    List<Integer> cleanseelbowFlexionRight(String header);

    List<Integer> cleanseelbowFlexionLeft(String header);

    List<Integer> cleansewristExtensionRight(String header);

    List<Integer> cleansewristExtensionLeft(String header);

    List<Integer> cleansehipFlexionRight(String header);

    List<Integer> cleansehipFlexionLeft(String header);

    List<Integer> cleansekneeExtensionRight(String header);

    List<Integer> cleansekneeExtensionLeft(String header);

    List<Integer> cleanseankleDorsiflexionRight(String header);

    List<Integer> cleanseankleDorsiflexionLeft(String header);

    List<Integer> cleansemrcTotal(String header);

    //endregion

    //region sofaCleansers

    List<Integer> cleanserespiratoryScore(String header);

    List<Integer> cleansenervousScore(String header);

    List<Integer> cleansecardiovascularScore(String header);

    List<Integer> cleanseliverScore(String header);

    List<Integer> cleansecoagulationScore(String header);

    List<Integer> cleansekidneyScore(String header);

    List<Integer> cleansesofaTotal(String header);

}
