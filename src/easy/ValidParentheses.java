package easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length()%2!=0) return false;

        char[] array = s.toCharArray();
        int length = array.length-1;

        if(array[0] == ')' || array[0] == '}' || array[0] == ']'
                ||  array[length] == '(' || array[length] == '{' || array[length] == '[')
            return false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<=length; i++){
            if(array[i] == '(' || array[i] == '{' || array[i] == '[')
                stack.push(array[i]);
            else
            {
                switch(array[i])
                {
                    case ')':   if(stack.empty() || stack.pop() != '(')
                                    return false;
                                break;
                    case '}':   if(stack.empty() || stack.pop() != '{')
                                    return false;
                                break;
                    case ']':   if(stack.empty() || stack.pop() != '[')
                                    return false;
                                break;
                    default: return false;
                }
            }
        }


        if(stack.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));  // true
        System.out.println(new ValidParentheses().isValid("[[[]]]"));  // true
        System.out.println(new ValidParentheses().isValid("({)}"));    // false
        System.out.println(new ValidParentheses().isValid("[([]])"));  // false
    }
}

