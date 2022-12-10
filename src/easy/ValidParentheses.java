package easy;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length()%2!=0) return false;

        char[] array = s.toCharArray();
        int length = array.length-1;

        if(array[0] == ')' || array[0] == '}' || array[0] == ']'
                ||  array[length] == '(' || array[length] == '{' || array[length] == '[')
            return false;

        boolean isCircleCloseDetectedFlag = false;
        boolean isCurveCloseDetectedFlag = false;
        boolean isSquareCloseDetectedFlag = false;

        for(int i=0; i<=length; i++){
            switch(array[i]){
                case '(':
                {
                    for(int j=i+1; j<=length; j++)
                    {
                        if(array[j]==')' && !isCircleCloseDetectedFlag)
                        {
                            isCircleCloseDetectedFlag = true;
                            break;
                        }
                    }
                    if(!isCircleCloseDetectedFlag) return false;
                    break;
                }
                case '{':
                {
                    for(int j=i+1; j<=length; j++)
                    {
                        if(array[j]=='}' && !isCurveCloseDetectedFlag)
                        {
                            isCurveCloseDetectedFlag = true;
                            break;
                        }
                    }
                    if(!isCurveCloseDetectedFlag) return false;
                    break;
                }
                case '[':
                {
                    for(int j=i+1; j<=length; j++)
                    {
                        if(array[j]==']' && !isSquareCloseDetectedFlag)
                        {
                            isSquareCloseDetectedFlag = true;
                            break;
                        }
                    }
                    if(!isSquareCloseDetectedFlag) return false;
                    break;
                }
                case ')':
                {
                    if(isCircleCloseDetectedFlag) {
                        isCircleCloseDetectedFlag = false;
                    }
                    break;
                }
                case '}':
                {
                    if(isCurveCloseDetectedFlag) {
                        isCurveCloseDetectedFlag = false;
                    }
                    break;
                }
                case ']':
                {
                    if(isSquareCloseDetectedFlag) {
                        isSquareCloseDetectedFlag = false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("(()][)"));
    }
}

