import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        total = total / 2;
        boolean dp[][] = new boolean[nums.length + 1][total + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;//total =0 alway true
        }
        for (int i = 0; i <= total; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];//kiem tra doan tu 0->i co chua so j ko,Bài toán con giống bài knapsak không phải  bài equalSubsetSum
                }
            }
        }
        return dp[nums.length][total];
    }

    public static void main(String[] args) {
        canPartition(new int[]{1, 5, 11, 5});
    }
}
