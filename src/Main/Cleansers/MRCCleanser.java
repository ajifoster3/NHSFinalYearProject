package Main.Cleansers;

import Main.ExcelReader;

import java.util.LinkedList;
import java.util.List;

class MRCCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<Integer> cleanseshoulderAbductionRight(String header){
        List<String> shoulderAbductionRightList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedshoulderAbductionRightList = new LinkedList<>();
        shoulderAbductionRightList.forEach( value -> cleansedshoulderAbductionRightList.add(Integer.valueOf(value)) );
        return cleansedshoulderAbductionRightList;
    }

    protected List<Integer> cleanseshoulderAbductionLeft(String header){
        List<String> shoulderAbductionLeftList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedshoulderAbductionLeftList = new LinkedList<>();
        shoulderAbductionLeftList.forEach( value -> cleansedshoulderAbductionLeftList.add(Integer.valueOf(value)) );
        return cleansedshoulderAbductionLeftList;
    }

    protected List<Integer> cleanseelbowFlexionRight(String header){
        List<String> elbowFlexionRightList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedelbowFlexionRightList = new LinkedList<>();
        elbowFlexionRightList.forEach( value -> cleansedelbowFlexionRightList.add(Integer.valueOf(value)) );
        return cleansedelbowFlexionRightList;
    }

    protected List<Integer> cleanseelbowFlexionLeft(String header){
        List<String> elbowFlexionLeftList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedelbowFlexionLeftList = new LinkedList<>();
        elbowFlexionLeftList.forEach( value -> cleansedelbowFlexionLeftList.add(Integer.valueOf(value)) );
        return cleansedelbowFlexionLeftList;
    }

    protected List<Integer> cleansewristExtensionRight(String header){
        List<String> wristExtensionRightList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedwristExtensionRightList = new LinkedList<>();
        wristExtensionRightList.forEach( value -> cleansedwristExtensionRightList.add(Integer.valueOf(value)) );
        return cleansedwristExtensionRightList;
    }

    protected List<Integer> cleansewristExtensionLeft(String header){
        List<String> wristExtensionLeftList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedwristExtensionLeftList = new LinkedList<>();
        wristExtensionLeftList.forEach( value -> cleansedwristExtensionLeftList.add(Integer.valueOf(value)) );
        return cleansedwristExtensionLeftList;
    }

    protected List<Integer> cleansehipFlexionRight(String header){
        List<String> hipFlexionRightList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedhipFlexionRightList = new LinkedList<>();
        hipFlexionRightList.forEach( value -> cleansedhipFlexionRightList.add(Integer.valueOf(value)) );
        return cleansedhipFlexionRightList;
    }

    protected List<Integer> cleansehipFlexionLeft(String header){
        List<String> hipFlexionLeftList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedhipFlexionLeftList = new LinkedList<>();
        hipFlexionLeftList.forEach( value -> cleansedhipFlexionLeftList.add(Integer.valueOf(value)) );
        return cleansedhipFlexionLeftList;
    }

    protected List<Integer> cleansekneeExtensionRight(String header){
        List<String> kneeExtensionRightList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedkneeExtensionRightList = new LinkedList<>();
        kneeExtensionRightList.forEach( value -> cleansedkneeExtensionRightList.add(Integer.valueOf(value)) );
        return cleansedkneeExtensionRightList;
    }

    protected List<Integer> cleansekneeExtensionLeft(String header){
        List<String> kneeExtensionLeftList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedkneeExtensionLeftList = new LinkedList<>();
        kneeExtensionLeftList.forEach( value -> cleansedkneeExtensionLeftList.add(Integer.valueOf(value)) );
        return cleansedkneeExtensionLeftList;
    }

    protected List<Integer> cleanseankleDorsiflexionRight(String header){
        List<String> ankleDorsiflexionRightList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedankleDorsiflexionRightList = new LinkedList<>();
        ankleDorsiflexionRightList.forEach( value -> cleansedankleDorsiflexionRightList.add(Integer.valueOf(value)) );
        return cleansedankleDorsiflexionRightList;
    }

    protected List<Integer> cleanseankleDorsiflexionLeft(String header){
        List<String> ankleDorsiflexionLeftList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedankleDorsiflexionLeftList = new LinkedList<>();
        ankleDorsiflexionLeftList.forEach( value -> cleansedankleDorsiflexionLeftList.add(Integer.valueOf(value)) );
        return cleansedankleDorsiflexionLeftList;
    }

}
