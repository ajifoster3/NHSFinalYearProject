package Main.Cleansing;

import Main.ExcelReader;

import java.util.Collections;
import java.util.List;

class CPAxCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();


    protected List<Integer> cleanserespiritoryFunction(String header){
        List<String> respiritoryFunctionList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(respiritoryFunctionList);
    }

    protected List<Integer> cleansecough(String header){
        List<String> coughList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(coughList);
    }

    protected List<Integer> cleansemovingInBed(String header) {
        List<String> movingInBedList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(movingInBedList);
    }

    protected List<Integer> cleansesupineToSitting(String header) {
        List<String> supineToSittingList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(supineToSittingList);
    }

    protected List<Integer> cleansedynamicSitting(String header) {
        List<String> dynamicSittingList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(dynamicSittingList);
    }

    protected List<Integer> cleansestandingBalance(String header) {
        List<String> standingBalanceList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(standingBalanceList);
    }

    protected List<Integer> cleansesitToStand(String header) {
        List<String> sitToStandList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(sitToStandList);
    }

    protected List<Integer> cleansetransferBedToChair(String header) {
        List<String> transferBedToChairList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(transferBedToChairList);
    }

    protected List<Integer> cleansestepping(String header) {
        List<String> steppingList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(steppingList);
    }

    protected List<Integer> cleansegripStrength(String header) {
        List<String> gripStrengthList = excelReader.ExcelColumnAsList(header);
        return cleanseCPAX(gripStrengthList);
    }

    protected List<Integer> cleansecpaxTotal(String header) {
        List<String> cpaxTotalList = excelReader.ExcelColumnAsList(header);
        Collections.replaceAll(cpaxTotalList, "", "-1");
        return cleanseCPAXTotal(cpaxTotalList);
    }

    private List<Integer> cleanseCPAX(List<String> values){
        List<Integer> cpaxList = IntegerParser.GetIntegers(values);
        for (int i = 0; i < cpaxList.size(); i++) {
            if(cpaxList.get(i) < -1 || cpaxList.get(i) > 5){
                cpaxList.set(i, -1);
            }
        }
        return cpaxList;
    }

    private List<Integer> cleanseCPAXTotal(List<String> values){
        return IntegerParser.GetIntegers(values);
    }

}
