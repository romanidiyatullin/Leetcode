package easy;

public class RomanToIntSimple {
    public int romanToInt(String s) {
        int result = 0;

        char[] array = s.toCharArray();

        for(int i=0; i<s.length(); i++){

            if(array[i] == 'V' || array[i] == 'X'){
                if( i>0 && array[i-1] == 'I')
                    result-=2;
            }

            if(array[i] == 'L' || array[i] == 'C'){
                if( i>0 && array[i-1] == 'X')
                    result-=20;
            }

            if(array[i] == 'D' || array[i] == 'M'){
                if( i>0 && array[i-1] == 'C')
                    result-=200;
            }

            switch(array[i]){
                case 'I' : result+=1; break;
                case 'V' : result+=5; break;
                case 'X' : result+=10; break;
                case 'L' : result+=50; break;
                case 'C' : result+=100; break;
                case 'D' : result+=500; break;
                case 'M' : result+=1000; break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToIntSimple().romanToInt("XIV"));
    }
}
