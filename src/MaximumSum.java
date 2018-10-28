//
//Maximum Sum
//        Given an array  of  integers. Now, you have to output the sum of unique values of the maximum subarray sum of all the possible subarrays of the given array .
//        Note: Subarray means contiguous elements with atleast one element in it.
//
//        Input Format
//
//        The first line of the input contains a single integer , the total number of elements in array .
//        The next line of the input contains  space-separated integers representing the elements of the array.
//
//        Output Format
//
//        The only single line of the output should contain a single integral value representing the answer to the problem.
//
//        Constraints
//
//
//        Sample Input
//        4
//        5 -2 7 -3
//        Sample Output
//        17
//        Explanation
//        Following are the possible number of subarrays and their respective maximum subarray sums:
//
//
//
//
//
//
//
//N>=0 N<=2000
//Ai >=0 Ai <=10pow9
//
//
//
//        Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
import java.util.*;
import java.util.stream.Stream;

public class MaximumSum {

    private final int[] input;
    private Set<Long> uniqueSumSet;

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
        long sum = uniqueSumSet.stream().reduce(0L, (a, b) -> a + b);
        System.out.println(sum);
    }

    private void calculateAllSubArraysSumUnique() {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                long maxSubarraySum = findMaxSubArraySum(i, j, input);
                uniqueSumSet.add(maxSubarraySum);
            }
        }
    }

    private long findMaxSubArraySum(int startIndex, int endIndex, int[] inputArray) {

        long[] maxArray = new long[endIndex - startIndex + 1];
        maxArray[0] = inputArray[startIndex];
        for (int i = 1; i < maxArray.length; i++) {
            if (maxArray[i-1] > 0) {
                maxArray[i] = maxArray[i-1] + inputArray[startIndex+i];
                continue;
            }
            maxArray[i] = inputArray[startIndex+i];
        }

        long maxElement = Long.MIN_VALUE;
        for (long element : maxArray) {
            if(element > maxElement)
                maxElement = element;
        }
        return maxElement;
    }
}
