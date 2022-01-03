public class NumberofProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            res += dfs(i, isConnected, visited);

        }
        return res;
    }

    public static int dfs(int k, int[][] isConnected, boolean[] visited) {
        if (visited[k] == true) {
            return 0;
        } else {
            visited[k] = true;
        }
        for (int i = 0; i < isConnected[k].length; i++) {
            if (isConnected[k][i] == 1) {
                dfs(i, isConnected, visited);

            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] isConnectedNum = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnectedNum));
    }
}
