package Main.Cleansers;


import Main.ExcelReader;

import java.util.List;

class SOFACleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<Integer> cleanserespiratoryScore(String header){
        List<String> respiratoryScoreList = excelReader.ExcelColumnAsList(header);
        return cleanseSOFA(respiratoryScoreList);
    }

    protected List<Integer> cleansenervousScore(String header){
        List<String> nervousScoreList = excelReader.ExcelColumnAsList(header);
        return cleanseSOFA(nervousScoreList);
    }

    protected List<Integer> cleansecardiovascularScore(String header){
        List<String> cardiovascularScoreList = excelReader.ExcelColumnAsList(header);
        return cleanseSOFA(cardiovascularScoreList);
    }

    protected List<Integer> cleanseliverScore(String header){
        List<String> liverScoreList = excelReader.ExcelColumnAsList(header);
        return cleanseSOFA(liverScoreList);
    }

    protected List<Integer> cleansecoagulationScore(String header){
        List<String> coagulationScoreList = excelReader.ExcelColumnAsList(header);
        return cleanseSOFA(coagulationScoreList);
    }

    protected List<Integer> cleansekidneyScore(String header){
        List<String> kidneyScoreList = excelReader.ExcelColumnAsList(header);
        return cleanseSOFA(kidneyScoreList);
    }

    private List<Integer> cleanseSOFA(List<String> values){
        return IntegerParser.GetIntegers(values);
    }

}
