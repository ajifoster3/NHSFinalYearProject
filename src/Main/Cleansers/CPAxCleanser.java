package Main.Cleansers;

import Main.ExcelReader;

import java.util.List;

public class CPAxCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    public List<String> cleansecough(String header){
        List<String> coughList = excelReader.ExcelColumnAsList(header);
        return coughList;
    }

    public List<String> cleansemovingInBed(String header) {
        List<String> movingInBedList = excelReader.ExcelColumnAsList(header);
        return movingInBedList;
    }

    public List<String> cleansesupineToSitting(String header) {
        List<String> supineToSittingList = excelReader.ExcelColumnAsList(header);
        return supineToSittingList;
    }

    public List<String> cleansedynamicSitting(String header) {
        List<String> dynamicSittingList = excelReader.ExcelColumnAsList(header);
        return dynamicSittingList;
    }

    public List<String> cleansestandingBalance(String header) {
        List<String> standingBalanceList = excelReader.ExcelColumnAsList(header);
        return standingBalanceList;
    }

    public List<String> cleansesitToStand(String header) {
        List<String> sitToStandList = excelReader.ExcelColumnAsList(header);
        return sitToStandList;
    }

    public List<String> cleansetransferBedToChair(String header) {
        List<String> transferBedToChairList = excelReader.ExcelColumnAsList(header);
        return transferBedToChairList;
    }

    public List<String> cleansestepping(String header) {
        List<String> steppingList = excelReader.ExcelColumnAsList(header);
        return steppingList;
    }

    public List<String> cleansegripStrength(String header) {
        List<String> gripStrengthList = excelReader.ExcelColumnAsList(header);
        return gripStrengthList;
    }

}
