package dialogs.impl.student;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOptions;
import dialogs.annotations.SelectionOption;

@SelectionOptions(options = {
		@SelectionOption(prompt="View invoices", value=1),
		@SelectionOption(prompt="View leases", value=2),
		@SelectionOption(prompt="New request", value=3),
		@SelectionOption(prompt="View request status", value=4),
		@SelectionOption(prompt="Back", value=5)		
})
public class StudentHousingOptionsDialog extends SelectionDialog {

}
