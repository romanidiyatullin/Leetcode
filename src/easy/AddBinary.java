package easy;

public class AddBinary {

    public String addBinary(String a, String b) {

        if( a == null || b == null || a.length()<1 || b.length()<1 || a.length() > 10000 || b.length() > 10000)
            return null;

        if(a.length()<65 && b.length()<65)
            return Long.toBinaryString((Long.parseUnsignedLong(a,2) + Long.parseUnsignedLong(b,2)));

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        char[] shortArray = arrayA.length <= arrayB.length ? arrayA : arrayB;
        char[] longArray  = arrayA.length > arrayB.length  ? arrayA : arrayB;


        int indexShort = shortArray.length-1;
        int indexLong  = longArray.length-1;

        int indexResult = indexLong+1;
        int[] result = new int[indexResult +1];

        StringBuilder resultString = new StringBuilder(result.length);

        int remnant = 0;
        int sum = 0;

        while(indexShort>=0) {

            sum = Character.getNumericValue(shortArray[indexShort]) + Character.getNumericValue((longArray[indexLong])) + remnant;

            if(sum<=1){
                result[indexResult] = sum;
                remnant = 0;
            }
            else{
                result[indexResult] = sum % 2;
                remnant = 1;
            }
            indexShort--;
            indexLong--;
            indexResult--;
        }


        if(indexShort == indexLong) {

            if(remnant > 0)
                result[0] = 1;

            for(int i:result)
                resultString.append(i);

            if(resultString.charAt(0) == '0')
                resultString.deleteCharAt(0);

            return resultString.toString();
        }

        while(indexLong >= 0){

            sum = Character.getNumericValue(longArray[indexLong]) + remnant;

            if(sum<=1){
                result[indexResult] = sum;
                remnant = 0;
            }
            else{
                result[indexResult] = sum % 2;
                remnant = 1;
            }
            indexResult--;
            indexLong--;
        }

        if(remnant > 0)
            result[0] = 1;

        for(int i:result)
            resultString.append(i);

        if(resultString.charAt(0) == '0')
            resultString.deleteCharAt(0);

        return resultString.toString();
    }

    public static void main(String[] args) {
         String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
         String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(new AddBinary().addBinary(a,b));
    }
}
