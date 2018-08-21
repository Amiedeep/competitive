import java.util.Scanner;

//Sheokand is good at mathematics. One day, to test his math skills, Kaali gave him an integer N. To impress Kaali, Sheokand has to convert N into an integer M that can be represented in the form 2x+2y (where x and y are non-negative integers such that x≠y). In order to do that, he can perform two types of operations:
//
//        add 1 to N
//        subtract 1 from N
//        However, Sheokand is preparing for his exams. Can you help him find the minimum number of operations required to convert N into a valid integer M?
public class SheokandAndNumber {

    private final int inputNumber;

    public SheokandAndNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int[] outputs = new int[numberOfTestCases];

        for (int i = 0; i < numberOfTestCases; i++) {
            int inputNumber = scanner.nextInt();
            SheokandAndNumber sheokandAndNumber = new SheokandAndNumber(inputNumber);
            outputs[i] = sheokandAndNumber.countNumberOfOperations();
        }

        for (int output : outputs) {
            System.out.println(output);
        }
    }

    private int countNumberOfOperations() {

        int i, j, count;
        i = j = inputNumber;
        count = 0;
        while (true) {
            if (countSetBits(i) == 2 || countSetBits(j) == 2)
                return count;
            count++;
            i--;
            j++;
        }
    }

    private int countSetBits(int number) {

        int count = 0;
        while (number != 0) {
            count += number & 1;
            number >>= 1;
        }
        return count;
    }
}
