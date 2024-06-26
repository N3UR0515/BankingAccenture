import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> bankAccountList = new ArrayList<>();
        BankAccount bankAccount1 = new BankAccount(100, "aaaa", 1);
        BankAccount bankAccount2 = new BankAccount(200, "bbbb", 2);
        bankAccountList.add(bankAccount1);
        bankAccountList.add(bankAccount2);

        Scanner scanner = new Scanner(System.in);
        BankAccount loggedInto = null;

        while (true) {
            if (loggedInto == null) {
                try{
                    loggedInto = login(scanner, bankAccountList);
                }catch (java.util.InputMismatchException e){
                    System.out.println(e);
                    scanner.nextLine();
                } catch (Exception e){
                    System.out.println(e);
                }

            } else {
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
                                loggedInto.withdraw(amount);
                                break;
                            case 2:
                                System.out.println("Amount to deposit: ");
                                amount = scanner.nextFloat();
                                loggedInto.deposit(amount);
                                break;
                            case 3:
                                System.out.println("Amount to transfer: ");
                                amount = scanner.nextFloat();
                                System.out.println("Who will you transfer it to?");
                                BankAccount temp = findAccount(scanner, bankAccountList);
                                loggedInto.transfer(temp, amount);
                                break;
                            case 4:
                                break;
                            case 5:
                                System.out.println("Goodbye");
                                exit = true;
                                loggedInto = null;
                                break;
                            default:
                                System.out.println("Chosen Option doesn't exist");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                        scanner.nextLine();
                    } finally {
                        if (loggedInto != null)
                            loggedInto.printBalance();
                    }

                } while (!exit);
            }

        }


    }

    public static BankAccount findAccount(Scanner scanner, List<BankAccount> bankAccountList) throws Exception {
        int id = scanner.nextInt();
        for (BankAccount acc : bankAccountList)
            if (acc.getAccountNumber() == id)
            {
                return acc;
            }
        throw new Exception("Account is not found");
    }

    public static BankAccount login(Scanner scanner, List<BankAccount> bankAccountList) throws Exception {
        System.out.println("Provide an id to login");
        BankAccount bankAccount = null;
        bankAccount = findAccount(scanner, bankAccountList);
        System.out.println("Provide a password");
        scanner.nextLine();
        String pass = scanner.nextLine();
        if(!pass.equals(bankAccount.getPassword()))
            throw new Exception("Password is incorrect");
        return bankAccount;
    }
}