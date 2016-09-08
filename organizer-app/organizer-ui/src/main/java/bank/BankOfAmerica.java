package bank;
public class BankOfAmerica implements Bank {

    @Override
    public void withdrawal() {
        System.out.println("Withdrawal from Bank of America");
    }

    @Override
    public void deposit() {
        System.out.println("Deposit to Bank of America");
    }
}