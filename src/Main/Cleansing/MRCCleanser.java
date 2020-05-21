package Main.Cleansing;


import Main.Cleansing.CleansingHelpers.ExcelReader;
import java.util.List;

class MRCCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<Integer> cleanseshoulderAbductionRight(String header) {
        List<String> shoulderAbductionRightList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(shoulderAbductionRightList);
    }

    protected List<Integer> cleanseshoulderAbductionLeft(String header){
        List<String> shoulderAbductionLeftList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(shoulderAbductionLeftList);
    }

    protected List<Integer> cleanseelbowFlexionRight(String header){
        List<String> elbowFlexionRightList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(elbowFlexionRightList);
    }

    protected List<Integer> cleanseelbowFlexionLeft(String header){
        List<String> elbowFlexionLeftList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(elbowFlexionLeftList);
    }

    protected List<Integer> cleansewristExtensionRight(String header){
        List<String> wristExtensionRightList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(wristExtensionRightList);
    }

    protected List<Integer> cleansewristExtensionLeft(String header){
        List<String> wristExtensionLeftList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(wristExtensionLeftList);
    }

    protected List<Integer> cleansehipFlexionRight(String header){
        List<String> hipFlexionRightList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(hipFlexionRightList);
    }

    protected List<Integer> cleansehipFlexionLeft(String header){
        List<String> hipFlexionLeftList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(hipFlexionLeftList);
    }

    protected List<Integer> cleansekneeExtensionRight(String header){
        List<String> kneeExtensionRightList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(kneeExtensionRightList);
    }

    protected List<Integer> cleansekneeExtensionLeft(String header){
        List<String> kneeExtensionLeftList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(kneeExtensionLeftList);
    }

    protected List<Integer> cleanseankleDorsiflexionRight(String header){
        List<String> ankleDorsiflexionRightList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(ankleDorsiflexionRightList);
    }

    protected List<Integer> cleanseankleDorsiflexionLeft(String header){
        List<String> ankleDorsiflexionLeftList = excelReader.ExcelColumnAsList(header);
        return cleanseMRC(ankleDorsiflexionLeftList);
    }

    private List<Integer> cleanseMRC(List<String> values){
        return IntegerParser.GetIntegers(values);
    }

}
