public class BankAccount {
    private float balance;
    private String secretCode;

    public BankAccount(){}
    public BankAccount(float balanceToSet){
        balance = balanceToSet;
    }

    public BankAccount(float balanceToSet, String secretCodeToSet)
    {
        balance = balanceToSet;
        secretCode = secretCodeToSet;
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
        if(this.getSecretCode().equals(anotherAccount.getSecretCode()))
            throw new Exception("Money can't be transferred to the same account");
        anotherAccount.deposit(amount);
    }

    public String getSecretCode()
    {
        return secretCode;
    }
}
