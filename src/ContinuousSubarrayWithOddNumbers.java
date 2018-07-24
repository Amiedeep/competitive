import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContinuousSubarrayWithOddNumbers {
    private int[] numbers;
    private int k;
    private List<List> solutionList = new ArrayList<>();
    public ContinuousSubarrayWithOddNumbers(int[] numbers, int k) {
        this.numbers = numbers;
        this.k = k;
    }

    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number of elements");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println("enter number of odd elements allowed");
        int k = scanner.nextInt();
        ContinuousSubarrayWithOddNumbers solution = new ContinuousSubarrayWithOddNumbers(numbers, k);
        for (int i = 0; i < numbers.length; i++) {
            solution.countDistinctSubArrays(Stream.of(numbers[i]).collect(Collectors.toList()), numbers[i] % 2, i+1);
        }

        solution.printSolution();
    }

    private void printSolution() {
        for (List list : solutionList)
            System.out.println(list);
    }

    private void countDistinctSubArrays(List<Integer> subArrayList, int oddElementsCount, int currentIndex) {
        if (oddElementsCount > k)
            return;

        if(solutionList.stream().noneMatch(list -> list.equals(subArrayList)))
            solutionList.add(subArrayList);

        if (currentIndex >= numbers.length)
            return;
        ArrayList<Integer> newList = new ArrayList<>(subArrayList);
        newList.add(numbers[currentIndex]);

        countDistinctSubArrays(newList, oddElementsCount + numbers[currentIndex] % 2, currentIndex + 1);
    }
}