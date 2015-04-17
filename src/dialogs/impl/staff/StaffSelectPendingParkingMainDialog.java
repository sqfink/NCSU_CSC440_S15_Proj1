package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Approve lease termination request", value=1),
		@SelectionOption(prompt="Reject lease termination request", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class StaffSelectPendingParkingMainDialog extends SelectionDialog {

}
