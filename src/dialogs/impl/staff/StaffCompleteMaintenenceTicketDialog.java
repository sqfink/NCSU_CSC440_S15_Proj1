package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Complete", value=1),
		@SelectionOption(prompt="Back", value=2)
})
public class StaffCompleteMaintenenceTicketDialog extends SelectionDialog {

}
