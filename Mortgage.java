import java.util.*;
import java.text.*;

public class Mortgage {
	private Scanner keyboard = new Scanner(System.in);

	private String acctNum;
	private String lastName;
	private String input;

	private double monthlyPayment = 0;
	private double totalPayment = 0;
	private double interestRate;
	private double mortgageAmount;
	private double termOfLoan;

	public Mortgage() {
		mortgageAmount = 250000;
		termOfLoan = 20;
		interestRate = 0.032;
		acctNum = "N/A";
		lastName = "N/A";
	}

	public Mortgage(String lastNameI, String acctNumI, double intrestRateI, int termOfLoanI, int mortgageAmountI) {
		lastName = lastNameI;
		acctNum = acctNumI;
		interestRate = intrestRateI;
		termOfLoan = termOfLoanI;
		mortgageAmount = mortgageAmountI;

	}

	public static void getIntro() {
		System.out.println();
		System.out.println("Please choose from the following choices below: ");
		System.out.println("1)Promotional Loan (preset loan amount, rate, term) ");
		System.out.println("2)Unique Loan (enter in loan values)");
		System.out.println("3)Quit (Exit the program)");
		System.out.print("Enter your selection here (1-3): ");
	}

	public static Integer invalidInitialInput(int numInput) {
		System.out.println();
		System.out.print("Invalid choice. Please select 1, 2, or 3: ");
		return numInput;
	}

	//
	public void storeLoanAmount() {
		mortgageAmount = 0;

		System.out.print("Enter the amount of the loan (Ex: 75000): ");
		while (mortgageAmount > 1000000 || mortgageAmount < 75000) {

			input = keyboard.nextLine();

			if (input.contains("$") || input.contains(",")) {
				input = input.replace("$", "");
				input = input.replace(",", "");
				mortgageAmount = Double.parseDouble(input);
			} else {
				mortgageAmount = Double.parseDouble(input);
			}

			if (mortgageAmount > 1000000 || mortgageAmount < 75000) {
				System.out.println("Valid Loan Amounts are $75000 - $1000000");
				System.out.print("Re-enter loan amount without $ or commas (Ex: 75000): ");
			}
		} // end while loop
	}

	//
	public void storeTerm() {
		termOfLoan = 0;
		System.out.print("Enter number of years for the loan: ");

		while (termOfLoan < 10 || termOfLoan > 40) {
			input = keyboard.nextLine();

			if (input.contains("years")) {
				input = input.replace("years", "");
				termOfLoan = Double.parseDouble(input);
			} else {
				termOfLoan = Double.parseDouble(input);
			}

			if (termOfLoan < 10 || termOfLoan > 40) {
				System.out.println("Valid Loan Terms are 10-40");
				System.out.print("Re-enter valid number of years: ");
			}
		} // end while loop
	}

	//
	public void storeInterestRate() {
		interestRate = 0;
		System.out.print("Enter yearly interest rate (Ex: 8.25): ");

		while (interestRate < 0.02 || interestRate > 0.07) {
			input = keyboard.nextLine();

			if (input.contains("%")) {
				input = input.replace("%", "");
				interestRate = Double.parseDouble(input);
				interestRate = (interestRate * 0.01);
			} else {
				interestRate = Double.parseDouble(input);
			}

			if (interestRate < 0.02 || interestRate > 0.07) {
				System.out.println("Valid Interest Rates are 2% - 7%");
				System.out.print("Re-enter valid yearly interest rate(Ex: 4.25): ");
			}
		} // end while loop
	}// end interest rate

	//
	public String storeLastName() {

		System.out.print("Enter customer's last name only: ");
		String input = keyboard.nextLine();
		lastName = input;
		return input;
	}

	//
	public void makeAccount() {
		Random r = new Random();
		int numOfAcct;

		numOfAcct = (r.nextInt(9900) + 100);
		acctNum = (lastName + numOfAcct);
	}

	//
	private double calcMonthlyPayment() {
		double months = 12;
		double ratePer = interestRate / months;
		double top1 = Math.pow((1 + (ratePer)), (termOfLoan * months)); // This
																		// is
																		// fine
		double top2 = ((ratePer) * top1); // This is fine
		double bottom1 = Math.pow((1 + (ratePer)), (termOfLoan * months));
		double bottom2 = bottom1 - 1; // This is fine
		monthlyPayment = mortgageAmount * (top2 / bottom2);
		System.out.println();

		return monthlyPayment;
	} // end calcMonthlyPayment
		//

	private double calcTotalPayment() {
		totalPayment = monthlyPayment * 12 * termOfLoan;
		return totalPayment;
	}

	//
	public void promotionalLoan() {
		System.out.println("PROMOTIONAL LOAN");
		//
		System.out.println(toString());
		//
	}

	//
	public void uniqueLoan() {
		System.out.println();
		System.out.print("UNIQUE LOAN");
		//
		System.out.println(toString());
		//
	}

	public void endProgramOutput() {

		System.out.println("PROGRAM COMPLETE");
		System.out.println("Contents of Array...");
		// PRINTS OUT INFO BELOW FOR EACH ACCOUNT
		System.out.println(toString());
		//
	}

	//
	public String toString() {
		calcMonthlyPayment();
		calcTotalPayment();
		return ("\n" + "Account number: " + acctNum + "\n" + "The monthly payment is "
				+ NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(monthlyPayment) + "\n"
				+ "The total payment is "
				+ NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(totalPayment) + "\n");
	}

	//
}// end class
