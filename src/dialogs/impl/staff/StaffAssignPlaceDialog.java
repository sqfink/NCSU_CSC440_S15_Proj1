package dialogs.impl.staff;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class StaffAssignPlaceDialog extends InputDialog {
	@InputField(prompt="Place assignment", failMessage="Invalid input. Expected a non-negative integer", regex="\\d+")
	public Long num;
}
