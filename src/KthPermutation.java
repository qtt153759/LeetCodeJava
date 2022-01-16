import java.util.ArrayList;
import java.util.Scanner;

public class KthPermutation {
    public  static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int k=sc.nextInt();
        int position=0;
        int []fact =new int[n+1];
        ArrayList<Integer>res=new ArrayList<>();
        ArrayList<Integer>val=new ArrayList<>();
        fact[0]=1;
        k=k-1;
        for(int i=1;i<=n;i++){
            fact[i]=i*fact[i-1];
            val.add(i);
        }
        while(n>0){
            int range=fact[n]/n;
            position=k/range;
            res.add(val.remove(position));
            n=n-1;
            k=k%range;
        }
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
