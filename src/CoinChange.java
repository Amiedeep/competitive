public class CoinChange {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[] {1, 2, 5};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.change(amount, coins));
    }

    private int change(int amount, int[] coins) {

        int[] change = new int[amount+1];

        change[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                change[j] += change[j-coins[i]];
            }
        }

        return change[amount];
    }
}
