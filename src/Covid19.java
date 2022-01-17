import java.util.Scanner;

public class Covid19 {
    public static final int N=1000001;
    public static int p,r,n;
    public static Scanner sc=new Scanner(System.in);
    public static long[] f=new long[N];
    public static void main(String[] args) {
        p=sc.nextInt();
        n=sc.nextInt();
        r=sc.nextInt();
        long number=n;
        int i=0;
//        System.out.println("bdd "+f[i-1]);
        while(number<=p){
//            System.out.println("voi "+(i-1)+" ta co "+f[i-1]);
            n*=r;
            number+=n;
            i++;
        }
        System.out.println(i);
        return;
    }
}
