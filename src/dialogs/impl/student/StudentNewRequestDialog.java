package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="New lease request", value=1),
		@SelectionOption(prompt="Terminate lease request", value=2),
		@SelectionOption(prompt="Back", value=3),
})
public class StudentNewRequestDialog extends SelectionDialog {

}
