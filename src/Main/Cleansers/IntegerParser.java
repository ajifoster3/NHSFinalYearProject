package Main.Cleansers;

import java.util.LinkedList;
import java.util.List;

public class IntegerParser {

    protected static List<Integer> GetIntegers(List<String> values){
        List<Integer> integerValues = new LinkedList<>();
        values.forEach(value -> {
            value = value.trim().replaceAll("[^\\.0123456789]","");
            if(!value.isEmpty()){
                integerValues.add((int) Double.parseDouble(value));
            }else{
                integerValues.add(-1);
            }
        });
        return integerValues;
    }

}
