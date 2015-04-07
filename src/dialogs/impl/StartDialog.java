package dialogs.impl;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options = {
		@SelectionOption(prompt = "Login", value = 0),
		@SelectionOption(prompt = "Create User", value = 1),
		@SelectionOption(prompt = "Exit", value = 2)
	})
public class StartDialog extends SelectionDialog {
	
}
