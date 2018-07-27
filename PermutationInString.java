import java.util.*;
class PermutationInString {
    public static void main(String arg[]){
        System.out.println(new PermutationInString().checkInclusion("iceland","iceland"));
    }
    public boolean checkInclusion(String s1, String s2) {
        char[] s2c = s2.toCharArray();
        char[] s1c = s1.toCharArray();

        int loop = s2c.length-s1c.length;
        for(int i = 0 ; i <= loop; i++){
            char c = s2c[i];
            if(s1.indexOf(c) >= 0 && same(Arrays.copyOfRange(s2c,i,i+s1c.length),s1c)){
                return true;
            }
        }
        return false;
    }
    public boolean same(char[] a, char[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0 ; i < a.length; i++){
            // System.out.println(a[i]+","+b[i]);
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}