package November18;

import java.util.Scanner;
import java.util.stream.Stream;

public class HMAPPY1 {

    private final int[] inputArray;
    private final int k;
    private int longestSubsequence;

    public HMAPPY1(int[] inputArray, int k) {
        this.inputArray = inputArray;
        this.k = k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int k = Integer.parseInt(input[input.length - 1]);

        int[] inputArray = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HMAPPY1 hmappy1 = new HMAPPY1(inputArray, k);

        String queries = scanner.nextLine();

        for (int i = 0; i < queries.length(); i++) {
            if(queries.charAt(i) == '!') {
                hmappy1.rightShiftArray();
            }
            else {

                hmappy1.updateLongestSubSequence();
                hmappy1.printLongestSubsequence();
            }
        }
    }

    private void printLongestSubsequence() {
        System.out.println(this.longestSubsequence);
    }

    private void rightShiftArray() {
        int inputArrayLength = inputArray.length;
        int temp = inputArray[inputArrayLength -1];

        System.arraycopy(inputArray, 0, inputArray, 1, inputArrayLength - 1);

        inputArray[0] = temp;
    }

    private void updateLongestSubSequence() {
        int longestSequenceIncludingElement = 0;
        this.longestSubsequence = 0;
        for (int i = 0; i < inputArray.length && this.longestSubsequence <k; i++) {

            if(inputArray[i] == 1) {
                longestSequenceIncludingElement = longestSequenceIncludingElement + 1;
                if(longestSequenceIncludingElement > this.longestSubsequence) {
                    this.longestSubsequence = longestSequenceIncludingElement;
                }
            }
            else
                longestSequenceIncludingElement = 0;
        }
    }
}
