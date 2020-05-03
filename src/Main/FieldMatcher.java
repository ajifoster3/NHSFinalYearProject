package Main;

import Main.Cleansers.CleanserDelegator;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FieldMatcher {

    private static final Logger LOGGER = Logger.getLogger(FieldMatcherController.class.getName());

    private List<String> dataField;
    private List<String> excelField;
    private List<List<Object>> dataList = new LinkedList<>();

    private  CleanserDelegator cleanserDelegator = new CleanserDelegator();

    FieldMatcher(List<String> dataField,List<String> excelField){
        this.dataField = dataField;
        this.excelField = excelField;
    }

    public void MatchHeaders(){
        var cArg = new Class[1];
        cArg[0] = String.class;
        for (String item : this.dataField){
            try{
                dataList.add((List<Object>)cleanserDelegator.getClass().getMethod("cleanse" + item, cArg).invoke(cleanserDelegator, excelField.get(this.dataField.indexOf(item))));
            }catch (Exception ex){
                LOGGER.log(Level.SEVERE, ex.toString(), ex);
            }
        }
    }

}
