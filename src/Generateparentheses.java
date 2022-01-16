import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Generateparentheses {
    public static Scanner sc=new Scanner(System.in);
    public static int n;
    public static ArrayList<Integer>list=new ArrayList<>();
    public static HashMap<String, Integer> map=new HashMap<String, Integer>();
    public static int result=0;
    public static String[] key;
    public static void main(String[] args) {
        n=sc.nextInt();
        map.putIfAbsent("(",n);
        map.putIfAbsent(")",n);
        key=new String[2*n+1];
        Solve(1);
        System.out.println(result);
    }
    public static boolean check(String i){
        if(map.get(i)==0){
            return false;
        }
        if(i==")" && map.get(")")<=map.get("(")){
            return false;
        }
        return true;
    }
    public static void Solve(int k){
        for(String i:map.keySet()){
            if(check(i)){
                key[k]=i;
                map.put(i,map.get(i)-1);
                if(k==2*n){
                    result++;
                }else{
                    Solve(k+1);
                }
                map.put(i,map.get(i)+1);
            }
        }
    }
}
