public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()+1][s.length()];
        for(int i=0;i<s.length();i++){
            dp[1][i]=1;
        }
        for(int i=2;i<=s.length();i++){
            for(int j=0;j<=s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i-1)){
                    dp[i][j]=dp[i-2][j+1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j+1]);
                }
            }
        }
        return dp[s.length()][0];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
