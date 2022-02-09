import java.util.*;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    public static int minReorder(int n, int[][] connections) {
        int res=0;
        HashMap<Integer, ArrayList<Integer>>map=new HashMap<>();
        HashSet<String>str=new HashSet<>();
        PriorityQueue<Integer>q=new PriorityQueue<>();
        boolean[]visited=new boolean[n];

        for(int i=0;i<connections.length;i++){
            map.computeIfAbsent(connections[i][0],l->new ArrayList<>()).add(connections[i][1]);
            map.computeIfAbsent(connections[i][1],l->new ArrayList<>()).add(connections[i][0]);
            str.add(connections[i][0]+","+connections[i][1]);
        }
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int tmp=q.remove();
            for(int i:map.getOrDefault(tmp,new ArrayList<>())){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;
                    if(!str.contains(i+","+tmp)) res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }
}
