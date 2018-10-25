import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    private final int[] values;
    private final int requiredSum;

    public SubsetSum(int[] values, int requiredSum) {
        this.values = values;
        this.requiredSum = requiredSum;
    }

    public static void main(String[] args) {

        int[] values = {10, 7, 5, 18, 12, 20, 15};

        SubsetSum subsetSum = new SubsetSum(values, 35);
        List<List<Integer>> subsetsList = subsetSum.findSubsets();
        subsetSum.printSubsets(subsetsList);
    }

    private void printSubsets(List<List<Integer>> subsetsList) {
        for (List<Integer> subset : subsetsList) {
            for (Integer element : subset) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> findSubsets() {
        List<List<Integer>> subsetsList = new ArrayList<List<Integer>>();

        for (int mask = 0; mask < 1 << values.length; mask++) {
            List<Integer> currentSubset = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < values.length; i++) {
                if(((1 << i) & mask) != 0) {
                    sum += values[i];
                    currentSubset.add(values[i]);
                }
            }
            if (sum == requiredSum)
                subsetsList.add(currentSubset);
        }
        return subsetsList;
    }
}
