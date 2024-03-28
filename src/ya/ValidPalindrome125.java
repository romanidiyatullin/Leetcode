package ya;

public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {

        if(s.length()<2)
            return true;

        s = s.toLowerCase().strip().trim();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( (c>='a' && c<='z') || (c>='0' && c<='9'))
                sb.append(c);
        }

        boolean isMatched = true;

        for(int i = 0, j = sb.length()-1; i<=j; i++, j--){
            if(sb.charAt(i)!=sb.charAt(j)) {
                isMatched = false;
                break;
            }
        }

        return isMatched;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
