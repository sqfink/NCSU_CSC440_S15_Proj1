package dialogs.impl.staff;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class StaffAssignDamagesDialog extends InputDialog {
	@InputField(prompt="Specifty damages", failMessage="Invalid input format. Expected alphanumeric (, and - are allowed)", regex="[a-zA-Z0-9,.- $+]+")
	public String str;
}
