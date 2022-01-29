import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static int removeStones(int[][] stones) {
        int isIsland=0;
        HashSet<int[]> visited=new HashSet<>();
        for(int []stone:stones) {
            if (!visited.contains(stone)) {
                dfs(stones,stone,visited);
                isIsland++;
            }
        }
        return stones.length-isIsland;
    }
    public static void dfs(int[][]stones,int[]stone,HashSet<int[]>visited){
        visited.add(stone);
        for(int []stone1:stones) {
            if (!visited.contains(stone1)&&(stone[0]==stone1[0]||stone[1]==stone1[1])) {
                dfs(stones,stone1,visited);
            }
        }
    }



    public static void main(String[] args) {
        int[][]stones={{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(removeStones(stones));
    }
}
