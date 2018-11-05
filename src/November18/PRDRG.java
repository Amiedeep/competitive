package November18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class PRDRG {

    private final Map<Integer, Integer> keyMap;

    public PRDRG() {
        keyMap = new HashMap<>();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberOfTestCases = input[0];

        PRDRG prdrg = new PRDRG();
        prdrg.initializeMap();
        for (int i = 1; i <= numberOfTestCases; i++) {
            System.out.print(prdrg.findValue(input[i]) + " " + (int)Math.pow(2, input[i]) + " ");
        }
    }

    private int findValue(int i) {
        return keyMap.get(i);
    }

    private void initializeMap() {
        keyMap.put(0, 0);
        for (int i = 1; i < 26; i++) {
            int previousValue = keyMap.get(i-1);
            if(i%2 == 0)
                keyMap.put(i, previousValue*2 - 1);
            else
                keyMap.put(i, previousValue*2 + 1);
        }
    }
}
