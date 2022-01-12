import java.util.*;
import java.util.stream.Collectors;

public class KeysandRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        // DFS(rooms, 0,visited);
        BFS(rooms,visited);

        for(int i=0; i<visited.length; i++){
            if(visited[i] == false) return false;
        }
        return true;
    }

    // private void DFS(List<List<Integer>> rooms, int sv, boolean[] visited){
    //     visited[sv] = true;
    //     for(int  i : rooms.get(sv)){
    //         if(visited[i] == false)
    //             DFS(rooms,i,visited);
    //     }
    // }

    private static void BFS(List<List<Integer>> rooms,boolean[] visited){

        Queue<Integer> queue =  new LinkedList<>();
        visited[0] = true;
        for(int i : rooms.get(0)){
            queue.add(i);
            visited[i] = true;
        }
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int i : rooms.get(v)){
                if(visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer[][] dataSet = new Integer[][] {{1,3}, {1,4}, {2,3,4,1},{4,3,2}};
        List<List<Integer>> rooms = new ArrayList<>(dataSet.length);

        for (Integer[] record : dataSet) {
            rooms.add(Arrays.asList(record));
        }

        System.out.println(canVisitAllRooms(rooms));
    }
}
