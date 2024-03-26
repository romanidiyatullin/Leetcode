package ya;

public class ReverseInt7 {
    public static void main(String[] args) {
        System.out.println(new ReverseInt7().reverse(123));
    }

    public int reverse(int x) {
        int result = 0;
        while(x>0){
            int digit = x%10;
            x = x/10;
            result = result*10 + digit;
        }
        return result;
    }
}
