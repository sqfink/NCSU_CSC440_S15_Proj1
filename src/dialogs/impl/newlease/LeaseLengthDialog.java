package dialogs.impl.newlease;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="One semester", value=1),
		@SelectionOption(prompt="Full year", value=2),
		@SelectionOption(prompt="Back", value=3)
})
public class LeaseLengthDialog extends SelectionDialog {

}
