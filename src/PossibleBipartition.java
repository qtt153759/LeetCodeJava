import java.util.ArrayList;
import java.util.HashMap;

public class PossibleBipartition {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] color = new int[n + 1];
        for (int[] dislike : dislikes) {
            map.putIfAbsent(dislike[0], new ArrayList<>());
            map.putIfAbsent(dislike[1], new ArrayList<>());
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, map, color, 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int k, HashMap<Integer, ArrayList<Integer>> map, int[] color, int paint) {
        if (color[k] != 0) {
            return color[k] == paint;
        }
        color[k] = paint;
        for (int i : map.get(k)) {
            if (!dfs(i, map, color, -paint)) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(possibleBipartition(3, dislikes));
    }
}
