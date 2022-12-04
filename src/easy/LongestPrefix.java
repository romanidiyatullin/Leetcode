package easy;

public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return "";
        if(strs.length==1) return strs[0];

        int min = strs[0].length();

        int i = 0;

        while(i<min)
        {
            char letter = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if(i==0)
                    if (min>strs[j].length())
                            min = strs[j].length();
                if (i == strs[j].length() || letter != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
            i++;
        }
        return strs[0].substring(0,i);
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(new LongestPrefix().longestCommonPrefix(new String[]{"flower","flow","fl"}));
        long endTime = System.nanoTime();
        System.out.println("Execution took: " + (endTime-startTime));
    }
}