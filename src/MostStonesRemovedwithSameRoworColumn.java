import java.util.HashSet;

public class MostStonesRemovedwithSameRoworColumn {
    public static int removeStones(int[][] stones) {
        HashSet<Integer> setRow=new HashSet<>();
        HashSet<Integer> setCol=new HashSet<>();
        int res=0;
        for(int i=0;i<stones.length;i++){
            if(!setRow.contains(stones[i][0])){
                setRow.add(stones[i][0]);
            }if(!setCol.contains(stones[i][1])){
                setCol.add(stones[i][1]);
            }
        }
        for(int i=stones.length-1;i>=0;i--){
            if(setRow.contains(stones[i][0])||setCol.contains(stones)){

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][]stones={{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(removeStones(stones));
    }
}
