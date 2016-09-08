package bank;

import javax.inject.Inject;

public class Snippet {
	@Inject
	private Bank bankOfAmerica;

	public Bank getBank() {
		return bankOfAmerica;
	}

	public void setBank(Bank bankOfAmerica) {
		this.bankOfAmerica = bankOfAmerica;
	}
	
	
}

