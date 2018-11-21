package November18;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class HMAPPY1 {

    private final int[] inputArray;
    private final int k;
    private int longestSubsequence;
    private int rightShifts;
    private Map<Integer, List<Integer>> indexMaxValueMap;

    public HMAPPY1(int[] inputArray, int k) {
        this.inputArray = inputArray;
        this.k = k;
        indexMaxValueMap = new HashMap<>();
        updateLongestSubSequence();
        updateEndingMaxSubsequence();
    }

    private void updateEndingMaxSubsequence() {
        int maxLength = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 1)
                maxLength++;
            else
                break;
        }
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] == 1) {
                maxLength++;
                updateMap(maxLength, i);
            }
            else
                break;
        }
    }

    private void updateMap(int maxLength, int index) {
        maxLength = Math.min(this.k, maxLength);
        if (nonNull(indexMaxValueMap.get(maxLength)))
            indexMaxValueMap.get(maxLength).add(index);
        else
            indexMaxValueMap.put(maxLength, new ArrayList<>(Arrays.asList(index)));
        if (maxLength > this.longestSubsequence)
            this.longestSubsequence = maxLength;
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
        List<Integer> indexes;
        int maxLength = 0;
        for (int i = this.longestSubsequence; i > maxLength ; i--) {
            indexes = indexMaxValueMap.get(i);
            if (nonNull(indexes)) {
                for (int index : indexes) {
                    int length = inputArray.length;
                    int startIndex = (index + rightShifts) % length;
                    int endIndex = (startIndex + i - 1);

                    if(endIndex > length - 1) {
                        maxLength = Math.max(maxLength, (length - startIndex));
                    }
                    else
                        maxLength = Math.max(maxLength, i);
                }
            }
        }
        return maxLength;
    }


    private void rightShiftArray() {
        this.rightShifts = (this.rightShifts + 1)%inputArray.length;
    }

    private void updateLongestSubSequence() {
        int longestSequenceIncludingElement = 0;
        this.longestSubsequence = 0;
        for (int i = inputArray.length - 1; i >= 0 && this.longestSubsequence <k; i--) {

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
