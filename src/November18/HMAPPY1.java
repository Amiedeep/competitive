package November18;

import java.util.Scanner;
import java.util.stream.Stream;

public class HMAPPY1 {

    private final int[] inputArray;
    private final int k;
    private int longestSubsequence;
    private int longestSubsequenceStartIndex;
    private int rightShifts;

    public HMAPPY1(int[] inputArray, int k) {
        this.inputArray = inputArray;
        this.k = k;
        updateLongestSubSequence();
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

                int longestSubSequence = hmappy1.findLongestSubSequence();
                System.out.println(longestSubSequence);
//                hmappy1.updateLongestSubSequence();
//                hmappy1.printLongestSubsequence();
            }
        }
    }

    private int findLongestSubSequence() {

        int longestSequence = Math.min(inputArray.length - longestSubsequenceStartIndex - rightShifts, longestSubsequence);

        int temp = 0;
        int maxInStartOfArray = 0;
        for (int i = inputArray.length - rightShifts; i < inputArray.length && temp <k; i++) {
            if(inputArray[i] == 1) {
                temp = temp + 1;
                if (temp > maxInStartOfArray) {
                    maxInStartOfArray = temp;
                }
            }
            else
                temp = 0;
        }

        for (int i = 0; i < inputArray.length && temp <k; i++) {
            if(inputArray[i] == 1) {
                temp = temp + 1;
                if (temp > maxInStartOfArray) {
                    maxInStartOfArray = temp;
                }
            }
            else
                break;
        }

        return Math.max(maxInStartOfArray, longestSequence);
    }


    private void rightShiftArray() {
        this.rightShifts = (this.rightShifts + 1)%inputArray.length;
    }

    private void updateLongestSubSequence() {
        int longestSequenceIncludingElement = 0;
        this.longestSubsequence = 0;
        for (int i = 0; i < inputArray.length && this.longestSubsequence <k; i++) {

            if(inputArray[i] == 1) {
                longestSequenceIncludingElement = longestSequenceIncludingElement + 1;
                if(longestSequenceIncludingElement > this.longestSubsequence) {
                    this.longestSubsequenceStartIndex = i - longestSequenceIncludingElement + 1;
                    this.longestSubsequence = longestSequenceIncludingElement;
                }
            }
            else
                longestSequenceIncludingElement = 0;
        }
    }
}
