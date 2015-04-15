package dialogs.impl.newlease;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Housing choice", value=1),
		@SelectionOption(prompt="Lease date span", value=2),
		@SelectionOption(prompt="Payment choice", value=3),
		@SelectionOption(prompt="Submit", value=4),
		@SelectionOption(prompt="Back", value=5)
})
public class NewLeaseMainDialog extends SelectionDialog {

}
