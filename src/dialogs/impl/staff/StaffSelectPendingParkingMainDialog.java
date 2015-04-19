package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Approve parking request", value=1),
		@SelectionOption(prompt="Reject parking request", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class StaffSelectPendingParkingMainDialog extends SelectionDialog {

}
