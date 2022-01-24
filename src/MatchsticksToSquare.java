import java.util.Arrays;
import java.util.Collections;

public class MatchsticksToSquare {
    public static boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4){
            return false;
        }
        int sum=0;
        int []sticks=new int[matchsticks.length];
        for(int i=0;i<matchsticks.length;i++){
            sum=sum+matchsticks[i];
        }
        if(sum%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);

        return Solve(matchsticks.length-1,matchsticks,sticks,sum/4);
    }
    public static boolean Solve(int k,int matchsticks[],int []sticks,int target){
        for(int i=0;i<4;i++){
            if(sticks[i]+matchsticks[k]<=target  ){
                sticks[i]=sticks[i]+matchsticks[k];
                if(k==0){
                    if(sticks[0]==target&&sticks[0]==target&&sticks[0]==target){
                        return true;
                    }
                }
                else if(Solve(k-1,matchsticks,sticks,target)){
                    return true;
                }
                sticks[i]=sticks[i]-matchsticks[k];
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,102}));
    }
}
