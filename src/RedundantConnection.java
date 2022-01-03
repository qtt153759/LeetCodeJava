import java.util.ArrayList;
import java.util.HashMap;

public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>>map=new HashMap<>();
        int n=edges.length;
        for(int i=0;i<=n;i++){
            map.put(i,new ArrayList<>());
            map.get(0).add(i);
        }
        for(int i=0;i<n;i++){
//            System.out.println(edges[i][0]+"va"+edges[i][1]);

            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n+1];
        int []tmp={};
        for(int i=1;i<=n;i++){
            tmp=dfs(i,map,visited,0);
            if(tmp.length!=0){
                break;
            }
        }
        if(tmp.length!=0&&tmp[0]>tmp[1]) {
            return new int[]{tmp[1], tmp[0]};
        }else if(tmp.length!=0&&tmp[0]<tmp[1]){
            return new int[]{tmp[0],tmp[1]};
        }

        return new int[]{};
    }
    public static int[] dfs(int k, HashMap<Integer,ArrayList<Integer>>map, boolean[] visited,int prev) {
//        System.out.println(k+"va"+prev+"va"+map.get(k));
        if(visited[k]==true){
            return new int[]{prev,k};
        }else{
            visited[k]=true;
            map.get(k).remove(Integer.valueOf(prev));
            map.get(prev).remove(Integer.valueOf(k));
//            System.out.println("update"+k+":"+map.get(k));
//            System.out.println("visited"+k);
        }
        int []tmp={};

        for(int i=0;i<map.get(k).size();i++){

            tmp=dfs(map.get(k).get(i),map,visited,k);
            if(tmp.length!=0){
                break;
            }
        }
        return tmp;

    }

    public static void main(String[] args) {
        int[][] isConnectedNum = {{1,2}, {2,3}, {3,4},{1,4},{1,5}};
        int res[]=findRedundantConnection(isConnectedNum);
        System.out.println(res[0]+"----"+res[1]);
    }
}
