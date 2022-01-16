import java.util.Scanner;

public class GasStation {
    public static Scanner sc=new Scanner(System.in);
    public static int n,started;
    public static int []gas;
    public static int []cost;
    public static int []start;
    public static int []remain;
    public static void main(String[] args) {
        n=sc.nextInt();
        gas=new int [n+1];
        cost=new int [n+1];
        start=new int [n+1];
        remain=new int [n+1];
        for(int i=0;i<n;i++){
            gas[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            cost[i]=sc.nextInt();
        }
        remain[0]=gas[0]-cost[0];
        started=0;
        System.out.println("tai "+0+" remain "+remain[0]);

        for(int i=1;i<2*n;i++){
            int j=i%n;
            if(remain[(i-1)%n]<0){
                remain[j]=gas[j]-cost[j];
                started=0;
            }else{
                remain[j]=gas[j]-cost[j]+remain[(i-1)%n];
                started++;
                if(started==n){
                    System.out.println(j);
                    break;
                }
            }
            System.out.println("tai "+j+" remain "+remain[j]+" started "+started);
        }
    }
}
