import java.util.*;

public class Booking {
    public static final int N=1000000;
    public static int n;
    public static Scanner sc=new Scanner(System.in);
    public static int list[][];
    public static HashMap<Integer,ArrayList>map=new HashMap<>();
    public static int []res;
    public static boolean []visited;
    public static int[] choose;
    public static int result=0;
    public static void main(String[] args) {
        n=sc.nextInt();
        res=new int[N];
        choose=new int[N];
        visited=new boolean[N];
        list=new int[n][3];
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            list[i][0]=a;
            list[i][1]=b;
            list[i][2]=c;
        }
        Arrays.sort(list,(a, b)-> {
            return a[1] - b[1];
        });
//        for(int i=0;i<list.length;i++){
//            System.out.println(i+" : "+list[i][0]+","+list[i][1]+","+list[i][2]);
//        }
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
            for(int j=0;j<i;j++){
                if(list[j][1]>=list[i][0]){
                    map.get(i).add(j);
                }
            }
            for(int j=i+1;j<list.length;j++){
                if(list[j][0]<=list[i][1]){
                    map.get(i).add(j);
                }
            }
//            System.out.print("\n"+i+" : " );
//            for(int j=0;j<map.get(i).size();j++){
//                System.out.print(map.get(i).get(j)+" ");
//            }
        }
        choose[0]=0;
        Solve(1);
        System.out.println(result);
    }
    public static boolean check(int i,int k){
        if(k==1){
//            System.out.println("Check i "+i+" va k "+k +" ok do k=1");
            return true;
        }
        if(visited[i]==true){
//            System.out.println("Check i "+i+" va k "+k +" sai do visited");
            return false;
        }
        for(int j=1;j<k;j++){
            if(map.get(choose[j]).contains(i)){
//                System.out.println("Check i "+i+" va k "+k +" sai do contain"+ choose[j]);
                return false;
            }
        }
        return true;
    }
    public static void Solve(int k){
        for(int i=0;i<n;i++){
            if(check(i,k)){
//                System.out.println("Xet "+k+" vao "+i+" co list[i][2]"+list[i][2]+ "va res[k-1]"+res[k-1]);
                visited[i]=true;
                res[k]=res[k-1]+list[i][2];
                choose[k]=i;
//                System.out.println("Chon k"+k+" choose "+choose[k]+" res "+res[k]);
                if(k<=n){
                    Solve(k+1);
                }
                if(res[k]>result){
                    result=res[k];
//                    System.out.println("update res"+result);
//                    for(int t=0;t<=k;t++){
//                        System.out.print(res[t]+" ");
//                    }
                }
                visited[i]=false;
            }
        }
    }
}
