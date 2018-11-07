package November18;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class HMAPPY1 {

    private final int[] inputArray;
    private final int k;
    private int longestSubsequence;
    private int rightShifts;
    private int maxSubsequenceFromStart;
    private Map<Integer, List<Integer>> indexMaxValueMap;

    public HMAPPY1(int[] inputArray, int k) {
        this.inputArray = inputArray;
        this.k = k;
        indexMaxValueMap = new HashMap<>();
        updateLongestSubSequence();
        updateMaxSubsequenceFromStart();
    }

    private void updateMaxSubsequenceFromStart() {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 1)
                maxSubsequenceFromStart++;
            else
                break;
        }
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
            }
        }
    }

    private int findLongestSubSequence() {
        int maxInStartOfArray = 0;

        int inputArrayLength = inputArray.length;

        int temp = 0;
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

        if(temp != 0)
            temp += maxSubsequenceFromStart;
        maxInStartOfArray = Math.max(temp, maxInStartOfArray);

        int longestSequence = maxInStartOfArray;

        for (int i = longestSubsequence; i > longestSequence ; i--) {
            List<Integer> indexes = indexMaxValueMap.get(i);
            if(indexes.stream().anyMatch(index -> (index + rightShifts) < inputArrayLength)) {
                longestSequence = i;
            }
        }
        return Math.min(longestSequence, k);
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
                if (isNull(indexMaxValueMap.get(longestSequenceIncludingElement)))
                    indexMaxValueMap.put(longestSequenceIncludingElement, new ArrayList<>(Arrays.asList(i)));
                else
                    indexMaxValueMap.get(longestSequenceIncludingElement).add(i);
                if(longestSequenceIncludingElement > this.longestSubsequence)
                    this.longestSubsequence = longestSequenceIncludingElement;
            }
            else
                longestSequenceIncludingElement = 0;
        }
    }
}
