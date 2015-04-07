package dialogs.impl.newlease;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOptions;
import dialogs.annotations.SelectionOption;

@SelectionOptions(options={
		@SelectionOption(prompt="Appartment", value=1),
		@SelectionOption(prompt="Residence Hall", value=2),
		@SelectionOption(prompt="Back", value=3),
})
public class HousingTypeSelectionDialog extends SelectionDialog {
	
}
