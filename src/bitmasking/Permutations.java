package bitmasking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter String");

        String input = scanner.nextLine();
        Permutations permutations = new Permutations();

        List<String> output = permutations.findAllPermutations(input);

        permutations.printAllPermutations(output);
    }

    private void printAllPermutations(List<String> output) {
        for (String result: output) {
            System.out.println(result);
        }
    }

    private List<String> findAllPermutations(String input) {
        int mask = 0;
        List<String> result = new ArrayList<>();

        while(mask < 1<<input.length()) {
            String word = "";
            for (int i = 0; i < input.length(); i++) {
                if((mask & 1<<i) != 0) {
                    word = word+input.charAt(i);
                }
            }
            if (!word.isEmpty())
                result.add(word);
            mask++;
        }

        return result;
    }
}
