public class OptimalDivision {
    public static float optimalDivision(int[] nums) {
        float[][] minDP=new float[nums.length+1][nums.length];
        float[][] maxDP=new float[nums.length+1][nums.length];
        for(int j=0;j<nums.length;j++){
            minDP[1][j]=nums[j];
            maxDP[1][j]=nums[j];
        }
        for(int i=2;i<nums.length;i++){
            for(int j=0;j<=nums.length-i;j++){
                for(int t=j+1;t<i+j;t++){
                    maxDP[i][j]=Math.max(maxDP[i][j],maxDP[t-j][j]/minDP[i-t-j][t]);
                    minDP[i][j]=Math.min(minDP[i][j],minDP[t-j][j]/maxDP[i-t-j][t]);
                }
            }
        }
        return maxDP[nums.length][0];
    }

    public static void main(String[] args) {
        System.out.println(optimalDivision(new int[]{1000,100,10,2}));
    }
}
