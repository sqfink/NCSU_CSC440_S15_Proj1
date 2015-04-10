package dialogs.impl.staff;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class StaffAssignRoomDialog extends InputDialog {
	@InputField(prompt="Room number assignment", failMessage="Invalid input. Expected a non-negative integer", regex="\\d+")
	public Long num;
}
