package dialogs.impl.student;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="New maintinence request:")
public class MaintinenceIssueDialog extends InputDialog {
	@InputField(prompt="Issue (1 word description)", failMessage="Bad input. Expected 1-32 alphanumeric charachters", regex="^[A-Za-z0-9]{1,32}$")
	public String issue;
	
	@InputField(prompt="Description", failMessage="Bad input. Expected 1-256 alpha numeric characters", regex="^[A-Za-z0-9 -.,]{1,256}$")
	public String description;
}
