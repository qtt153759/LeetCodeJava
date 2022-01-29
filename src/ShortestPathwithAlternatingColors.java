import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathwithAlternatingColors {
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashSet<Integer>[][] graph = new HashSet[2][n];
        int res[][]=new int[n][2];
        int ans[]=new int[n];
        for (int i = 0; i < n; i++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }
        for (int[] redEdge : redEdges) {
            graph[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            graph[1][blueEdge[0]].add(blueEdge[1]);
        }
        for(int i=1;i<n;i++){
            res[i][0]=2*n;
            res[i][1]=2*n;
        }
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(new int[]{0,1});
        while (!q.isEmpty()){
            int[]tmp=q.remove();
//            System.out.println("xet "+tmp[0]+" va "+tmp[1]);
            for(int i:graph[1-tmp[1]][tmp[0]]){
//                System.out.println("xet "+i+" tai "+tmp[0]+" va "+(1-tmp[1]));
                if(res[i][1-tmp[1]]==2*n){
                    res[i][1-tmp[1]]=1+res[tmp[0]][tmp[1]];
                    q.add(new int[]{i,1-tmp[1]});
//                    System.out.println("add "+i+"-----"+(1-tmp[1])+" va res"+res[i][1-tmp[1]]);
                }
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=Math.min(res[i][0],res[i][1]);
//            System.out.println("ans"+ans[i]);
            ans[i]=ans[i]==2*n?-1:ans[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        int []ans=shortestAlternatingPaths(3,new int[][]{{0,1}},new int[][]{{1,2}});
        for(int answer:ans){
            System.out.println(answer);
        }
    }
}
