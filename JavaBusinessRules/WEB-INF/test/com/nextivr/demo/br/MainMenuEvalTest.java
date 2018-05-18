package com.nextivr.demo.br;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.nextivr.demo.br.MainMenuEval.NextAction;
import com.nextivr.demo.model.Account;

public class MainMenuEvalTest {

	@Test
	public void testGetNextActionStatusDBal() {
		Account a = new Account("12345", "000-555-2323", "D", new BigDecimal("1.00"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.BILLING.name(), nextAction.name());

	}

	@Test
	public void testGetNextActionStatusXBal() {
		Account a = new Account("12345", "000-555-2323", "D", new BigDecimal("0.01"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.BILLING.name(), nextAction.name());

	}
	@Test
	public void testGetNextActionStatusDNoBal() {
		Account a = new Account("12345", "000-555-2323", "D", new BigDecimal("0.00"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.MAIN_MENU.name(), nextAction.name());

	}

	@Test
	public void testGetNextActionStatusXNoBal() {
		Account a = new Account("12345", "000-555-2323", "D", new BigDecimal("0.00"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.MAIN_MENU.name(), nextAction.name());

	}

	@Test
	public void testGetNextActionStatusA() {
		Account a = new Account("12345", "000-555-2323", "A", new BigDecimal("0.00"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.SALES.name(), nextAction.name());

	}
	@Test
	public void testGetNextActionStatusZ() {
		Account a = new Account("12345", "000-555-2323", "Z", new BigDecimal("0.00"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.SALES.name(), nextAction.name());

	}
	@Test
	public void testGetNextActionStatusNoPhone() {
		Account a = new Account("12345", "", "Q", new BigDecimal("0.00"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.GENERAL.name(), nextAction.name());

	}
	@Test
	public void testGetNextActionStatusOK() {
		Account a = new Account("12345", "000-555-2323", "Q", new BigDecimal("0.00"), "12345");
		MainMenuEval eval = new MainMenuEval();
		NextAction nextAction = eval.getNextAction(a);
		Assert.assertEquals(NextAction.MAIN_MENU.name(), nextAction.name());

	}
}
