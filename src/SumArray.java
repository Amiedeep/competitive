import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SumArray {
    private final int[] elements;
    private final int sum;

    public SumArray(int[] elements, int sum) {
        this.sum = sum;
        this.elements = elements;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = scanner.nextInt();
        int numberOfElements = scanner.nextInt();

        int[] elements = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            elements[i] = scanner.nextInt();
        }

        SumArray sumArray = new SumArray(elements, sum);

        System.out.println(sumArray.sumExist());
    }

    private int sumExist() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            if(set.contains(sum - elements[i]))
                return 1;
            set.add(elements[i]);
        }
        return 0;
    }
}
