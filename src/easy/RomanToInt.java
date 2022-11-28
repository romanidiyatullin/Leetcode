package easy;

import java.util.Stack;

public class RomanToInt {
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        int result = 0;
        char symbol = 0;
        Stack<Character> stack = new Stack<>();
        for(int position = 0; position < array.length; position++){
            symbol = array[position];
            result += analyze(symbol, array, stack, result);
        }
        if(!stack.empty())
            switch (stack.pop()){
                case 'I' : result+=1; break;
                case 'X' : result+=10; break;
                case 'C' : result+=100; break;
                default: throw new RuntimeException("OLOLOLLOLLOL!");
            }
        return result;
    }

    public int analyze(char symbol, char[] array, Stack<Character> stack, int result) {
        if(stack.empty())
            switch(symbol){
                case 'V': result=5; break;
                case 'L': result=50; break;
                case 'D': result=500; break;
                case 'M': result=1000; break;
                default:  stack.push(symbol); result = 0;
            }
        else{
            // recursive method(..)
            switch (stack.pop()){
                case 'I':
                    switch(symbol){
                        case 'V': result = 4; break;
                        case 'X': result = 9; break;
                        case 'I': result = 2; break;
                        default: result = 2;
                    };break;
                case 'X':
                    switch(symbol){
                        case 'L': result = 40; break;
                        case 'C': result = 90; break;
                        case 'I': result = 11; break;
                        default: result = 20;
                    };break;
                case 'C':
                    switch(symbol){
                        case 'D': result = 400; break;
                        case 'M': result = 900; break;
                        default: result = 200;
                    };break;
                default: throw new RuntimeException("OLOLOLOLOLOL!!");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("XIX"));
    }
}
