import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int index=0;
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int tmp = q.poll();
            order[index++] = tmp;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == tmp) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        System.out.println("index"+index+numCourses);
        for(int i=0;i<order.length;i++){
            System.out.println(order[i]);
        }
        return (index == numCourses) ? order : new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisites={{1,0}} ;
        System.out.println(findOrder(2,prerequisites));
    }
}
