package ya;

public class HaystackNeedleEasy {

    public int strStr(String haystack, String needle) {

        if(needle.length()>haystack.length())
            return -1;

        int x = needle.length();
        int y = haystack.length();

        for(int windowStart = 0; windowStart < (y-x); windowStart++){
            for(int i = 0; i<x; i++){
                if(needle.charAt(i)!=haystack.charAt(windowStart+i))
                    break;
                if(i==x-1)
                    return windowStart;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new HaystackNeedleEasy().strStr("sadsadsad", "sad"));
        System.out.println(new HaystackNeedleEasy().strStr("abcsaxxsadxc", "sad"));
        System.out.println(new HaystackNeedleEasy().strStr("aaa", "aaaa"));
        System.out.println(new HaystackNeedleEasy().strStr("mississippi", "issip"));
    }
}
