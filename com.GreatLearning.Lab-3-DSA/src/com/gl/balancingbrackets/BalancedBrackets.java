package com.gl.balancingbrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	static boolean isBalanced(String expr) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < expr.length(); i++) {
			char currentChar = expr.charAt(i);

			if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
				stack.push(currentChar);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				char top = stack.pop();

				if ((top == '(' && currentChar != ')') || (top == '{' && currentChar != '}')
						|| (top == '[' && currentChar != ']')) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("Enter brackets:");
		Scanner in = new Scanner(System.in);
		String brackets = in.nextLine();
		if (isBalanced(brackets))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.err.println("The entered Strings do not contain Balanced Brackets");
		in.close();
	}
}