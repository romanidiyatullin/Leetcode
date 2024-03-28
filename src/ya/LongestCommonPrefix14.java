package ya;

import java.util.Arrays;

public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==1)
            return strs[0];

        Arrays.sort(strs, (s1,s2)->s1.length()-s2.length());

        boolean isFailed = false;
        int resultLength = 0;

        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if(strs[0].charAt(i)!=strs[j].charAt(i)) {
                    isFailed = true;
                    break;
                }
            }
            if(!isFailed)
                resultLength++;
            else break;
        }

        return strs[0].substring(0, resultLength);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","fl","flowe","flo"}));
    }
}
