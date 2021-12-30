import java.util.ArrayList;

public class IntegerReplacement {
    public static int integerReplacement(int n) {
        int count=0;
        while(n>1){
            if(n%2==0){
                n=n/2;
            }else {
                if ((n + 1) % 4 == 0 && n + 1 == 3) {
                    n++;
                } else {
                    n--;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(1234));
    }
}
