import java.util.Scanner;

public class BankingApplication {

    private static Scanner userInput;
    private static Account account;

    /**
     * Banking application
     * @param args nothing expected
     */
    public static void main(String[] args) {
        userInput = new Scanner(System.in);
        account = new Account();
        BankingOption option;
        do {
            printMenu();
            option = BankingOption.values()[userInput.nextInt()-1];
            executeOption(option);
        } while (option != BankingOption.QUIT);
    }

    private static void printMenu() {
        System.out.println("""
                Please select an option:
                  1 - Show balance
                  2 - Deposit an amount
                  3 - Withdraw an amount
                  4 - Quit""".stripIndent());
    }

    private static void executeOption(BankingOption option) {
        int amount;
        switch (option) {
            case SHOW_BALANCE ->
                    System.out.printf("Balance: €" +"%,d%n", account.getBalance());
            case DEPOSIT -> {
                System.out.println("How much?");
                amount = userInput.nextInt();
                System.out.printf("You now have €" +"%,d%n"  + " left", account.deposit(amount));
            }
            case WITHDRAW -> {
                System.out.println("How much?");
                amount = userInput.nextInt();
                System.out.printf("You have €" +"%,d%n"  + " left", account.withdraw(amount));
            }
        }
    }

}
