//Given an unsorted array find the maximum distance between two elements satisfying the condition A[i] < A[j] where i < j. There will always be a solution.
//
//        For eg. 6, 9, 3, 2, 10, 2, 3
//


import java.util.Scanner;
import java.util.stream.Stream;

public class ArrayMinMaxDistance {

    private final int[] inputArray;

    public ArrayMinMaxDistance(int[] input) {
        this.inputArray = input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array");
        int[] input = Stream.of(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayMinMaxDistance arrayMinMaxDistance = new ArrayMinMaxDistance(input);

        int output = arrayMinMaxDistance.findMaxDistance();
        System.out.println(output);
    }

    private int findMaxDistance() {
        int inputArrayLength = inputArray.length;
        int[] minElementArray = new int[inputArrayLength];
        int[] maxElementArray = new int[inputArrayLength];

        minElementArray[0] = inputArray[0];
        for (int i = 1; i < inputArrayLength; i++)
            minElementArray[i] = Math.min(minElementArray[i-1], inputArray[i]);

        maxElementArray[inputArrayLength - 1] = inputArray[inputArrayLength - 1];
        for (int i = inputArrayLength - 2; i >= 0; i--)
            maxElementArray[i] = Math.max(maxElementArray[i+1], inputArray[i]);

        int minIndex = 0;
        int maxIndex = 0;
        int maxDistance = 0;
        while(minIndex < inputArrayLength && maxIndex < inputArrayLength) {
            if(minElementArray[minIndex] > maxElementArray[maxIndex]) {
                minIndex++;
            }
            else {
                maxDistance = Math.max(maxDistance, maxIndex - minIndex);
                maxIndex++;
            }
        }
        return maxDistance;
    }
}
