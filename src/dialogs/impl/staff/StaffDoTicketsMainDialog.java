package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Change the status of a ticket", value=1),
		@SelectionOption(prompt="Back", value=2)
})
public class StaffDoTicketsMainDialog extends SelectionDialog {
	
}
