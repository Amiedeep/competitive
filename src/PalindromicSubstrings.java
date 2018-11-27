public class PalindromicSubstrings {

    private final String input;

    public PalindromicSubstrings(String input) {
        this.input = input;
    }

    public static void main(String[] args) {
        String input = "abc";
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings(input);

        palindromicSubstrings.printPalindromicsSubstrings();
    }

    private void printPalindromicsSubstrings() {
        int inputLength = input.length();
        boolean[][] isPalindrome = new boolean[inputLength][inputLength];

        for (int i = 0; i < inputLength; i++) {
            isPalindrome[i][i] = true;
        }

        int count = inputLength;
        for (int i = inputLength - 2; i >= 0; i--) {
            for (int j = i + 1; j < inputLength; j++) {
                if((j-i) == 1)
                    isPalindrome[i][j] = (input.charAt(i) == input.charAt(j));
                else
                    isPalindrome[i][j] = ((input.charAt(i) == input.charAt(j)) && isPalindrome[i+1][j-1]);

                if (isPalindrome[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
