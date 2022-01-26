public class UniqueSubstringsinWraparoundString {
    public static int findSubstringInWraproundString(String p) {
        int[] res=new int[26];
        int result=0;
        int length=0;
        for(int i=0;i<p.length();i++){
            if(i>0&&((p.charAt(i)-p.charAt(i-1)==1)||(p.charAt(i-1)-p.charAt(i)==25))){
                length++;
            }else{
                length=1;
            }
            res[p.charAt(i)-'a']=Math.max(res[p.charAt(i)-'a'],length);
        }
        for(int i=0;i<26;i++){
            result+=res[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("zab"));
    }
}
