package dialogs.impl.staff;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOptions;
import dialogs.annotations.SelectionOption;

@SelectionOptions(options={
		@SelectionOption(prompt="Assign hall housing", value=1),
		@SelectionOption(prompt="Assign appartment housing", value=2),
		@SelectionOption(prompt="Approve request", value=3),
		@SelectionOption(prompt="Refuse request", value=4),
		@SelectionOption(prompt="Back", value=5),
})
public class StaffEditHousingRequestDialog extends SelectionDialog{

}
