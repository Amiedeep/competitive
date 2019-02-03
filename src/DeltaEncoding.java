import java.util.ArrayList;
import java.util.List;

public class DeltaEncoding {
    private final int[] input;
    private int ESCAPE_TOKEN = -128;

    public DeltaEncoding(int[] input) {
        this.input = input;
    }

    public static void main(String[] args) {
        int[] input = new int[] {25626, 25757, 24367, 24267, 16, 100, 2, 7277};

        DeltaEncoding deltaEncoding = new DeltaEncoding(input);

        List<Integer> output = deltaEncoding.findOutput();
        deltaEncoding.printOutput(output);

    }

    private void printOutput(List<Integer> output) {
        for (int element:output) {
            System.out.print(element + " ");
        }
    }

    private List<Integer> findOutput() {

        List<Integer> output = new ArrayList<>();
        output.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            int diff = input[i] - input[i-1];
            if(Math.abs(diff) > 127) {
                output.add(-128);
                output.add(diff);
            }
            else
                output.add(diff);
        }
        return output;
    }
}
