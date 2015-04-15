package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="New ticket", value=1),
		@SelectionOption(prompt="View tickets", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class StudentMaintinenceDialog extends SelectionDialog {

}
