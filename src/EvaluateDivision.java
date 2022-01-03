import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    public HashMap<String, ArrayList<String>> pair = new HashMap<>();
    public HashMap<String, ArrayList<Double>> valuePair = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!pair.containsKey(equation.get(0))) {
                pair.put(equation.get(0), new ArrayList<>());
                valuePair.put(equation.get(0), new ArrayList<>());
            }
            if (!pair.containsKey(equation.get(1))) {
                pair.put(equation.get(1), new ArrayList<>());
                valuePair.put(equation.get(1), new ArrayList<>());
            }
            pair.get(equation.get(0)).add(equation.get(1));
            pair.get(equation.get(1)).add(equation.get(0));
            valuePair.get(equation.get(0)).add(values[i]);
            valuePair.get(equation.get(1)).add(1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String>query = queries.get(i);
            double tmp=dfs(query.get(i),query.get(i),new HashSet<>(),1.0);
            if(tmp!=0){
                result[i]=tmp;
            }else{
                result[i]=-1.0;
            }
        }
        return result;
    }

    public double dfs(String first, String last, HashSet<String> set, double value) {
        if(set.contains(first)) return 0.0;
        if(!pair.containsKey(first)||!pair.containsKey(last)) return 0.0;
        ArrayList<String> strList=pair.get(first);
        ArrayList<Double> valueList=valuePair.get(first);
        double tmp=0.0;
        for(int i=0;i<strList.size();i++){
            tmp=dfs(strList.get(i),last,set,value*valueList.get(i));
            if(tmp!=0){
                break;
            }
        }
        return tmp;
    }
}
