import java.util.*;
import java.util.stream.Collectors;

//You are given positive integers N and D. You may perform operations of the following two types:
//
//        add D to N, i.e. change N to N+D
//        change N to digitsum(N)
//        Here, digitsum(x) is the sum of decimal digits of x. For example, digitsum(123)=1+2+3=6, digitsum(100)=1+0+0=1, digitsum(365)=3+6+5=14.
//
//        You may perform any number of operations (including zero) in any order. Please find the minimum obtainable value of N and the minimum number of operations required to obtain this value.
public class MINDSUM {

    private final long inputNumber;
    private final long additionInput;
    private long minimumNumber;
    private long numberOfOperations;
    private final List<Long> visitedIntegers;

    public MINDSUM(long inputNumber, long additionInput, ArrayList<Long> visitedIntegers) {
        this.inputNumber = inputNumber;
        this.additionInput = additionInput;
        this.minimumNumber = inputNumber;
        this.numberOfOperations = 0;
        this.visitedIntegers = visitedIntegers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        String[] outputs = new String[numberOfTestCases];

        for (int i = 0; i < numberOfTestCases; i++) {
            long[] inputNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            MINDSUM mindsum = new MINDSUM(inputNumbers[0], inputNumbers[1], new ArrayList<Long>());
            outputs[i] = mindsum.findLowestWithOperations();
        }

        for (String output : outputs) {
            System.out.println(output);
        }
    }

    private String findLowestWithOperations() {
        long currentNumber = inputNumber;
        long minimumNumberOfOperations = numberOfOperations;
        while(!visitedIntegers.contains(currentNumber)) {
            long temp2 = currentNumber;
            long temp = numberOfOperations;
            while (!(temp2 < 10)) {
                temp = temp + 1;
                temp2 = digitSum(temp2);
                if(temp2 < minimumNumber) {
                    minimumNumber = temp2;
                    minimumNumberOfOperations = temp;
                }
            }
            if (visitedIntegers.contains(temp2))
                break;
            else
                visitedIntegers.add(temp2);
            currentNumber += additionInput;
            numberOfOperations++;
        }
        return minimumNumber + " " + minimumNumberOfOperations;
    }

    private long digitSum(long inputNumber) {
        if(inputNumber == 0)
            return 0;
        else
            return inputNumber%10 + digitSum(inputNumber/10);
    }
}
