package dialogs.impl.parking;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class SpecialParkingTypeDialog extends InputDialog {
	@InputField(prompt="Input special parking classification", failMessage="Classification must be alpha numeric (, and - are allowed)", regex="[ a-zA-Z0-9,-]+")
	public String type;
}
