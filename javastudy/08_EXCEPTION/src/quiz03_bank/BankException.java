package quiz03_bank;

public class BankException extends Exception{


	private static final long serialVersionUID = 6483585115162653442L;
	private int errorCode;
	
	public BankException (String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;				
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	// 마이너스 입금 불가, 코드값 1000
	// 마이너스 출금 불가, 코드값 2000
	// 잔액보다 큰 출금 불가, 코드값 2001
	
	
	
	
	
}
