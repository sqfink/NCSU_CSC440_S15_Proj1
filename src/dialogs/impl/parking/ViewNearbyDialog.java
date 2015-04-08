package dialogs.impl.parking;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="By parking lot number", value=1),
		@SelectionOption(prompt="Back", value=2),
})
public class ViewNearbyDialog extends SelectionDialog {

}
