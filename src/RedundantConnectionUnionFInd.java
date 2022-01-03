public class RedundantConnectionUnionFInd {
    public int[] findRedundantConnection(int[][] edges) {
        int[]parent=new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
            parent[i]=i;
        }
        for(int[]edge:edges){
            if(parent[edge[0]]==parent[edge[1]]){
                return edge;
            }else if(find(edge[0],parent)==find(edge[1],parent)){
                return edge;
            }else{
                parent[edge[0]]=find(edge[1],parent);
            }
        }
        return new int[0];
    }
    public int find(int k,int[]parent){
        if(parent[k]!=k){
            parent[k]=find(parent[k],parent);
        }
        return parent[k];
    }
}
