package dialogs.impl.newlease;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOptions;
import dialogs.annotations.SelectionOption;

@SelectionOptions(options={
		@SelectionOption(prompt="Student appartments", value=1),
		@SelectionOption(prompt="Family appartments", value=2),
		@SelectionOption(prompt="Back", value=3),
})
public class AppartmentTypeSelectionDialog extends SelectionDialog {

}
