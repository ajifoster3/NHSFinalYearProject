package Main.Cleansers;

import Main.ExcelReader;

import java.util.List;

public class MRCCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    public List<String> cleanseshoulderAbductionRight(String header){
        List<String> shoulderAbductionRightList = excelReader.ExcelColumnAsList(header);
        return shoulderAbductionRightList;
    }

    public List<String> cleanseshoulderAbductionLeft(String header){
        List<String> shoulderAbductionLeftList = excelReader.ExcelColumnAsList(header);
        return shoulderAbductionLeftList;
    }

    public List<String> cleanseelbowFlexionRight(String header){
        List<String> elbowFlexionRightList = excelReader.ExcelColumnAsList(header);
        return elbowFlexionRightList;
    }

    public List<String> cleanseelbowFlexionLeft(String header){
        List<String> elbowFlexionLeftList = excelReader.ExcelColumnAsList(header);
        return elbowFlexionLeftList;
    }

    public List<String> cleansewristExtensionRight(String header){
        List<String> wristExtensionRightList = excelReader.ExcelColumnAsList(header);
        return wristExtensionRightList;
    }

    public List<String> cleansewristExtensionLeft(String header){
        List<String> wristExtensionLeftList = excelReader.ExcelColumnAsList(header);
        return wristExtensionLeftList;
    }

    public List<String> cleansehipFlexionRight(String header){
        List<String> hipFlexionRightList = excelReader.ExcelColumnAsList(header);
        return hipFlexionRightList;
    }

    public List<String> cleansehipFlexionLeft(String header){
        List<String> hipFlexionLeftList = excelReader.ExcelColumnAsList(header);
        return hipFlexionLeftList;
    }

    public List<String> cleansekneeExtensionRight(String header){
        List<String> kneeExtensionRightList = excelReader.ExcelColumnAsList(header);
        return kneeExtensionRightList;
    }

    public List<String> cleansekneeExtensionLeft(String header){
        List<String> kneeExtensionLeftList = excelReader.ExcelColumnAsList(header);
        return kneeExtensionLeftList;
    }

    public List<String> cleanseankleDorsiflexionRight(String header){
        List<String> ankleDorsiflexionRightList = excelReader.ExcelColumnAsList(header);
        return ankleDorsiflexionRightList;
    }

    public List<String> cleanseankleDorsiflexionLeft(String header){
        List<String> ankleDorsiflexionLeftList = excelReader.ExcelColumnAsList(header);
        return ankleDorsiflexionLeftList;
    }

}
