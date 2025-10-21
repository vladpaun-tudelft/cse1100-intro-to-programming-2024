public class Account {

    private int balance;

    /**
     * Creates an empty account
     */
    public Account() {
        this.balance = 0;
    }

    /**
     * Deposits an amount.
     *
     * @param amount The amount
     * @return The new balance
     */
    public int deposit(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount is negative");
        this.balance += amount;
        return balance;
    }

    /**
     * Withdraws an amount.
     *
     * @param amount The amount
     * @return The new balance
     */
    public int withdraw(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount is negative");
        if (balance - amount < 0) throw new IllegalArgumentException("Not enough balance");
        this.balance -= amount;
        return balance;
    }

    /**
     * Gets the balance.
     *
     * @return The balance
     */
    public int getBalance() {
        return balance;
    }

}
