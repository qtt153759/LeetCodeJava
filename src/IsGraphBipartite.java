public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]==0&&!dfs(graph,color,1,i)){
                return false;
            }
        }
        return true;
    }
    public static boolean dfs(int[][] graph,int []color,int paint,int k){
        if(color[k]!=0){
            return color[k]==paint;
        }
        color[k]=paint;
        for(int tmp:graph[k]){
            if(!dfs(graph,color,-paint,tmp)){
                return false;
            }
        }
        return true;
    }
}
