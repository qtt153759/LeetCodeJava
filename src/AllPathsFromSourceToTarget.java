import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static  List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        boolean[] visted = new boolean[graph.length];
        dfs(graph,visted,0,list,path);
        return list;
    }

    public static void dfs(int[][] graph, boolean[] visted, int k, List<List<Integer>> list,List<Integer>path) {
        System.out.println("Xet "+k+" co length "+graph[k].length);
        if(k==graph.length-1){
            list.add(new ArrayList<>(path));
            return;
        }
        visted[k] = true;
        for (int i = 0; i < graph[k].length; i++) {
            if (!visted[graph[k][i]]) {
                path.add(graph[k][i]);
                dfs(graph, visted, graph[k][i], list,path);
                path.remove(path.indexOf(graph[k][i]));
            }
        }
        visted[k] = false;
    }

    public static void main(String[] args) {
        int [][]graphs=new int[][]{{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graphs));
    }
}
