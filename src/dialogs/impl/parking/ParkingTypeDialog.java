package dialogs.impl.parking;

import dialogs.SelectionDialog;
import dialogs.annotations.SelectionOption;
import dialogs.annotations.SelectionOptions;

@SelectionOptions(options={
		@SelectionOption(prompt="Handicapped", value=1),
		@SelectionOption(prompt="Small car", value=2),
		@SelectionOption(prompt="Large car", value=3),
		@SelectionOption(prompt="Bike", value=4),
		@SelectionOption(prompt="Special classification", value=5),
		@SelectionOption(prompt="Back", value=6),
})
public class ParkingTypeDialog extends SelectionDialog {

}
