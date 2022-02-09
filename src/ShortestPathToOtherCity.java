import java.util.Arrays;

public class ShortestPathToOtherCity {
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] dis = new int[n][n];
            int res = 0, smallest = n;
            for (int[] row : dis)
                Arrays.fill(row, 10001);
            for (int[] e : edges)
                dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
            for (int i = 0; i < n; ++i)
                dis[i][i] = 0;
            for (int k = 0; k < n; ++k)
                for (int i = 0; i < n - 1; ++i)
                    for (int j = i; j < n; ++j) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        if (dis[i][j] > dis[j][i]) {
                            dis[i][j] = dis[j][i];
                        } else {
                            dis[j][i] = dis[i][j];
                        }
                    }
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; ++j)
                    if (dis[i][j] <= distanceThreshold)
                        ++count;
                if (count <= smallest) {
                    res = i;
                    smallest = count;
                }
            }
            return res;
        }
    }

}
