import java.util.HashMap;
import java.util.Scanner;

public class MinimumWindowSubstring {
    public static String t;
    public static String s;
    public static int start, end;
    public static int right,left;
    public static int sacrifice;
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<Character, Integer> mapt=new HashMap<>();
    public static HashMap<Character, Integer> maps=new HashMap<>();

    public static void main(String[] args) {
        t = sc.nextLine();
        s = sc.nextLine();
        HashMap<Character,Integer>map=new HashMap<>();
        start = 0;
        end = 1000000;
        right=0;
        left=0;
        sacrifice = 0;
        for (int i = 0; i < t.length(); i++) {
            mapt.putIfAbsent(t.charAt(i), 0);
            mapt.put(t.charAt(i), mapt.get(t.charAt(i)) + 1);
//            System.out.println("t xet i"+i+" co "+t.charAt(i)+ " co "+mapt.get(t.charAt(i)));
        }
        for(int right=0;right<s.length();right++) {
//            System.out.println("tai right "+right+ " xet "+s.charAt(right));
            maps.putIfAbsent(s.charAt(right), 0);
            maps.put(s.charAt(right), maps.get(s.charAt(right)) + 1);
            if (mapt.containsKey(s.charAt(right)) && mapt.get(s.charAt(right)) == maps.get(s.charAt(right))) {
                sacrifice++;
//                System.out.println("sacrifu"+sacrifice);
            }
            if (sacrifice == mapt.size()) {
//                System.out.println("bang");
                while (!mapt.containsKey(s.charAt(left)) || mapt.get(s.charAt(left)) < maps.get(s.charAt(left))) {
//                    System.out.println("rut gon"+ s.charAt(left));
                    maps.put(s.charAt(left), maps.get(s.charAt(left)) - 1);
                    left++;
                }
                if(right-left+1<end-start+1){
                    end=right;
                    start=left;
                }
            }
        }
        if(end-start+1>s.length()){
            System.out.println("khong ton tai");
        }
        System.out.println("start " + start + " finish " + end + " shortest " + (end-start+1));
    }
}
//    abca
//            adcfebeceabebadfcdfcbfcbead