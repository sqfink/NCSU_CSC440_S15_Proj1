package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="View pending requests", value=1),
		@SelectionOption(prompt="Tickets", value=2),
		@SelectionOption(prompt="Log Out", value=3)
})
public class StaffMainDialog extends SelectionDialog {
	
}
