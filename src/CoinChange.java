public class CoinChange {
    public static int change(int amount, int[] coins) {
        int [][]dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j-coins[i-1]>=0){
                    dp[i][j]+=dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println(change(3,new int[]{2}));

    }
}
