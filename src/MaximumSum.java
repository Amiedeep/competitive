import java.util.*;
import java.util.stream.Stream;

public class MaximumSum {

    private final int[] input;
    private Set<Integer> uniqueSumSet;

    public MaximumSum(int[] input) {
        this.input = input;
        this.uniqueSumSet = new HashSet<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = Integer.parseInt(scanner.nextLine());
        int[] input = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        MaximumSum maximumSum = new MaximumSum(input);

        maximumSum.calculateAllSubArraysSumUnique();
        maximumSum.printMaxSum();

    }

    private void printMaxSum() {
        int sum = uniqueSumSet.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    private void calculateAllSubArraysSumUnique() {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                int maxSubarraySum = findMaxSubArraySum(i, j, input);
                uniqueSumSet.add(maxSubarraySum);
            }
        }
    }

    private int findMaxSubArraySum(int startIndex, int endIndex, int[] inputArray) {

        int[] maxArray = new int[endIndex - startIndex + 1];
        maxArray[0] = inputArray[startIndex];
        for (int i = 1; i < maxArray.length; i++) {
            if (maxArray[i-1] > 0) {
                maxArray[i] = maxArray[i-1] + inputArray[startIndex+i];
                continue;
            }
            maxArray[i] = inputArray[startIndex+1];
        }

        int maxElement = Integer.MIN_VALUE;
        for (int element : maxArray) {
            if(element > maxElement)
                maxElement = element;
        }
        return maxElement;
    }
}
