import java.util.Scanner;

public class Excel {
    public static Scanner sc=new Scanner(System.in);
    public static String[][]excel;
    public static int s,r;
    public static void main(String[] args) {
        s=sc.nextInt();
        r=sc.nextInt();
        for(int i=0;i<s;i++){
            String str=sc.nextLine();
            String[] tmp=str.split("\\s+");
            for(int j=0;j<r;j++){
                excel[i][j]=tmp[j];
            }
        }
    }
    public static void Solve(int k){
        for(int i=0;i<r;i++){
            if(excel[k][i].charAt(0)=='+'){

            }
        }
    }
}
