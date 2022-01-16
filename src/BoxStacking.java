import java.util.Scanner;

import static java.lang.Math.max;

public class BoxStacking {
    public static Scanner sc=new Scanner(System.in);
    public static int L=0,W=0;
    public static int n,h;
    public static int[]w,l;
    public static int[][]dp;
    public static void main(String[] args) {
        n=sc.nextInt();
        w=new int[n+1];
        l=new int[n+1];
        dp=new int[n+1][];
        for(int i=1;i<=n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            l[i]=a;
            w[i]=b;
            dp[a][b]=c;
            L=L>a?L:a;
            W=W>a?W:a;
        }
        for(int i=1;i<=L;i++){
            for(int j=1;j<=W;j++){
                dp[i][j]=max(dp[i][j]+dp[i-1][j-1],max(dp[i-1][j],dp[i][j-1]));
            }
        }
        System.out.println();
    }
}
