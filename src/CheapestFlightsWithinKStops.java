import java.util.*;

public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
            System.out.println("Get "+flight[0]+" co "+map.get(flight[0]).get(flight[1]));
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int []distant=new int [n+1];
        Arrays.fill(distant, 10000);
        q.add(new int[]{0, 0, src});
        while (!q.isEmpty()) {
            int tmp[] = q.remove();
            System.out.println("xet ["+tmp[0]+","+tmp[1]+","+tmp[2]+"]");
            distant[tmp[2]]=tmp[0];
            if(tmp[2]==dst){
                return tmp[0];
            }
            if (tmp[1] <= k&&map.containsKey(tmp[2])) {
                for (int i : map.get(tmp[2]).keySet()) {
                    System.out.println("keyset "+tmp[2]+" co "+i);
                    if(distant[i]>tmp[0]+map.get(tmp[2]).get(i)){
                        q.add(new int[]{tmp[0] + map.get(tmp[2]).get(i), tmp[1] + 1, i});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] flights=
                {{11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},{3,12,23},{11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},{9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},{0,5,43},{11,2,52},{11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},{12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},{9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}};

        System.out.println(findCheapestPrice(13,flights,10,1,10));
    }
}
