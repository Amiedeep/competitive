package November18;

import java.util.*;
import java.util.stream.Stream;

public class CHHAPPY {
    private Set<Integer> elements;
    private Map<Integer, List<Integer>> map;

    public CHHAPPY() {
        elements = new HashSet<>();
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOftestCases = Integer.parseInt(scanner.nextLine());
        String[] outputs = new String[numberOftestCases];
        CHHAPPY chhappy = new CHHAPPY();
        for (int i = 0; i < numberOftestCases; i++) {
            Integer.parseInt(scanner.nextLine());
            int[] inputArray = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            outputs[i] = chhappy.findChefReaction(inputArray);
        }
        for (String output : outputs) {
            System.out.println(output);
        }

    }

    private String findChefReaction(int[] inputArray) {
        elements.clear();
        map.clear();

        for (int element: inputArray)
            elements.add(element);
        for (int i = 0; i < inputArray.length; i++) {
            if(map.containsKey(inputArray[i])) {
                List<Integer> indexListForElement = map.get(inputArray[i]);
                if(indexListForElement.stream().anyMatch(item -> elements.contains(item)) && elements.contains(i+1))
                    return "Truly Happy";
                indexListForElement.add(i+1);
            }
            else {
                map.put(inputArray[i], new ArrayList<>(Arrays.asList(i+1)));
            }
        }
        return "Poor Chef";
    }


}
