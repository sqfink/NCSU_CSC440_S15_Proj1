package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Pending housing request", value=1),
		@SelectionOption(prompt="Pending lease termination request", value=2),
		@SelectionOption(prompt="Pedning parking request", value=3),
		@SelectionOption(prompt="Back", value=4),
})
public class StaffRequestsMainDialog extends SelectionDialog {

}
