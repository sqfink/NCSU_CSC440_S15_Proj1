package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Enter inspection date", value=1),
		@SelectionOption(prompt="Enter damage charges", value=2),
		@SelectionOption(prompt="Approve lease termination request", value=3),
		@SelectionOption(prompt="Reject lease termination request", value=4),
		@SelectionOption(prompt="Back", value=5)
})
public class StaffLeaseTerminationMainDialog extends SelectionDialog {

}
