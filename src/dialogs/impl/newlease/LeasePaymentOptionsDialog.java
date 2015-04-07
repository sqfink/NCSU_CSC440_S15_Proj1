package dialogs.impl.newlease;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Monthly", value=1),
		@SelectionOption(prompt="Once per semester", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class LeasePaymentOptionsDialog extends SelectionDialog {

}
