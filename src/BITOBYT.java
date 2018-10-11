//In the magical land of Byteland, there are three kinds of citizens:
//
//        a Bit - 2ms after a Bit appears, it grows up and becomes a Nibble (i.e. it disappears and a Nibble appears)
//        a Nibble - 8ms after a Nibble appears, it grows up and becomes a Byte
//        a Byte - 16ms after a Byte appears, it grows up, splits into two Bits and disappears
//        Chef wants to know the answer to the following question: what would the population of Byteland be immediately before the time Nms if only 1 Bit appeared at time 0ms?
//
//        Help him and find the population (number of citizens) of each type.

import java.util.Scanner;

public class BITOBYT {
    private final int time;

    public BITOBYT(int time) {
        this.time = time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        String[] outputs = new String[numberOfTestCases];

        for (int i = 0; i < numberOfTestCases; i++) {
            int inputNumber = scanner.nextInt();
            BITOBYT bitoByt = new BITOBYT(inputNumber);
            outputs[i] = bitoByt.findPopulation();
        }

        for (String output : outputs) {
            System.out.println(output);
        }
    }

    private String findPopulation() {
        int iterationsPassed = (time - 1)/26;
        int iterationsPassedMod = (time - 1)%26;

        if(iterationsPassedMod < 2)
            return (long)Math.pow(2, iterationsPassed) +" 0 0";
        else if(iterationsPassedMod < 10)
            return "0 " + (long)Math.pow(2, iterationsPassed) + " 0";
        else
            return "0 0 " + (long)Math.pow(2, iterationsPassed);
    }
}
