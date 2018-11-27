import matrix.MaxSizeSubMatrix;

public class MaxSumSubmatrix {

    private final int[][] input;
    private int maxSum;

    public MaxSumSubmatrix(int[][] input) {
        this.input = input;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        MaxSumSubmatrix maxSumSubmatrix = new MaxSumSubmatrix(input);
        maxSumSubmatrix.findMaxSum();
        maxSumSubmatrix.printMaxSum();

    }

    private void printMaxSum() {
        System.out.println(maxSum);
    }

    private void findMaxSum() {
        for (int i = 0; i < input[0].length; i++) {
            int[] temp = new int[input.length];
            for (int j = i; j < input[0].length; j++) {
                for (int k = 0; k < input.length; k++) {
                    temp[k] += input[k][j];
                }
                findMaxSumContinuousArray(temp);
            }
        }
    }

    private void findMaxSumContinuousArray(int[] temp) {
        int currentMax = 0;
        for (int i = 0; i < temp.length; i++) {
            currentMax += temp[i];
            if (currentMax < 0)
                currentMax = 0;
            if (currentMax > maxSum)
                maxSum = currentMax;
        }
    }
}
