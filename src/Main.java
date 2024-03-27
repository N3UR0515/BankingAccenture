import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(100);
        BankAccount bankAccount2 = new BankAccount(200);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the banking system\nWhat would you like to do?\n");
        boolean exit = false;
        do {
            System.out.println("1. Withdraw money\n2. Deposit money\n3. Transfer money\n4. Display current amount\n5. Exit\n");
            try {
                int choice = scanner.nextInt();
                float amount;
                switch (choice) {
                    case 1:
                        System.out.println("Amount to withdraw: ");
                        amount = scanner.nextFloat();
                        bankAccount1.withdraw(amount);
                        break;
                    case 2:
                        System.out.println("Amount to deposit: ");
                        amount = scanner.nextFloat();
                        bankAccount1.deposit(amount);
                        break;
                    case 3:
                        System.out.println("Amount to transfer: ");
                        amount = scanner.nextFloat();
                        bankAccount1.transfer(bankAccount2, amount);
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Goodbye");
                        exit = true;
                        break;
                    default:
                        System.out.println("Chosen Option doesn't exist");
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                bankAccount1.printBalance();
                scanner.nextLine();
            }

        } while (!exit);

    }
}