package com.nextivr.demo.br;

import java.math.BigDecimal;

import com.nextivr.demo.model.Account;

public class MainMenuEval {
	public enum NextAction {
		BILLING, SALES, GENERAL, MAIN_MENU
	};

	/**Evaluate the rules in the following order:
	 * <ol>
	 * <li>The customer says if they have an account balance and their status
	 * flag is D or X, transfer them to the billing department;
	 * <li>if their status is A or Z, skip the main menu and go right to the
	 * Sales menu;
	 * <li>if their primary phone number is not set, transfer them to the
	 * general agent skill;
	 * <li>otherwise, present the main menu options.
	 * </ol>
	 * 
	 * @param acct
	 *            {@link com.nextivr.demo.model.Account}
	 * @return {@link NextAction}
	 */
	public NextAction getNextAction(Account acct) {
		if (acct.getAccountStatus().equals("D") || acct.getAccountStatus().equals("X")) {
			if (acct.getAccountBalance().compareTo(new BigDecimal("0")) > 0) {
				return NextAction.BILLING;
			}
		}
		if (acct.getAccountStatus().equals("A") || acct.getAccountStatus().equals("Z")) {
			return NextAction.SALES;
		}
		if (acct.getPrimaryPhone() == null || acct.getPrimaryPhone().length() == 0) {
			return NextAction.GENERAL;
		}

		return NextAction.MAIN_MENU;
	}

}
