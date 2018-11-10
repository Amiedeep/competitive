import java.util.*;

public class BalancedParenthesis {

    private final List<Character> openingParenthesis;
    private final List<Character> closingParenthesis;
    private final Map<Character, Character> matchingChars;

    public BalancedParenthesis() {
        openingParenthesis = Arrays.asList('{', '[', '(');
        closingParenthesis = Arrays.asList('}', ']', ')');
        matchingChars = new HashMap<>();
        matchingChars.put('}','{');
        matchingChars.put(']','[');
        matchingChars.put(')','(');
    }

    public static void main(String[] args) {
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();

        String input1 = "a(bcd)d";
        String input2 = "(kjds(hfkj)sdhf";
        String input3 = "(sfdsf)(fsfsf";
        String input4 = "{[]}()";
        String input5 = "{[}]";
        System.out.println(balancedParenthesis.isBalanced(input1));
        System.out.println(balancedParenthesis.isBalanced(input2));
        System.out.println(balancedParenthesis.isBalanced(input3));
        System.out.println(balancedParenthesis.isBalanced(input4));
        System.out.println(balancedParenthesis.isBalanced(input5));
    }

    private boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (openingParenthesis.contains(currentChar))
                stack.push(currentChar);
            else if(closingParenthesis.contains(currentChar)) {
                if (!stack.empty()) {
                    Character stackTop = stack.pop();
                    if (matchingChars.get(currentChar) != stackTop) {
                        return false;
                    }
                }
                else
                    return false;
            }
        }
        return stack.empty();
    }
}
