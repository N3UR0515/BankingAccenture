public class BankAccount {
    /*
** Optionally make the program interactive with user e.g. using Scanner
     */
    private float balance;

    public BankAccount(){}
    public BankAccount(float balanceToSet){
        balance = balanceToSet;
    }

    private void validateAmount(float amount) throws Exception
    {
        if(amount <= 0)
        {
            throw new Exception("Invalid amount provided");
        }
    }

    public void deposit(float amount) throws Exception {
        validateAmount(amount);
        balance += amount;
    }

    public void withdraw(float amount) throws Exception {
        validateAmount(amount);
        if(amount > balance)
            throw new Exception("Insufficient funds");

        balance -= amount;
    }

    public void printBalance()
    {
        System.out.printf("Current Balance is %.2f%n", balance);
    }

    public void transfer(BankAccount anotherAccount, float amount) throws Exception {
        this.withdraw(amount);
        anotherAccount.deposit(amount);
    }
}
