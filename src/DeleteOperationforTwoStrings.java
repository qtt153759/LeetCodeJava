public class DeleteOperationforTwoStrings {
    public static int minDistance(String word1, String word2) {
        int a=word1.length();
        int b=word2.length();
        int[][] dp=new int[a+1][b+1];
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,Math.max(dp[i-1][j],dp[i][j-1]));
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return a-dp[a][b]+b-dp[a][b];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
    }
}
