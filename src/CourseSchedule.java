import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
                Queue<Integer> q = new LinkedList<>();
                int canFinishCount = 0;
                for (int i = 0; i < prerequisites.length; i++) {
                    indegree[prerequisites[i][0]]++;
                }
                for (int i = 0; i < indegree.length; i++) {
                    if (indegree[i] == 0) {
                        canFinishCount++;
                        q.add(i);
                    }
                }
                while (!q.isEmpty()) {
                    int tmp = q.poll();
                    for (int i = 0; i < prerequisites.length; i++) {
                        if (prerequisites[i][1] == tmp) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        q.add(prerequisites[i][0]);
                        canFinishCount++;
                    }
                }
            }
        }
        if (canFinishCount == numCourses) {
            return true;

        }
        return false;
    }


}
