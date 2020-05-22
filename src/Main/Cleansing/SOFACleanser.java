package Main.Cleansing;


import Main.ExcelReader;

import java.util.Collections;
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

    protected List<Integer> cleansesofaTotal(String header){
        List<String> sofaTotalScoreList = excelReader.ExcelColumnAsList(header);
        Collections.replaceAll(sofaTotalScoreList, "", "-1");
        return cleanseSOFATotoal(sofaTotalScoreList);
    }

    private List<Integer> cleanseSOFA(List<String> values){
        List<Integer> mrcList = IntegerParser.GetIntegers(values);
        for (int i = 0; i < mrcList.size(); i++) {
            if(mrcList.get(i) < -1 || mrcList.get(i) > 4){
                mrcList.set(i, -1);
            }
        }
        return mrcList;
    }

    private List<Integer> cleanseSOFATotoal(List<String> values){
        return IntegerParser.GetIntegers(values);
    }

}
