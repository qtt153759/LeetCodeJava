public class OutofBoundaryPaths {
    public static Integer dp[][][];
    public static int m,n;
    public static int [][]directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer [maxMove+1][m][n];
        this.m=m;
        this.n=n;
        return dfs(startRow,startColumn,maxMove);
    }
    public static int dfs(int startRow,int startColumn,int maxMove){
        if(startRow<0||startRow>=m||startColumn<0||startColumn>=n){
            return 1;
        }
        if(dp[startRow][startColumn][maxMove]!=null){
            return dp[startRow][startColumn][maxMove];
        }
        if(maxMove==0){
            return 0;
        }
        int tmp=0;
        for(int []direction:directions){
            tmp=tmp+dfs(startRow+direction[0],startColumn+direction[1],maxMove-1)% 1_000_000_007;
        }
        return dp[startRow][startColumn][maxMove]=tmp;
    }
}
