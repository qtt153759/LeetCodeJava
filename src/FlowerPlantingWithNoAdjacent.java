import java.util.ArrayList;
import java.util.HashMap;

public class FlowerPlantingWithNoAdjacent {
    public static int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, ArrayList<Integer>>map=new HashMap<>();
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[]path:paths){
            map.get(path[0]-1).add(path[1]-1);
            map.get(path[1]-1).add(path[0]-1);
        }
        for(int i=0;i<n;i++){
            boolean color[]=new boolean[5];
            for(int j=0;j<map.get(i).size();j++){
                color[res[j]]=true;
            }
            for(int c=1;c<=4;c++){
                if(!color[c]){
                    res[i]=c;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []res=gardenNoAdj(3,new int[][]{{1,2},{2,3},{1,3}});
        for(int a:res){
            System.out.println(a);
        }
    }
}
