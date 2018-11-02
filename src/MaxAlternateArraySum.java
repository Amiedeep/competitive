//The problem is to find maxing sum of an array such that two elements are not adjacent.

public class MaxAlternateArraySum {

    private final int[] input;

    public MaxAlternateArraySum(int[] input) {
        this.input = input;
    }

    public static void main(String[] args) {

//        MaxAlternateArraySum maxAlternateArraySum = new MaxAlternateArraySum(new int[] {5, 5, 10, 100, 10, 5});
//        MaxAlternateArraySum maxAlternateArraySum = new MaxAlternateArraySum(new int[] {1, 2, 3});
//        MaxAlternateArraySum maxAlternateArraySum = new MaxAlternateArraySum(new int[] {1, 20, 3});
        MaxAlternateArraySum maxAlternateArraySum = new MaxAlternateArraySum(new int[] {-1, -2, -5, -3});
        int sum = maxAlternateArraySum.findMaximumAlternateSum();
        System.out.println(sum);
    }

    private int findMaximumAlternateSum() {

        int includingElementSum = 0;
        int temp;
        int excludingElementSum = 0;

        for (int element : input) {
            temp = excludingElementSum;
            excludingElementSum = Math.max(temp, includingElementSum);
            includingElementSum = temp + element;
        }
        return Math.max(includingElementSum, excludingElementSum);
    }
}
