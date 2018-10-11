//In a regular table tennis match, the player who serves changes every time after 2 points are scored, regardless of which players scored them.
//
//        Chef and Cook are playing a different match — they decided that the player who serves would change every time after K points are scored instead (again regardless of which players scored them). When the game starts, it's Chef's turn to serve.
//
//        You are given the current number of points scored by Chef and Cook (P1 and P2 respectively). Find out whether Chef or Cook has to serve next.

import java.util.Scanner;

public class CHSERVE {

    private final int servePoints;
    private final int chefWins;
    private final int cookWins;

    public CHSERVE(int chefWins, int cookWins, int servePoints) {
        this.chefWins = chefWins;
        this.cookWins = cookWins;
        this.servePoints = servePoints;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        String[] outputs = new String[numberOfTestCases];

        for (int i = 0; i < numberOfTestCases; i++) {
            String[] input = scanner.nextLine().split(" ");

            int chefWins = Integer.parseInt(input[0]);
            int cookWins = Integer.parseInt(input[1]);
            int servePoints = Integer.parseInt(input[2]);
            CHSERVE chServe = new CHSERVE(chefWins, cookWins, servePoints);
            outputs[i] = chServe.findTurn();
        }

        for (String output : outputs) {
            System.out.println(output);
        }
    }

    private String findTurn() {
        int serveMod = (chefWins + cookWins) % (servePoints * 2);
        if (serveMod < servePoints)
            return "CHEF";
        else
            return "COOK";
    }
}
