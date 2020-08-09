package com.goodworklabs.solution;

public class DescendantPalindrome {

	public String reduceToPalidrome(String input) {
		String output = "";
		for (int i = 0; i < input.length() - 1; i++) {
			int sum = 0;
			sum = Integer.parseInt(String.valueOf(input.charAt(i)))
					+ Integer.parseInt(String.valueOf(input.charAt(i + 1)));
			i++;
			output = output + sum;
		}
		return output;
	}

	public boolean findPalindromeNumber(String input) {
		String reverseStr = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + input.charAt(i);
		}
		return input.equals(reverseStr);
	}

	public boolean palindromedescendant(String input) {
		String out = reduceToPalidrome(input);
		boolean result = findPalindromeNumber(out);
		while (result != true) {
			String reduceStr = reduceToPalidrome(out);
			result = findPalindromeNumber(reduceStr);
			out = reduceStr;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DescendantPalindrome fnc = new DescendantPalindrome();
		boolean result = fnc.palindromedescendant("23336014");
		System.out.println(result);
	}

}