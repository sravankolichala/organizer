package bank;

import javax.enterprise.inject.Produces;

public class BankFactory {

    @Produces
    public Bank createBank() {
        return new BankOfAmerica();
    }
}