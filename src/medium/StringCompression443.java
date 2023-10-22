package medium;

public class StringCompression443 {
    public static int compress(char[] chars){

        if(chars==null) return -1;
        if(chars.length<2) return chars.length;

        StringBuilder sb = new StringBuilder();
        int counter = 1;

        for(int i=0, j=1; j<chars.length; j++){
            if(chars[i] == chars[j])
                counter++;
            else{
                sb.append(chars[i]);
                if(counter>1)
                    sb.append(counter);
                counter=1;
                i=j;
            }
        }
        if(counter>0)
            sb.append(chars[chars.length-1]);
        if(counter>1)
            sb.append(counter);

        String result = sb.toString();
        for(int i=0; i<result.length(); i++){
            chars[i] = result.charAt(i);
        }
        //System.out.println(result);
        return result.length();
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a','a','a','b','b','c','c','c'}));
    }
}
