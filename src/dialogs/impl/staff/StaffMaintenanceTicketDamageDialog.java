package dialogs.impl.staff;

import dialogs.InputDialog;
import dialogs.annotations.DialogAttributes;
import dialogs.annotations.InputField;

@DialogAttributes(prompt="")
public class StaffMaintenanceTicketDamageDialog extends InputDialog {
	@InputField(prompt="Damage Charges", failMessage="Invalid input. Expected a floating point value with no more than two decimal places", regex="[0-9]+(\\.[0-9]{1,2})?")
	public Double num;
}
