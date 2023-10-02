class calendar {
	static void PrintMonth(int month, int year) {
		String monthName = "";
		String monthArray[] = {"January", "Febuarary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int numberOfDays = 0;
		int numberOfDaysArray[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (month < 1 || month > 12)
			System.out.println("Invalid value for the month");
		numberOfDays = numberOfDaysArray[month - 1];
		monthName = monthArray[month - 1];
		if (month == 2 && ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))))
			numberOfDays = 29;


		String yrs = Integer.toString(year);
		if (yrs.length() != 4) {
			System.out.println("Invalid value for the year");
			return;
		}

		//int day = MonthStartsOn(month, year);
		int day = 2;
		System.out.println(monthName + " " + year);
		System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
		System.out.println("| Mon | Tue | Wed | Thu | Fri | Sat | Sun |");
		System.out.println("+-----+-----+-----+-----+-----+-----+-----+");


		//Printing the spaces
		int j = 0;
		for (j = 0; j < day; j++) {
			System.out.print("|     ");
		}
		for (int i = 1; i <= numberOfDays; i++) {
			System.out.print(String.format("%-6s", "| " + i));

			j = j + 1;
			if (j > 6) {
				j = 0;
				System.out.println("|");
				System.out.println("+-----+-----+-----+-----+-----+-----+-----+");

			}
		}
		if (j != 0) {
			while (j <= 7) {
				j = j + 1;
				System.out.print("|     ");
			}
			System.out.println();
			System.out.println("+-----+-----+-----+-----+-----+-----+-----+");

		}


	}
	public static void main(String args[]) {

		PrintMonth(10, 2021);
	}
}



