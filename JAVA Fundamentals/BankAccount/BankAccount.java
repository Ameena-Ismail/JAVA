import java.util.Random;

public class BankAccount {
	public BankAccount() {
		
	}

	String account_number;
	private double checking_balance;
	private double saving_balance ;
	static int numOfAccounts=0;
	static double track ;
	public BankAccount(String account_number, double checking_balance, double saving_balance) {
		super();
		this.account_number = account_number;
		this.checking_balance = checking_balance;
		this.saving_balance = saving_balance;
		numOfAccounts++;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public double getChecking_balance() {
		return checking_balance;
	}
	public void setChecking_balance(double checking_balance) {
		this.checking_balance = checking_balance;
	}
	public double getSaving_balance() {
		return saving_balance;
	}
	public void setSaving_balance(double saving_balance) {
		this.saving_balance = saving_balance;
	}
	public static int getNumOfAccounts() {
		return numOfAccounts;
	}
	public static void setNumOfAccounts(int numOfAccounts) {
		BankAccount.numOfAccounts = numOfAccounts;
	}
	public static double getTrack() {
		return track;
	}
	public static void setTrack(double track) {
		BankAccount.track = track;
	}
	
	private String ten() {
		Random r = new Random ();
		for (int i =1; i<=10;i++) {
			account_number+=r.nextInt(10);
			
			
		}
		return account_number;
		
	}
	
	public void deposit(double amount,int x ) {
		double y=0 ;
		double total;
		if (x==1) {
			y=getChecking_balance()+amount;
			setChecking_balance(y);
			System.out.println("it was adding to the saving balance"+getChecking_balance());
			
		}else if (x==2) {
			y=getSaving_balance()+amount;
			setSaving_balance(y);
			System.out.println("it was adding to the saving balance"+getSaving_balance());
		}
		total = getChecking_balance()+getSaving_balance();
		System.out.println("the total balance is "+total);
		
	}
	
	public void withdraw(double amount,int account) {
		double q=0;
		if(getChecking_balance()<amount ) {
			
		
		if (account ==1 ) {
			q=getChecking_balance()-amount;
			setChecking_balance(q);
		}else 
			System.out.println("u don't have enogh cash in chincking balance ");
		if(getSaving_balance()<amount) {
			
		}else if (account ==2) {
			q=getSaving_balance()-amount;
			setSaving_balance(q);
		}
		}else 
			System.out.println("u don't have enogh cash in saving balance");
			
		
	}
	
	public void print() {
		double total =0;
		total= getChecking_balance()+getSaving_balance();
		System.out.println("the total balance "+total);
	}
	
	
	
	
	

}
