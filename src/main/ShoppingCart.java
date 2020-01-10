package main;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ShoppingCart {
	
	private static final String APPLE_PRICE = ".6";
	private static final String ORANGE_PRICE = ".25";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter list of apples and oranges split by commas (\",\").");
	
		// Get the user's input into an array of strings
		String userInput = scanner.nextLine();
		String[] groceryArr = userInput.split(",");
				
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println(formatter.format(calculatePrice(groceryArr)));
		
		scanner.close();
	}
	
	/**
	 * Calculates the total price of the items in the grocery array
	 * @param groceryItems - Array of grocery items
	 * @return total price of items
	 */
	private static BigDecimal calculatePrice(String[] groceryItems) {
		
		BigDecimal total = BigDecimal.ZERO;
		
		// Aggregate the price in a simple loop
		for (String item : groceryItems) {
			if (item.toLowerCase().trim().equals("apple")) {
				total = total.add(new BigDecimal(APPLE_PRICE));
			} else if (item.toLowerCase().trim().equals("orange")) {
				total = total.add(new BigDecimal(ORANGE_PRICE));
			}
		}
		
		return total;
	}
}