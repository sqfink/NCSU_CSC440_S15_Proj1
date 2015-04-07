package dialogs.impl.newlease;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Lease term", value=1),
		@SelectionOption(prompt="Housing choice", value=2),
		@SelectionOption(prompt="Lease start date", value=3),
		@SelectionOption(prompt="Payment choice", value=4),
		@SelectionOption(prompt="Submit", value=5),
		@SelectionOption(prompt="Back", value=6)
})
public class NewLeaseMainDialog extends SelectionDialog {

}
