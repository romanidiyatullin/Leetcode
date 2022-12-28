package easy;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        if(digits == null || digits.length == 0 || digits.length > 100)
            return null;

        boolean isIncremented = false;

        for(int i = digits.length-1; i>=0; i--){
            if(!isIncremented)
                if(digits[i] == 9)
                    digits[i] = 0;
                else {
                    digits[i]+=1;
                    isIncremented = true;
                }
            else break;
        }
        if(digits[0] == 0){
            int[] array = new int[digits.length+1];
            array[0] = 1;
            for(int i=1; i<array.length; i++)
                array[i] = digits[i-1];
            digits = array;
        }
        return digits;
    }

    public static void main(String[] args) {
        for(int i : new PlusOne().plusOne(new int[]{9}))
            System.out.println(i);
    }
}
