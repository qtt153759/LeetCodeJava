import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class oil {
    public static final int N=100000;
    public static int n,s;
    public static int t=0;
    public static int list[][];
    public static Scanner sc=new Scanner(System.in);
    public static int arr[];
    public static boolean []visited;
    public static int []res;
    public static int[] choose;
    public static int result=0;
    public static HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    public static void main(String[] args) {
        n=sc.nextInt();
        s=sc.nextInt();
        arr=new int[n+1];
        list=new int[N][3];
        res=new int[N];
        choose=new int[N];
        visited=new boolean[N];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                list[t][0]=i;
                list[t][1]=j;
                list[t][2]=-arr[i]+arr[j]-s*(j-i);
                System.out.println("Doan "+t+" voi "+list[t][0]+" "+list[t][1]+" "+list[t][2]);
                t++;
            }

        }
        Arrays.sort(list,(a,b)->{
            return b[2]-a[2];
        });
        for(int i=0;i<t-1;i++){
            map.putIfAbsent(i,new ArrayList<>());
            for(int j=i+1;j<t;j++){
                map.putIfAbsent(j,new ArrayList<>());
                if(j!=i){
                    if(arr[list[i][0]]==arr[list[j][0]]||
                            arr[list[i][0]]==arr[list[j][1]]||
                            arr[list[i][1]]==arr[list[j][0]]||
                            arr[list[i][1]]==arr[list[j][1]]){
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }
            System.out.print("\n"+i+" : " );
            for(int j=0;j<map.get(i).size();j++){
                System.out.print(map.get(i).get(j)+" ");
            }
        }
        choose[0]=0;
        Solve(1);
        System.out.println(result);
    }
    public static boolean check(int i,int k){
        if(k==1){
            System.out.println("Check i "+i+" va k "+k +" ok do k=1");
            return true;
        }
        if(visited[i]==true){
            System.out.println("Check i "+i+" va k "+k +" sai do visited");
            return false;
        }
        for(int j=1;j<k;j++){
            if(map.get(choose[j]).contains(i)){
                System.out.println("Check i "+i+" va k "+k +" sai do contain"+ choose[j]);
                return false;
            }
        }
        return true;
    }
    public static void Solve(int k){
        for(int i=0;i<t;i++){
            if(check(i,k)){
                System.out.println("Xet "+k+" vao "+i+" co list[i][2]"+list[i][2]+ "va res[k-1]"+res[k-1]);
                visited[i]=true;
                res[k]=res[k-1]+list[i][2];
                choose[k]=i;
                System.out.println("Chon k"+k+" choose "+choose[k]+" res "+res[k]);
                if(k<=n){
                    Solve(k+1);
                }
                if(res[k]>result){
                    result=res[k];
                    System.out.println("update res"+result);
                    for(int t=0;t<=k;t++){
                        System.out.print(res[t]+" ");
                    }
                }
                visited[i]=false;
            }
        }
    }
}
