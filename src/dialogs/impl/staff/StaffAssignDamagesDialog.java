package dialogs.impl.staff;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class StaffAssignDamagesDialog extends InputDialog {
	@InputField(prompt="Specifty damages", failMessage="Invalid input format. Expected a two decimal number with no $ sign. Values below 1 must have 0 before decimal", regex="[0-9]+(\\.[0-9]{1,2})?")
	public String str;
}
