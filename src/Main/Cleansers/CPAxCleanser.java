package Main.Cleansers;

import Main.ExcelReader;

import java.util.LinkedList;
import java.util.List;

class CPAxCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<Integer> cleansecough(String header){
        List<String> coughList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedcoughList = new LinkedList<>();
        coughList.forEach( value -> cleansedcoughList.add(Integer.valueOf(value)) );
        return cleansedcoughList;
    }

    protected List<Integer> cleansemovingInBed(String header) {
        List<String> movingInBedList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedmovingInBedList = new LinkedList<>();
        movingInBedList.forEach( value -> cleansedmovingInBedList.add(Integer.valueOf(value)) );
        return cleansedmovingInBedList;
    }

    protected List<Integer> cleansesupineToSitting(String header) {
        List<String> supineToSittingList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedsupineToSittingList = new LinkedList<>();
        supineToSittingList.forEach( value -> cleansedsupineToSittingList.add(Integer.valueOf(value)) );
        return cleansedsupineToSittingList;
    }

    protected List<Integer> cleansedynamicSitting(String header) {
        List<String> dynamicSittingList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleanseddynamicSittingList = new LinkedList<>();
        dynamicSittingList.forEach( value -> cleanseddynamicSittingList.add(Integer.valueOf(value)) );
        return cleanseddynamicSittingList;
    }

    protected List<Integer> cleansestandingBalance(String header) {
        List<String> standingBalanceList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedstandingBalanceList = new LinkedList<>();
        standingBalanceList.forEach( value -> cleansedstandingBalanceList.add(Integer.valueOf(value)) );
        return cleansedstandingBalanceList;
    }

    protected List<Integer> cleansesitToStand(String header) {
        List<String> sitToStandList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedsitToStandList = new LinkedList<>();
        sitToStandList.forEach( value -> cleansedsitToStandList.add(Integer.valueOf(value)) );
        return cleansedsitToStandList;
    }

    protected List<Integer> cleansetransferBedToChair(String header) {
        List<String> transferBedToChairList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedtransferBedToChairList = new LinkedList<>();
        transferBedToChairList.forEach( value -> cleansedtransferBedToChairList.add(Integer.valueOf(value)) );
        return cleansedtransferBedToChairList;
    }

    protected List<Integer> cleansestepping(String header) {
        List<String> steppingList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedsteppingList = new LinkedList<>();
        steppingList.forEach( value -> cleansedsteppingList.add(Integer.valueOf(value)) );
        return cleansedsteppingList;
    }

    protected List<Integer> cleansegripStrength(String header) {
        List<String> gripStrengthList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedgripStrengthList = new LinkedList<>();
        gripStrengthList.forEach( value -> cleansedgripStrengthList.add(Integer.valueOf(value)) );
        return cleansedgripStrengthList;
    }

}
