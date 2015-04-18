package statemachine.states.student;

import helpers.InvoiceManager;

import java.io.IOException;

import dialogs.impl.student.StudentViewInvoicesDialog;
import statemachine.Runner;
import statemachine.State;

public class StudentViewInvoicesState extends State {

	@Override
	public String doState(Runner r) {
		StudentViewInvoicesDialog d = new StudentViewInvoicesDialog();
		int result = -1;
		try {
			InvoiceManager.updateInvoices();
			result = d.doCLIPrompt();
			switch (result) {
			case 1:
				return StudentDisplayCurrentInvoiceState.class.getName();
			case 2:
				return StudentDisplayPastInvoiceState.class.getName();
			case 3:
				return StudentHousingOptionsState.class.getName();
			default:
				System.out.println("Invalid selection");
				return this.getClass().getName();
			}
		} catch (IllegalAccessException | IOException e) {
			System.out.println("Error reading input");
			e.printStackTrace();
		}
		return null;
	}

}
