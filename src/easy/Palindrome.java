package easy;

public class Palindrome {
    public boolean isPalindromeViaString(int x) {
        if(x<0) return false;
        String number = String.valueOf(x);
        StringBuilder reversed = new StringBuilder(number).reverse();
        return number.equals(reversed.toString());
    }

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reversed = 0;
        int digit = 0;
        int number = x;
        while(number != 0){
            digit = number % 10;
            reversed = reversed*10 + digit;
            number /= 10;
        }
        return x == reversed;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121));
    }
}
