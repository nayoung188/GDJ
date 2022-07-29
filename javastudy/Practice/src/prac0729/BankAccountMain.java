package prac0729;

public class BankAccountMain {

	public static void main(String[] args) {
		
		BankAccount me = new BankAccount ("1234",10000);
		BankAccount mom = new BankAccount ("4321", 100000);
		
		me.deposit(10000);
		me.deposit(-100);
		
		me.withdraw(5000);
		me.withdraw(100);
		
		me.inquiry();
		
		
		
		mom.transfer(me, 5000);
		mom.transfer(me, -100);
		mom.transfer(me, 1000000000);

		mom.inquiry();
		me.inquiry();
		
		
	}

}
