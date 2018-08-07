import java.util.Scanner;


//Chef likes to play with cards a lot.Today,he's playing a game with three cards. Each card has a letter written on the top face and another (possibly identical) letter written on the bottom face. Chef can arbitrarily reorder the cards and/or flip any of the cards in any way he wishes (in particular, he can leave the cards as they were). He wants to do it in such a way that the letters on the top faces of the cards, read left to right, would spell out the name of his favorite friend Bob.
//
//        Determine whether it is possible for Chef to spell"bob"with these cards.
public class SpellCheck {
    private String topFaces;
    private String bottomFaces;

    public SpellCheck(String topFaces, String bottomFaces) {
        this.topFaces = topFaces;
        this.bottomFaces = bottomFaces;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        boolean[] outputs = new boolean[numberOfTestCases];

        for (int i = 0; i < numberOfTestCases; i++) {
            String topFaces = scanner.nextLine();
            String bottomFaces = scanner.nextLine();
            SpellCheck spellCheck = new SpellCheck(topFaces, bottomFaces);

            outputs[i] = spellCheck.canSpell("bob", 0, new boolean[topFaces.length()]);
        }

        for (boolean output : outputs) {
            if (output)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    private boolean canSpell(String expectedOutput, int currentIndex, boolean[] visitedIndices) {
        if(currentIndex >= expectedOutput.length())
            return true;


        if (findCharacterRecursively(expectedOutput, currentIndex, visitedIndices, topFaces)) return true;

        return findCharacterRecursively(expectedOutput, currentIndex, visitedIndices, bottomFaces);

    }

    private boolean findCharacterRecursively(String expectedOutput, int currentIndex, boolean[] visitedIndices, String face) {
        char character = expectedOutput.charAt(currentIndex);
        int index = face.indexOf(character);
        while(index != -1) {
            if(!visitedIndices[index]) {
                visitedIndices[index] = true;
                boolean flag = canSpell(expectedOutput, currentIndex + 1, visitedIndices);
                if (flag)
                    return true;
                visitedIndices[index] = false;
            }
            index = face.indexOf(character, index+1);
        }
        return false;
    }
}
