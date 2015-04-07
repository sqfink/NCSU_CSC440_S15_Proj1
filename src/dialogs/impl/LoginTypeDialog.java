package dialogs.impl;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options = {
		@SelectionOption(prompt="Login as student", value=1),
		@SelectionOption(prompt="Login as staff", value=2),
		@SelectionOption(prompt="Login as guest", value=3),
		@SelectionOption(prompt="Back", value=4)
})
public class LoginTypeDialog extends SelectionDialog {

}
