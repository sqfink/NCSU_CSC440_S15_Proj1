package statemachine.states;

import java.io.IOException;

import dialogs.impl.StartDialog;
import statemachine.Runner;
import statemachine.State;

public class StartState extends State {

	@Override
	public String doState(Runner r) {
		StartDialog d = new StartDialog();
		int selection = -1;
		try {
			selection = d.doCLIPrompt();
		} catch (IllegalAccessException | IOException e) {
			e.printStackTrace();
			return null;
		}
		switch (selection) {
		case 0:
			return LoginState.class.getName();
		case 1:
			return CreateState.class.getName();
		case 2:
			System.out.println("Bye!");
			return null;
		default:
			System.out.println("Invalid selection");
			return null;
		}
	}

}
