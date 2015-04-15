package dialogs.impl;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class DateDialog extends InputDialog {
	@InputField(prompt="Enter date (YYYY-MM-DD)",failMessage="Input did not match expected format", regex="\\d{4}-\\d{2}-\\d{2}")
	public String startDate;
}
