import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Polygon {

    private final List<String> elements;

    public Polygon(List<String> elements) {
        this.elements = elements;
    }

    public static void main(String[] args) {

        List<String> elements = new ArrayList<>();
        elements.add("36 30 36 30");
        elements.add("15 15 15 15");
        elements.add("46 96 90 100");
        elements.add("86 86 86 86");
        elements.add("100 200 100 200");
        elements.add("-100 200 -100 200");

        Polygon polygon = new Polygon(elements);

        System.out.println(polygon.findOutput());
    }

    private String findOutput() {
        int other=0, square=0, rectangle=0;
        for (String element : elements) {
            int[] sides = Arrays.stream(element.split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = sides[0];
            int b = sides[1];
            int c = sides[2];
            int d = sides[3];

            if(Math.min(a,b) < 0 || Math.min(c,d) < 0)
                other++;
            else if (a==b && b==c && c==d)
                square++;
            else if(a==c && b==d)
                rectangle++;
            else
                other++;
        }
        return square+ " " + rectangle + " " + other;
    }
}
