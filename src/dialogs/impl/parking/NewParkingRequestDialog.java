package dialogs.impl.parking;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Parking lot number", value=1),
		@SelectionOption(prompt="Parking lot type", value=2),
		@SelectionOption(prompt="Submit request", value=3),
		@SelectionOption(prompt="Back", value=4)
})
public class NewParkingRequestDialog extends SelectionDialog {

}
