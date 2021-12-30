import java.util.Arrays;

public class RotateFunction {
    public static int maxRotateFunction(int[] nums) {
        int n= nums.length;
        int total= Arrays.stream(nums).sum();
        int []f=new int [n];
        for(int i=0;i<n;i++){
            f[0]+=i*nums[i];
        }
        int max=f[0];
        for(int i=1;i<n;i++){
            f[i]=f[i-1]-nums[n-i]*n+total;
            if(f[i]>max){
                max=f[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(combinationSum4());
        int[] nums = {4,3,2,6};

        System.out.println(maxRotateFunction(nums));
    }
}
