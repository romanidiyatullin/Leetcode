package easy;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        if(s == null || s.length() == 0 || s.length() > 10000)
            return -1;

        char[] array = s.toCharArray();

        int length = 0;

        for(int i = array.length-1; i>=0; i--){

            if(array[i] == ' ' && length == 0)
                continue;

            if(array[i] == ' ' && length > 0 )
                return length;

            if(array[i] != ' ')
                length++;
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord(" abc def   g h  ijkl    "));
    }
}
