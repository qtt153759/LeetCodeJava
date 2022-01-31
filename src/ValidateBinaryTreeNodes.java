public class ValidateBinaryTreeNodes {
    public static int count = 0;
    public static boolean[] visited;

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        visited = new boolean[n];
        if (!check(0, leftChild, rightChild)) return false;
        if (count != n) return false;
        return true;
    }

    public static boolean check(int k, int[] leftChild, int[] rightChild) {
//        System.out.println("k= "+k);
        if (k == -1) return true;
//        System.out.println("visited= "+visited[k]);
        if (visited[k]) return false;
        visited[k] = true;
        count++;
//        System.out.println("count"+count);
        if (!check(leftChild[k], leftChild, rightChild)) return false;
        if (!check(rightChild[k], leftChild, rightChild)) return false;
//        System.out.println("k"+k+" return true");
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateBinaryTreeNodes(5,new int[]{1,3,-1,-1,-1},new int[]{-1,2,4,-1,-1}));
    }
}
/*5
[]
[]*/
