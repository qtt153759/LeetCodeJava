public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum=nums[i]+sum;
        }
        if(target>=sum||target<=-sum){
            return 0;
        }
        int [][]dp=new int[nums.length+1][sum*2+1];
        dp[0][sum]=1;
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=sum*2;j++){
                if(j+nums[i-1]<=sum*2){
                    dp[i][j]+=dp[i-1][j+nums[i-1]];
                }
                if(j-nums[i-1]>=0){
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum+target];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
