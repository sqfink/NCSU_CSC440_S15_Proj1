package dialogs.impl.student;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class LeaseTermReasonDialog extends InputDialog {
	@InputField(prompt="Reason for lease termination", failMessage="Bad input. Expected 1-140 characters like [a-zA-Z0-9 ,.'!].", regex="^[a-zA-Z0-9 ,.'!]{1,140}$")
	public String reason;
}
