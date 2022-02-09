import java.util.HashSet;

public class NumberofOperationstoMakeNetworkConnected {
    public static int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        if (connections.length < n - 1) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < connections.length; i++) {
            union(connections[i][0], connections[i][1], parent);
        }
//        Bài đếm đảo này không bao giờ có chuyện union chụm lại thành 1 mà mình chỉ xét parent[i]==i thì count++
        int count=0;
        for (int i = 0; i < n; i++) {
            if(parent[i]==i){
                count++;
            }
        }
        return count - 1;
    }
    public static void union(int a, int b, int[] parent) {
        if (find(a,parent) == find(b,parent)) {
            return;
        }
        parent[find(b, parent)] = find(a, parent);
    }
    public static int find(int k, int parent[]) {
        if (k != parent[k]) {
            parent[k] = find(parent[k], parent);
        }
        return parent[k];
    }
    public static void main(String[] args) {
        System.out.println(makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
    }
}
