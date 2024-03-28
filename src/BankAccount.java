public class BankAccount {
    private float balance;
    private String password;
    private int accountNumber;

    public BankAccount(){}
    public BankAccount(float balanceToSet){
        balance = balanceToSet;
    }

    public BankAccount(float balanceToSet, String passwordToSet, int accountNumberToSet)
    {
        balance = balanceToSet;
        password = passwordToSet;
        accountNumber = accountNumberToSet;
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
        if(this.accountNumber == anotherAccount.getAccountNumber())
            throw new Exception("Money can't be transferred to the same account");
        this.withdraw(amount);
        anotherAccount.deposit(amount);
    }

    public String getPassword()
    {
        return password;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }
}
