import java.util.*;

public class MortgageApp {
	public static void main(String[] args) {
		// INITALIZE NEEDED BEGINING VALUES \\
		Mortgage[] userMortgage = new Mortgage[10]; 
		
		Scanner keyboard = new Scanner(System.in);
		String input;

		int numInput;
		int i = 0; 
		
		boolean isValid = false;
		boolean exitProgram = false;

		// ------------/\/\/\----------------\\

		// TEST TO MAKE SURE THEY ENTERED A CORRECT VALUE \\
		while (exitProgram == false) {

			Mortgage.getIntro(); // User selects 1,2, or 3
			input = keyboard.nextLine();
			numInput = Integer.parseInt(input);

			while (isValid == false) {
				if (numInput == 1 || numInput == 2 || numInput == 3) {
					isValid = true;
				}

				else {
					Mortgage.invalidInitialInput(numInput); // User enters
															// invalid number
					numInput = Integer.parseInt(keyboard.nextLine());
				}
			}
			// --------------------/\/\/\----------------------\\

			// CREATES NEW MORTGAGE OBJECT \\
			userMortgage[i] = null;
			i++; 
			if (i == 10){
				System.out.println("Only 10 accounts can be made! Now exiting...");
				numInput = 3; 
			}
			// -----------/\/\/\------------\\

			if (numInput == 1) {
				userMortgage[i] = new Mortgage();
				//
				userMortgage[i].storeLastName();
				//
				userMortgage[i].makeAccount();
				//
				userMortgage[i].promotionalLoan();
			} // end input 1 if

			if (numInput == 2) {
				userMortgage[i] = new Mortgage();
				//
				userMortgage[i].storeLastName();
				//
				userMortgage[i].makeAccount();
				//
				userMortgage[i].storeLoanAmount();
				//
				userMortgage[i].storeInterestRate();
				//
				userMortgage[i].storeTerm();
				//
				userMortgage[i].uniqueLoan();
			} // end input 2 if

			if (numInput == 3) {
				
				//WHY IS IT POINTING TO NULL???
				for (int counter = 0; counter < i; counter++){
					System.out.println("Printing...");
					System.out.println(userMortgage[counter]);
					if (userMortgage[counter] != null){
					userMortgage[0].endProgramOutput();
					}
					else { counter = i; }
				}
				exitProgram = true;
				
			}
		}
		keyboard.close();
	} // END MAIN
} // END CLASS

// \\

// ------------/\/\/\----------------\\
