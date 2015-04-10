package dialogs.impl.parking;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class ParkingLotNumberDialog extends InputDialog {
	@InputField(prompt="Parking lot number", failMessage="Invalid input format. Expected a positive integer", regex="\\d+")
	public Long lotNo;
}
