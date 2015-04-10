package dialogs.impl.staff;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class StaffAssignInspectionDateDialog extends InputDialog {
	@InputField(prompt="Specifty inspection date (YYYY-MM-DD)", failMessage="Invalid input format. Expected ISO8601 (YYYY-MM-DD)", regex="\\d{4}-\\d{2}-\\d{2}")
	public String str;
}
